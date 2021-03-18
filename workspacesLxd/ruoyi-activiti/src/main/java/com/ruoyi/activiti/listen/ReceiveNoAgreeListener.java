package com.ruoyi.activiti.listen;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ruoyi.activiti.domain.ActWorkflowFormData;
import com.ruoyi.activiti.mapper.ActWorkflowFormDataMapper;
import com.ruoyi.activiti.mapper.PublicMapper;
import com.ruoyi.activiti.service.IActWorkflowFormDataService;
import com.ruoyi.base.fileManage.service.ICtBuFileService;
import com.ruoyi.collection.domain.CtBuInvoiceInfo;
import com.ruoyi.collection.domain.CtBuInvoiceInfoReq;
import com.ruoyi.collection.domain.CtBuInvoiceReqDto;
import com.ruoyi.collection.domain.CtBuReceiptInfo;
import com.ruoyi.collection.mapper.CtBuInvoiceInfoMapper;
import com.ruoyi.collection.mapper.CtBuInvoiceReqMapper;
import com.ruoyi.collection.service.ICtBuInvoiceInfoService;
import com.ruoyi.collection.service.ICtBuInvoiceReqService;
import com.ruoyi.collection.service.ICtBuReceiptInfoService;
import com.ruoyi.contract.contractInfo.domain.CtBuContract;
import com.ruoyi.contract.contractInfo.mapper.CtBuContractMapper;
import com.ruoyi.mq.bean.SysConstant;
import com.ruoyi.mq.service.MsgService;
import com.ruoyi.paymentManagement.payinfo.mapper.CtBuPayinfoMapper;
import com.ruoyi.paymentManagement.ticketRecord.mapper.TicketRecordMapper;
import com.ruoyi.projectApproval.AppNgc.mapper.AppNgcMapper;
import com.ruoyi.projectApproval.ApprovalNg.mapper.CtBuApprovalNgMapper;
import com.ruoyi.projectApproval.ApprovalNg.service.ICtBuApprovalNgService;
import com.ruoyi.system.service.ISysUserService;
import lombok.extern.slf4j.Slf4j;
import org.activiti.api.task.runtime.TaskRuntime;
import org.activiti.engine.HistoryService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.image.ProcessDiagramGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//import com.ruoyi.mq.config.WebSocketServerEndpoint;


/**
 * 接收消息监听类
 * @author japhet_jiu
 * @version 1.0
 */
@Component
@EnableRabbit
@Slf4j
public class ReceiveNoAgreeListener {
    private final Logger log= LoggerFactory.getLogger(ReceiveNoAgreeListener.class);
    @Autowired
    private RepositoryService repositoryService;

    @Autowired
    private TaskRuntime taskRuntime;
    @Autowired
    private RuntimeService runtimeService;
    @Autowired
    private IActWorkflowFormDataService actWorkflowFormDataService;
    @Autowired
    private TaskService taskService;

    @Autowired
    private HistoryService historyService;
    @Autowired
    private ActWorkflowFormDataMapper actWorkflowFormDataMapper;
    @Autowired
    private ProcessDiagramGenerator processDiagramGenerator;
    @Autowired
    private ICtBuInvoiceReqService iCtBuInvoiceReqService;

    @Autowired
    private ICtBuReceiptInfoService iCtBuReceiptInfoService;
    @Autowired
    PublicMapper publicMapper;

    @Autowired
    private ICtBuInvoiceInfoService iCtBuInvoiceInfoService;
    @Autowired
    private CtBuInvoiceInfoMapper ctBuInvoiceInfoMapper;
    @Autowired
    private RedisTemplate<String, Serializable> redis1;
    @Autowired
    private ISysUserService iSysUserService;
    @Autowired
    private ICtBuApprovalNgService iCtBuApprovalNgService;

    @Autowired
    private CtBuApprovalNgMapper ctBuApprovalNgMapper;

    @Autowired
    private MsgService msgService;

    @Autowired
    private CtBuInvoiceReqMapper ctBuInvoiceReqMapper;
    @Autowired
    private CtBuContractMapper ctBuContractMapper;

    //  AES加密解密
    private String sKey = "785641234654";
    private String ivParamter = "0392039203";
    //queue指要监听列队的名字
    @RabbitListener(queues = SysConstant.SYS_PRO_AUDIT_QUEUE)
    public void reveiverDirectQueue(String message){
        decrypt(message);
    }
    public JSONObject decrypt(String message) {
        try {
            JSONObject object = JSON.parseObject(message);
            //List<ActWorkflowFormData> acwfds = (List<ActWorkflowFormData>)object.get("acwfds");

            List<ActWorkflowFormData> acwfds = JSON.parseArray(object.get("acwfds").toString(), ActWorkflowFormData.class);

            //ProcessInstance processInstance = (ProcessInstance)object.get("processInstance");
//            Map map = (HashMap)object.get("pmap");
            String processDefinitionKey = object.getString("processDefinitionKey");
            String processDefinitionId = object.getString("processDefinitionId");
            String businessKey = object.getString("businessKey");
            //审核不通过修改主表状态
            if(acwfds!=null && acwfds.size()>0){
                for (ActWorkflowFormData data:acwfds) {
                    if("同意".equals(data.getControlValue())) {
                        if ("invoiceAudit".equals(processDefinitionKey)) {
                            //是否进行核销  查询申请金额
                            CtBuInvoiceInfoReq req = new CtBuInvoiceInfoReq();
                            req.setInstranceId(processDefinitionId);
                            List<CtBuInvoiceInfoReq> list = ctBuInvoiceInfoMapper.selectRecInfo(req);
                            if(list!=null && list.size()>0){
                                req = list.get(0);
                                BigDecimal a = (req.getInvoiceAmountTax());
                                // a = a.add(req.getInvoiceAmountTax());
                                BigDecimal b = (new BigDecimal(req.getInvoiceAmountTax1()));
                                CtBuContract ctBuContract = new CtBuContract();
                                CtBuReceiptInfo ctBuReceiptInfo = iCtBuReceiptInfoService.selectCtBuReceiptInfoById(businessKey);
                                CtBuContract ctBuContract1 = ctBuContractMapper.selectCtBuContractById(ctBuReceiptInfo.getContractId());
                                if((a.compareTo(b)==0) ){

                                    ctBuContract.setId(ctBuReceiptInfo.getContractId());
                                    ctBuContract.setReceiveAmount((ctBuContract1.getReceiveAmount()==null?new BigDecimal(0):ctBuContract1.getReceiveAmount()).add(ctBuReceiptInfo.getCollectionAmount()));
                                    ctBuContract.setOutstandingAmount((ctBuContract1.getTotalMoney()==null?new BigDecimal(0):ctBuContract1.getTotalMoney()).subtract((ctBuContract1.getReceiveAmount()==null?new BigDecimal(0):ctBuContract1.getReceiveAmount()).add(ctBuReceiptInfo.getCollectionAmount()==null?new BigDecimal(0):ctBuReceiptInfo.getCollectionAmount())));
                                    ctBuContract.setWriteOffAmount((ctBuContract1.getWriteOffAmount()==null?new BigDecimal(0):ctBuContract1.getWriteOffAmount()).add(req.getInvoiceAmountTax()));
                                    ctBuContract.setNwriteOffAmount((ctBuContract1.getTotalMoney()==null?new BigDecimal(0):ctBuContract1.getTotalMoney()).subtract(ctBuContract1.getWriteOffAmount()==null?new BigDecimal(0):ctBuContract1.getWriteOffAmount()));
                                    ctBuContractMapper.updateCtBuContractAddReceiver(ctBuContract);
                                }else{
                                    ctBuContract.setId(ctBuReceiptInfo.getContractId());
                                    ctBuContract.setReceiveAmount((ctBuContract1.getReceiveAmount()==null?new BigDecimal(0):ctBuContract1.getReceiveAmount()).add(ctBuReceiptInfo.getCollectionAmount()));
                                    ctBuContract.setOutstandingAmount((ctBuContract1.getTotalMoney()==null?new BigDecimal(0):ctBuContract1.getTotalMoney()).subtract((ctBuContract1.getReceiveAmount()==null?new BigDecimal(0):ctBuContract1.getReceiveAmount()).add(ctBuReceiptInfo.getCollectionAmount()==null?new BigDecimal(0):ctBuReceiptInfo.getCollectionAmount())));
                                    ctBuContractMapper.updateCtBuContractAddReceiver(ctBuContract);
                                }

                            }else{
                                CtBuContract ctBuContract = new CtBuContract();
                                CtBuReceiptInfo ctBuReceiptInfo = iCtBuReceiptInfoService.selectCtBuReceiptInfoById(businessKey);
                                ctBuContract.setId(ctBuReceiptInfo.getContractId());
                                ctBuContract.setReceiveAmount(ctBuReceiptInfo.getCollectionAmount());
                                ctBuContract.setOutstandingAmount(ctBuReceiptInfo.getCollectionAmount());
                                ctBuContractMapper.updateCtBuContractAddReceiver(ctBuContract);
                            }

                        }
                    }
                    if("不同意".equals(data.getControlValue())){
                        if("invoiceAudit".equals(processDefinitionKey)){
                            //修改业务表 状态
                            CtBuReceiptInfo req = new CtBuReceiptInfo();
                            req.setInstanceId(processDefinitionId);
                            req.setStatus((long)3);
                            iCtBuReceiptInfoService.updateEndCtBuReceiptInfo(req);

                            req = new CtBuReceiptInfo();
                            req.setInstanceId(processDefinitionId);
                            List<CtBuReceiptInfo> list = iCtBuReceiptInfoService.selectCtBuReceiptInfoList(req);
                            if(list!=null && list.size()>0){
                                CtBuReceiptInfo ctinfo = list.get(0);
                                //修改info表信息
                                CtBuInvoiceInfo info = new CtBuInvoiceInfo();
                                info.setId(ctinfo.getInvoiceId());
                                info.setStatus(7);
                                iCtBuInvoiceInfoService.updateCtBuInvoiceInfo(info);

                            }
                        }
                        if("invoiceApply".equals(processDefinitionKey)){
                            //修改业务表 状态
                            CtBuInvoiceReqDto req = new CtBuInvoiceReqDto();
                            req.setStatus(3);
                            req.setInstanceId(processDefinitionId);
                            iCtBuInvoiceReqService.updatesCtBuInvoiceReq(req);
                        }
                        if("contractAudit".equals(processDefinitionKey)){
                            //合同审核修改业务表 状态
                            publicMapper.updateColumnBy("ct_bu_contract","status",3,"instance_id",processDefinitionId);
                            publicMapper.updateColumnBy("ct_bu_contract","status_ps","审核驳回","instance_id",processDefinitionId);
                        }

                        if("cliquish_project".equals(processDefinitionKey) || "important_project".equals(processDefinitionKey)){
                            //集客类项目（针对框架类协议业务点位新增、小集客业务政策申请）修改业务表 状态
                            publicMapper.updateColumnBy("ct_bu_approval_ng","status",3,"instance_id",processDefinitionId);
                            publicMapper.updateColumnBy("ct_bu_approval_ng","status_ps","审核驳回","instance_id",processDefinitionId);
                        }

                        if("fjkxmUp".equals(processDefinitionKey)){
                            //合同审核修改业务表 状态
                            publicMapper.updateColumnBy("ct_bu_approval_ngc","status",3,"instance_id",processDefinitionId);
                            publicMapper.updateColumnBy("ct_bu_approval_ngc","status_ps","审核驳回","instance_id",processDefinitionId);
                        }
                        if("fjkxmDown".equals(processDefinitionKey)){
                            //合同审核修改业务表 状态
                            publicMapper.updateColumnBy("ct_bu_approval_ngc","status",3,"instance_id",processDefinitionId);
                            publicMapper.updateColumnBy("ct_bu_approval_ngc","status_ps","审核驳回","instance_id",processDefinitionId);
                        }
                        if("xmlx2".equals(processDefinitionKey) || "xmlx3".equals(processDefinitionKey)
                                || "xmlx4".equals(processDefinitionKey)){
                            //合同审核修改业务表 状态
                            publicMapper.updateColumnBy("ct_bu_approval_ng","status",3,"instance_id",processDefinitionId);
                            publicMapper.updateColumnBy("ct_bu_approval_ng","status_ps","审核驳回","instance_id",processDefinitionId);
                        }
                        if("ticket_record_audit".equals(processDefinitionKey)){
                            //收票记录审核
                            publicMapper.updateColumnBy("ct_bu_ticket_record","status",3,"instance_id",processDefinitionId);
                            publicMapper.updateColumnBy("ct_bu_ticket_record","statusps","审核驳回","instance_id",processDefinitionId);
                        }
                        if("payinfo_audit".equals(processDefinitionKey)){
                            //收票记录审核
                            publicMapper.updateColumnBy("ct_bu_payinfo","status",3,"instance_id",processDefinitionId);
                            publicMapper.updateColumnBy("ct_bu_payinfo","statusPS","审核驳回","instance_id",processDefinitionId);
                        }

                    }
                }
            }




            return object;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}

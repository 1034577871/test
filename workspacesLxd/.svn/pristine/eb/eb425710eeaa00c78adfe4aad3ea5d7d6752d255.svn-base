package com.ruoyi.activiti.config;

import com.ruoyi.contract.contractInfo.domain.CtBuContract;
import com.ruoyi.contract.contractInfo.mapper.CtBuContractMapper;
import com.ruoyi.paymentManagement.payinfo.domain.CtBuPayinfo;
import com.ruoyi.paymentManagement.payinfo.service.ICtBuPayinfoService;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.ExecutionListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;


/**
 * 请假流程结束监听器
 *
 * @author: Henry Yan
 */
@Service
@Transactional
public class PayinfoAuditEnd implements ExecutionListener {

    protected Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private ICtBuPayinfoService iCtBuPayinfoService;

    @Autowired
    private CtBuContractMapper ctBuContractMapper;


    @Override
    public void notify(DelegateExecution execution) {
        //流程正常结束
        String processInstanceId = execution.getProcessInstanceId();
        CtBuPayinfo ctBuPayinfo = new CtBuPayinfo();
        ctBuPayinfo.setInstanceId(processInstanceId);
        ctBuPayinfo.setStatus(2);
        ctBuPayinfo.setStatusps("审核通过");
        iCtBuPayinfoService.updateCtBuPayinfoByInstanceId(ctBuPayinfo);

        CtBuPayinfo ctBuPayinfo1 = iCtBuPayinfoService.selectCtBuPayinfoByInstanceId(processInstanceId);

        //修改合同表已收金额与未收金额
        if(ctBuPayinfo1 != null && ctBuPayinfo1.getContractId() != null && ctBuPayinfo1.getAppliedAmount() != null){
            CtBuContract ctBuContract = ctBuContractMapper.selectCtBuContractById(ctBuPayinfo1.getContractId());
            if (ctBuContract != null && ctBuContract.getReceiveAmount() != null && ctBuContract.getTotalMoney() != null){
                BigDecimal add = ctBuPayinfo1.getAppliedAmount().add(ctBuContract.getReceiveAmount());
                BigDecimal subtract = ctBuContract.getTotalMoney().subtract(add);
                ctBuContract.setReceiveAmount(add);
                ctBuContract.setOutstandingAmount(subtract);
                ctBuContractMapper.updateCtBuContract(ctBuContract);
            }
        }
        logger.debug("清理了 {} 条历史表单数据");
    }
}

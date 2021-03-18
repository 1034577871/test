package com.ruoyi.activiti.config;

import com.ruoyi.collection.domain.CtBuInvoiceInfo;
import com.ruoyi.collection.domain.CtBuReceiptInfo;
import com.ruoyi.collection.service.ICtBuInvoiceInfoService;
import com.ruoyi.collection.service.ICtBuReceiptInfoService;
import com.ruoyi.contract.contractInfo.mapper.CtBuContractMapper;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.ExecutionListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 *
 * @author: Henry Yan
 */
@Service
@Transactional
public class InvoiceAuditProcessEndListener implements ExecutionListener {

    protected Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private ICtBuReceiptInfoService iCtBuReceiptInfoService;

    @Autowired
    private ICtBuInvoiceInfoService iCtBuInvoiceInfoService;

    @Autowired
    private CtBuContractMapper ctBuContractMapper;

    @Override
    public void notify(DelegateExecution execution) {
        //流程正常结束
        String processInstanceId = execution.getProcessInstanceId();
        CtBuReceiptInfo req = new CtBuReceiptInfo();
        req.setInstanceId(processInstanceId);
        req.setStatus((long)2);
        iCtBuReceiptInfoService.updateEndCtBuReceiptInfo(req);
        req = new CtBuReceiptInfo();
        req.setInstanceId(processInstanceId);
        List<CtBuReceiptInfo> list = iCtBuReceiptInfoService.selectCtBuReceiptInfoList(req);
        if(list!=null && list.size()>0){
            CtBuReceiptInfo ctinfo = list.get(0);
            //修改info表信息
            CtBuInvoiceInfo info = new CtBuInvoiceInfo();
            info.setId(ctinfo.getInvoiceId());
            info.setStatus(6);
            iCtBuInvoiceInfoService.updateCtBuInvoiceInfo(info);

        }

    }
}

package com.ruoyi.quartz.task;


import com.ruoyi.contract.contractInfo.service.ICtBuContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component("contractTask")
public class ContractTask {

    @Autowired
    private ICtBuContractService iCtBuContractService;

    public void selectWarning(){
        System.err.println("查询预警");
        iCtBuContractService.selectWarning();
    }
}

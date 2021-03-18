package com.ruoyi.collection.controller;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.contract.contractInfo.domain.CtBuContract;
import com.ruoyi.contract.contractInfo.service.ICtBuContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/commonUtilControl")
public class CommonUtilControl  extends BaseController {

    @Autowired
    private ICtBuContractService ctBuContractService;
    /**
     * 查询合同信息录入主列表
     */
    @GetMapping("/list")
    public TableDataInfo list(CtBuContract ctBuContract) {
        startPage();
        List<CtBuContract> list = ctBuContractService.selectCtBuContractList(ctBuContract);
        return getDataTable(list);
    }

}

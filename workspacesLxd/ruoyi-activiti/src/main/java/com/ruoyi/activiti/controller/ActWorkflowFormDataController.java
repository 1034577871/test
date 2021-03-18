package com.ruoyi.activiti.controller;

import com.ruoyi.activiti.domain.ActWorkflowFormData;
import com.ruoyi.activiti.service.IActWorkflowFormDataService;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/workFlowFormData")
public class ActWorkflowFormDataController extends BaseController {
    @Autowired
    private IActWorkflowFormDataService  iActWorkflowFormDataService;
    /**
     * 查询财务开票列表
     */
//    @PreAuthorize("@ss.hasPermi('workFlowFormData:list')")
    @GetMapping("/list")
    public List<ActWorkflowFormData> list(ActWorkflowFormData actWorkflowFormData)
    {
        List<ActWorkflowFormData> list = iActWorkflowFormDataService.selectGroupActWorkflowFormDataList(actWorkflowFormData);
        return list;
    }

    /**
     * 新增发票申请
     */
    @Log(title = "申请记录", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    public AjaxResult add(@RequestBody ActWorkflowFormData actWorkflowFormData)
    {
        return toAjax(iActWorkflowFormDataService.insertActWorkflowFormData(actWorkflowFormData));
    }


    /**
     * 根据businessKey查询
     * @param businessKey
     * @return
     */
    @GetMapping(value = "/{businessKey}")
    public List<ActWorkflowFormData> selectActWorkflowFormDataByBusinessKey(@PathVariable("businessKey") String businessKey){
        return iActWorkflowFormDataService.selectActWorkflowFormDataByBusinessKey(businessKey);
    }
}

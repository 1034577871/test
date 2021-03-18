package com.ruoyi.contract.contractContent.controller;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.contract.contractContent.domain.CtBuContractContent;
import com.ruoyi.contract.contractContent.service.ICtBuContractContentService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 合同内容Controller
 *
 * @author ruoyi
 * @date 2020-12-09
 */
@RestController
@RequestMapping("/contract/contractContent")
public class CtBuContractContentController extends BaseController {
    @Autowired
    private ICtBuContractContentService ctBuContractContentService;

    /**
     * 查询合同内容列表
     */
    @PreAuthorize("@ss.hasPermi('contract:contractContent:list')")
    @GetMapping("/list")
    public TableDataInfo list(CtBuContractContent ctBuContractContent) {
        startPage();
        List<CtBuContractContent> list = ctBuContractContentService.selectCtBuContractContentList(ctBuContractContent);
        return getDataTable(list);
    }

    /**
     * 导出合同内容列表
     */
    @PreAuthorize("@ss.hasPermi('contract:contractContent:export')")
    @Log(title = "合同内容", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(CtBuContractContent ctBuContractContent) {
        List<CtBuContractContent> list = ctBuContractContentService.selectCtBuContractContentList(ctBuContractContent);
        ExcelUtil<CtBuContractContent> util = new ExcelUtil<CtBuContractContent>(CtBuContractContent.class);
        return util.exportExcel(list, "content");
    }

    /**
     * 获取合同内容详细信息
     */
    @PreAuthorize("@ss.hasPermi('contract:contractContent:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id) {
        return AjaxResult.success(ctBuContractContentService.selectCtBuContractContentById(id));
    }

    /**
     * 新增合同内容
     */
    @PreAuthorize("@ss.hasPermi('contract:contractContent:add')")
    @Log(title = "合同内容", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CtBuContractContent ctBuContractContent) {
        return toAjax(ctBuContractContentService.insertCtBuContractContent(ctBuContractContent));
    }

    /**
     * 修改合同内容
     */
    @PreAuthorize("@ss.hasPermi('contract:contractContent:edit')")
    @Log(title = "合同内容", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CtBuContractContent ctBuContractContent) {
        return toAjax(ctBuContractContentService.updateCtBuContractContent(ctBuContractContent));
    }

    /**
     * 删除合同内容
     */
    @PreAuthorize("@ss.hasPermi('contract:contractContent:remove')")
    @Log(title = "合同内容", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids) {
        return toAjax(ctBuContractContentService.updateCtBuContractContentByIds(ids));
    }

}

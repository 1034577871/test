package com.ruoyi.contract.contractPayinfo.controller;

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
import com.ruoyi.contract.contractPayinfo.domain.CtBuContractPayinfo;
import com.ruoyi.contract.contractPayinfo.service.ICtBuContractPayinfoService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 合同付款Controller
 *
 * @author ruoyi
 * @date 2020-12-10
 */
@RestController
@RequestMapping("/contract/contractPayinfo")
public class CtBuContractPayinfoController extends BaseController {
    @Autowired
    private ICtBuContractPayinfoService ctBuContractPayinfoService;

    /**
     * 查询合同付款列表
     */
    @PreAuthorize("@ss.hasPermi('contract:contractPayinfo:list')")
    @GetMapping("/list")
    public TableDataInfo list(CtBuContractPayinfo ctBuContractPayinfo) {
        startPage();
        List<CtBuContractPayinfo> list = ctBuContractPayinfoService.selectCtBuContractPayinfoList(ctBuContractPayinfo);
        return getDataTable(list);
    }

    /**
     * 导出合同付款列表
     */
    @PreAuthorize("@ss.hasPermi('contract:contractPayinfo:export')")
    @Log(title = "合同付款", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(CtBuContractPayinfo ctBuContractPayinfo) {
        List<CtBuContractPayinfo> list = ctBuContractPayinfoService.selectCtBuContractPayinfoList(ctBuContractPayinfo);
        ExcelUtil<CtBuContractPayinfo> util = new ExcelUtil<CtBuContractPayinfo>(CtBuContractPayinfo.class);
        return util.exportExcel(list, "contractPayinfo");
    }

    /**
     * 获取合同付款详细信息
     */
    @PreAuthorize("@ss.hasPermi('contract:contractPayinfo:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id) {
        return AjaxResult.success(ctBuContractPayinfoService.selectCtBuContractPayinfoById(id));
    }

    /**
     * 新增合同付款
     */
    @PreAuthorize("@ss.hasPermi('contract:contractPayinfo:add')")
    @Log(title = "合同付款", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CtBuContractPayinfo ctBuContractPayinfo) {
        return toAjax(ctBuContractPayinfoService.insertCtBuContractPayinfo(ctBuContractPayinfo));
    }

    /**
     * 修改合同付款
     */
    @PreAuthorize("@ss.hasPermi('contract:contractPayinfo:edit')")
    @Log(title = "合同付款", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CtBuContractPayinfo ctBuContractPayinfo) {
        return toAjax(ctBuContractPayinfoService.updateCtBuContractPayinfo(ctBuContractPayinfo));
    }

    /**
     * 删除合同付款
     */
    @PreAuthorize("@ss.hasPermi('contract:contractPayinfo:remove')")
    @Log(title = "合同付款", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids) {
        return toAjax(ctBuContractPayinfoService.updateCtBuContractPayinfoByIds(ids));
    }

    /**
     * 查询合同付款列表
     */
    @PreAuthorize("@ss.hasPermi('contract:contractPayinfo:list')")
    @GetMapping("/selectCtBuContractPayinfoListConcat")
    public TableDataInfo selectCtBuContractPayinfoListConcat(CtBuContractPayinfo ctBuContractPayinfo) {
        startPage();
        List<CtBuContractPayinfo> list = ctBuContractPayinfoService.selectCtBuContractPayinfoListConcat(ctBuContractPayinfo);
        return getDataTable(list);
    }
}

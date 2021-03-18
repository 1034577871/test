package com.ruoyi.contract.payinfoInvoice.controller;

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
import com.ruoyi.contract.payinfoInvoice.domain.CtBuPayinfoInvoice;
import com.ruoyi.contract.payinfoInvoice.service.ICtBuPayinfoInvoiceService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 付款周期-发票对应关系Controller
 *
 * @author ruoyi
 * @date 2021-01-14
 */
@RestController
@RequestMapping("/contract/payinfoInvoice")
public class CtBuPayinfoInvoiceController extends BaseController {
    @Autowired
    private ICtBuPayinfoInvoiceService ctBuPayinfoInvoiceService;

    /**
     * 查询付款周期-发票对应关系列表
     */
    @PreAuthorize("@ss.hasPermi('contract:payinfoInvoice:list')")
    @GetMapping("/list")
    public TableDataInfo list(CtBuPayinfoInvoice ctBuPayinfoInvoice) {
        startPage();
        List<CtBuPayinfoInvoice> list = ctBuPayinfoInvoiceService.selectCtBuPayinfoInvoiceList(ctBuPayinfoInvoice);
        return getDataTable(list);
    }

    /**
     * 导出付款周期-发票对应关系列表
     */
    @PreAuthorize("@ss.hasPermi('contract:payinfoInvoice:export')")
    @Log(title = "付款周期-发票对应关系", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(CtBuPayinfoInvoice ctBuPayinfoInvoice) {
        List<CtBuPayinfoInvoice> list = ctBuPayinfoInvoiceService.selectCtBuPayinfoInvoiceList(ctBuPayinfoInvoice);
        ExcelUtil<CtBuPayinfoInvoice> util = new ExcelUtil<CtBuPayinfoInvoice>(CtBuPayinfoInvoice.class);
        return util.exportExcel(list, "payinfoInvoice");
    }

    /**
     * 获取付款周期-发票对应关系详细信息
     */
    @PreAuthorize("@ss.hasPermi('contract:payinfoInvoice:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id) {
        return AjaxResult.success(ctBuPayinfoInvoiceService.selectCtBuPayinfoInvoiceById(id));
    }

    /**
     * 新增付款周期-发票对应关系
     */
    @PreAuthorize("@ss.hasPermi('contract:payinfoInvoice:add')")
    @Log(title = "付款周期-发票对应关系", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CtBuPayinfoInvoice ctBuPayinfoInvoice) {
        return toAjax(ctBuPayinfoInvoiceService.insertCtBuPayinfoInvoice(ctBuPayinfoInvoice));
    }

    /**
     * 修改付款周期-发票对应关系
     */
    @PreAuthorize("@ss.hasPermi('contract:payinfoInvoice:edit')")
    @Log(title = "付款周期-发票对应关系", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CtBuPayinfoInvoice ctBuPayinfoInvoice) {
        return toAjax(ctBuPayinfoInvoiceService.updateCtBuPayinfoInvoice(ctBuPayinfoInvoice));
    }

    /**
     * 删除付款周期-发票对应关系
     */
    @PreAuthorize("@ss.hasPermi('contract:payinfoInvoice:remove')")
    @Log(title = "付款周期-发票对应关系", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids) {
        return toAjax(ctBuPayinfoInvoiceService.deleteCtBuPayinfoInvoiceByIds(ids));
    }
}

package com.ruoyi.paymentManagement.payinfo.controller;

import java.math.BigDecimal;
import java.util.List;

import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.paymentManagement.payinfo.domain.CtBuPayinfo;
import com.ruoyi.paymentManagement.payinfo.service.ICtBuPayinfoService;
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

import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 付款申请单主Controller
 * 
 * @author ruoyi
 * @date 2021-01-12
 */
@RestController
@RequestMapping("/paymentManagement/payinfo")
public class CtBuPayinfoController extends BaseController
{
    @Autowired
    private ICtBuPayinfoService ctBuPayinfoService;

    /**
     * 查询付款申请单主列表
     */
//    @PreAuthorize("@ss.hasPermi('paymentManagement:payinfo:list')")
    @GetMapping("/list1")
    public TableDataInfo list1(CtBuPayinfo ctBuPayinfo)
    {
        startPage();
        List<CtBuPayinfo> list = ctBuPayinfoService.selectCtBuPayinfoList1(ctBuPayinfo);
        return getDataTable(list);
    }
    /**
     * 查询付款申请单主列表
     */
//    @PreAuthorize("@ss.hasPermi('paymentManagement:payinfo:list')")
    @GetMapping("/list")
    public TableDataInfo list(CtBuPayinfo ctBuPayinfo)
    {
        startPage();
        List<CtBuPayinfo> list = ctBuPayinfoService.selectCtBuPayinfoList(ctBuPayinfo);
        return getDataTable(list);
    }

    /**
     * 导出付款申请单主列表
     */
    @PreAuthorize("@ss.hasPermi('paymentManagement:payinfo:export')")
    @Log(title = "付款申请单主", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(CtBuPayinfo ctBuPayinfo)
    {
        List<CtBuPayinfo> list = ctBuPayinfoService.selectCtBuPayinfoList(ctBuPayinfo);
        ExcelUtil<CtBuPayinfo> util = new ExcelUtil<CtBuPayinfo>(CtBuPayinfo.class);
        return util.exportExcel(list, "payinfo");
    }

    /**
     * 获取付款申请单主详细信息
     */
//    @PreAuthorize("@ss.hasPermi('paymentManagement:payinfo:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return AjaxResult.success(ctBuPayinfoService.selectCtBuPayinfoById(id));
    }

    /**
     * 新增付款申请单主
     */
//    @PreAuthorize("@ss.hasPermi('paymentManagement:payinfo:add')")
    @Log(title = "付款申请单主", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CtBuPayinfo ctBuPayinfo)
    {
        return toAjax(ctBuPayinfoService.insertCtBuPayinfo(ctBuPayinfo));
    }

    /**
     * 修改付款申请单主
     */
//    @PreAuthorize("@ss.hasPermi('paymentManagement:payinfo:edit')")
    @Log(title = "付款申请单主", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CtBuPayinfo ctBuPayinfo)
    {
        return toAjax(ctBuPayinfoService.updateCtBuPayinfo(ctBuPayinfo));
    }

    /**
     * 删除付款申请单主
     */
    @PreAuthorize("@ss.hasPermi('paymentManagement:payinfo:remove')")
    @Log(title = "付款申请单主", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(ctBuPayinfoService.deleteCtBuPayinfoByIds(ids));
    }

    /**
     * 批量逻辑删除付款申请单主
     */
    @PreAuthorize("@ss.hasPermi('paymentManagement:payinfo:remove')")
    @Log(title = "付款申请单主", businessType = BusinessType.UPDATE)
    @PutMapping("/{ids}")
    public AjaxResult editRemove(@PathVariable String[] ids)
    {
        return toAjax(ctBuPayinfoService.updateCtBuPayinfoByIds(ids));
    }

    /**
     * 付款核销
     */
    @PreAuthorize("@ss.hasPermi('paymentManagement:payinfo:paymentWriteOff')")
    @Log(title = "付款申请单主", businessType = BusinessType.UPDATE)
    @PutMapping("/paymentWriteOff")
    public AjaxResult paymentWriteOff(@RequestBody CtBuPayinfo ctBuPayinfo)
    {
        return toAjax(ctBuPayinfoService.paymentWriteOff(ctBuPayinfo));
    }

    @GetMapping("/countAppliedAmountByContractIdPayment/{contractId}")
    public String countAppliedAmountByContractIdPayment(@PathVariable("contractId") String contractId){
        System.err.println(contractId);
        return ctBuPayinfoService.countAppliedAmountByContractIdPayment(contractId);
    }
}

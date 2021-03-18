package com.ruoyi.paymentManagement.payinfoDt.controller;

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
import com.ruoyi.paymentManagement.payinfoDt.domain.CtBuPayinfoDt;
import com.ruoyi.paymentManagement.payinfoDt.service.ICtBuPayinfoDtService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 付款申请单明细Controller
 * 
 * @author ruoyi
 * @date 2021-01-12
 */
@RestController
@RequestMapping("/payinfoDt/payinfoDt")
public class CtBuPayinfoDtController extends BaseController
{
    @Autowired
    private ICtBuPayinfoDtService ctBuPayinfoDtService;

    /**
     * 查询付款申请单明细列表
     */
    @PreAuthorize("@ss.hasPermi('payinfoDt:payinfoDt:list')")
    @GetMapping("/list")
    public TableDataInfo list(CtBuPayinfoDt ctBuPayinfoDt)
    {
        startPage();
        List<CtBuPayinfoDt> list = ctBuPayinfoDtService.selectCtBuPayinfoDtList(ctBuPayinfoDt);
        return getDataTable(list);
    }

    /**
     * 导出付款申请单明细列表
     */
    @PreAuthorize("@ss.hasPermi('payinfoDt:payinfoDt:export')")
    @Log(title = "付款申请单明细", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(CtBuPayinfoDt ctBuPayinfoDt)
    {
        List<CtBuPayinfoDt> list = ctBuPayinfoDtService.selectCtBuPayinfoDtList(ctBuPayinfoDt);
        ExcelUtil<CtBuPayinfoDt> util = new ExcelUtil<CtBuPayinfoDt>(CtBuPayinfoDt.class);
        return util.exportExcel(list, "payinfoDt");
    }

    /**
     * 获取付款申请单明细详细信息
     */
    @PreAuthorize("@ss.hasPermi('payinfoDt:payinfoDt:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return AjaxResult.success(ctBuPayinfoDtService.selectCtBuPayinfoDtById(id));
    }

    /**
     * 新增付款申请单明细
     */
    @PreAuthorize("@ss.hasPermi('payinfoDt:payinfoDt:add')")
    @Log(title = "付款申请单明细", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CtBuPayinfoDt ctBuPayinfoDt)
    {
        return toAjax(ctBuPayinfoDtService.insertCtBuPayinfoDt(ctBuPayinfoDt));
    }

    /**
     * 修改付款申请单明细
     */
    @PreAuthorize("@ss.hasPermi('payinfoDt:payinfoDt:edit')")
    @Log(title = "付款申请单明细", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CtBuPayinfoDt ctBuPayinfoDt)
    {
        return toAjax(ctBuPayinfoDtService.updateCtBuPayinfoDt(ctBuPayinfoDt));
    }

    /**
     * 删除付款申请单明细
     */
    @PreAuthorize("@ss.hasPermi('payinfoDt:payinfoDt:remove')")
    @Log(title = "付款申请单明细", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(ctBuPayinfoDtService.deleteCtBuPayinfoDtByIds(ids));
    }
}

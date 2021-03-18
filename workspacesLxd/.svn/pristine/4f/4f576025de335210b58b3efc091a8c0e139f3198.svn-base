package com.ruoyi.collection.controller;

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
import com.ruoyi.collection.domain.CtBuInvoiceReqDetail;
import com.ruoyi.collection.service.ICtBuInvoiceReqDetailService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 发票申请明细Controller
 * 
 * @author ruoyi
 * @date 2020-12-09
 */
@RestController
@RequestMapping("/collectionDetailDetail/collectionDetailDetail")
public class CtBuInvoiceReqDetailController extends BaseController
{
    @Autowired
    private ICtBuInvoiceReqDetailService ctBuInvoiceReqDetailService;

    /**
     * 查询发票申请明细列表
     */
    @PreAuthorize("@ss.hasPermi('collectionDetail:collectionDetail:list')")
    @GetMapping("/list")
    public TableDataInfo list(CtBuInvoiceReqDetail ctBuInvoiceReqDetail)
    {
        startPage();
        List<CtBuInvoiceReqDetail> list = ctBuInvoiceReqDetailService.selectCtBuInvoiceReqDetailList(ctBuInvoiceReqDetail);
        return getDataTable(list);
    }

    /**
     * 导出发票申请明细列表
     */
    @PreAuthorize("@ss.hasPermi('collectionDetail:collectionDetail:export')")
    @Log(title = "发票申请明细", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(CtBuInvoiceReqDetail ctBuInvoiceReqDetail)
    {
        List<CtBuInvoiceReqDetail> list = ctBuInvoiceReqDetailService.selectCtBuInvoiceReqDetailList(ctBuInvoiceReqDetail);
        ExcelUtil<CtBuInvoiceReqDetail> util = new ExcelUtil<CtBuInvoiceReqDetail>(CtBuInvoiceReqDetail.class);
        return util.exportExcel(list, "collectionDetail");
    }

    /**
     * 获取发票申请明细详细信息
     */
    @PreAuthorize("@ss.hasPermi('collectionDetail:collectionDetail:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return AjaxResult.success(ctBuInvoiceReqDetailService.selectCtBuInvoiceReqDetailById(id));
    }

    /**
     * 新增发票申请明细
     */
    @PreAuthorize("@ss.hasPermi('collectionDetail:collectionDetail:add')")
    @Log(title = "发票申请明细", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CtBuInvoiceReqDetail ctBuInvoiceReqDetail)
    {
        return toAjax(ctBuInvoiceReqDetailService.insertCtBuInvoiceReqDetail(ctBuInvoiceReqDetail));
    }

    /**
     * 修改发票申请明细
     */
    @PreAuthorize("@ss.hasPermi('collectionDetail:collectionDetail:edit')")
    @Log(title = "发票申请明细", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CtBuInvoiceReqDetail ctBuInvoiceReqDetail)
    {
        return toAjax(ctBuInvoiceReqDetailService.updateCtBuInvoiceReqDetail(ctBuInvoiceReqDetail));
    }

    /**
     * 删除发票申请明细
     */
    //@PreAuthorize("@ss.hasPermi('collectionDetail:collectionDetail:remove')")
    @Log(title = "发票申请明细", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(ctBuInvoiceReqDetailService.deleteCtBuInvoiceReqDetailByIds(ids));
    }

    /**
     * 删除发票申请明细
     */
    //@PreAuthorize("@ss.hasPermi('collectionDetail:collectionDetail:remove')")
    @Log(title = "发票申请明细", businessType = BusinessType.DELETE)
    @DeleteMapping("/delCtBuInvoiceReqDetailByIds/{ids}")
    public AjaxResult delCtBuInvoiceReqDetailByIds(@PathVariable String[] ids)
    {
        return toAjax(ctBuInvoiceReqDetailService.delCtBuInvoiceReqDetailByIds(ids));
    }
}

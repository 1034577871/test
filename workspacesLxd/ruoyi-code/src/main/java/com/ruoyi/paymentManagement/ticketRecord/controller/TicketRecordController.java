package com.ruoyi.paymentManagement.ticketRecord.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.paymentManagement.ticketRecord.domain.TicketRecord;
import com.ruoyi.paymentManagement.ticketRecord.service.ITicketRecordService;

/**
 * 收票记录Controller
 * 
 * @author lps
 * @date 2020-12-17
 */
@RestController
@RequestMapping("/paymentManagement/ticketRecord")
public class TicketRecordController extends BaseController
{
    @Autowired
    private ITicketRecordService ticketRecordService;

    /**
     * 查询收票记录列表
     */
    @PreAuthorize("@ss.hasPermi('paymentManagement:ticketRecord:list')")
    @GetMapping("/list1")
    public TableDataInfo list1(TicketRecord ticketRecord)
    {
        startPage();
        List<TicketRecord> list = ticketRecordService.selectTicketRecordList1(ticketRecord);
        return getDataTable(list);
    }

    /**
     * 查询收票记录列表
     */
    @PreAuthorize("@ss.hasPermi('paymentManagement:ticketRecord:list')")
    @GetMapping("/list")
    public TableDataInfo list(TicketRecord ticketRecord)
    {
        startPage();
        List<TicketRecord> list = ticketRecordService.selectTicketRecordList(ticketRecord);
        return getDataTable(list);
    }

    /**
     * 导出收票记录列表
     */
    @PreAuthorize("@ss.hasPermi('paymentManagement:ticketRecord:export')")
    @Log(title = "收票记录", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(TicketRecord ticketRecord)
    {
        List<TicketRecord> list = ticketRecordService.selectTicketRecordList1(ticketRecord);
        ExcelUtil<TicketRecord> util = new ExcelUtil<TicketRecord>(TicketRecord.class);
        return util.exportExcel(list, "ticketRecord");
    }

    /**
     * 获取收票记录详细信息
     */
//    @PreAuthorize("@ss.hasPermi('paymentManagement:ticketRecord:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return AjaxResult.success(ticketRecordService.selectTicketRecordById(id));
    }

    /**
     * 新增收票记录
     */
    @PreAuthorize("@ss.hasPermi('paymentManagement:ticketRecord:add')")
    @Log(title = "收票记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TicketRecord ticketRecord)
    {
        return toAjax(ticketRecordService.insertTicketRecord(ticketRecord));
    }

    /**
     * 修改收票记录
     */
    @PreAuthorize("@ss.hasPermi('paymentManagement:ticketRecord:edit')")
    @Log(title = "收票记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TicketRecord ticketRecord)
    {
        return toAjax(ticketRecordService.updateTicketRecord(ticketRecord));
    }

    /**
     * 删除收票记录
     */
    @PreAuthorize("@ss.hasPermi('paymentManagement:ticketRecord:remove')")
    @Log(title = "收票记录", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(ticketRecordService.deleteTicketRecordByIds(ids));
    }

    /**
     * 逻辑删除删除收票记录
     */
    @PreAuthorize("@ss.hasPermi('paymentManagement:ticketRecord:remove')")
    @Log(title = "收票记录", businessType = BusinessType.UPDATE)
    @PutMapping("/{ids}")
    public AjaxResult editRemove(@PathVariable String[] ids)
    {
        return toAjax(ticketRecordService.updateTicketRecordByIds(ids));
    }
}

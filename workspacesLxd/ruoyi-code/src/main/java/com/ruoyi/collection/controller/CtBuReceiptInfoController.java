package com.ruoyi.collection.controller;

import java.util.List;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.ruoyi.common.constant.HttpStatus;
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
import com.ruoyi.collection.domain.CtBuReceiptInfo;
import com.ruoyi.collection.service.ICtBuReceiptInfoService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 收款单录入Controller
 * 
 * @author ruoyi
 * @date 2020-12-10
 */
@RestController
@RequestMapping("/collection/receiptInfo")
public class CtBuReceiptInfoController extends BaseController
{
    @Autowired
    private ICtBuReceiptInfoService ctBuReceiptInfoService;
    /**
     * 查询预处理收款单录入列表
     */
    //@PreAuthorize("@ss.hasPermi('collection:receiptInfo:list')")
    @GetMapping("/ysklist")
    public TableDataInfo ysklist(CtBuReceiptInfo ctBuReceiptInfo)
    {
        startPage();
        List<CtBuReceiptInfo> list = ctBuReceiptInfoService.selectCtBuReceiptInfoList_(ctBuReceiptInfo);
        return getDataTable(list);
    }


    /**
     * 查询收核销款单录入列表
     */
    //@PreAuthorize("@ss.hasPermi('collection:receiptInfo:list')")
    @GetMapping("/hxlist")
    public TableDataInfo hxlist(CtBuReceiptInfo ctBuReceiptInfo)
    {
        startPage();
        List<CtBuReceiptInfo> list = ctBuReceiptInfoService.selectHxCtBuReceiptInfoList(ctBuReceiptInfo);
        return getDataTable(list);
    }
    /**
     * 查询收款单录入列表
     */
    //@PreAuthorize("@ss.hasPermi('collection:receiptInfo:list')")
    @GetMapping("/list")
    public TableDataInfo list(CtBuReceiptInfo ctBuReceiptInfo)
    {
        List<CtBuReceiptInfo> lists = ctBuReceiptInfoService.selectCtBuReceiptInfoList(ctBuReceiptInfo);
        startPage();
        List<CtBuReceiptInfo> list = ctBuReceiptInfoService.selectCtBuReceiptInfoList(ctBuReceiptInfo);
//        TableDataInfo tab = getDataTable(list);

        TableDataInfo rspData = new TableDataInfo();
        rspData.setTotal(0);
        rspData.setCode(HttpStatus.SUCCESS);
        rspData.setMsg("查询成功");
        rspData.setRows(list);
        rspData.setTotal(lists.size());
        return rspData;

    }

    /**
     * 导出收款单录入列表
     */
    @PreAuthorize("@ss.hasPermi('collection:receiptInfo:export')")
    @Log(title = "收款单录入", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(CtBuReceiptInfo ctBuReceiptInfo)
    {
        List<CtBuReceiptInfo> list = ctBuReceiptInfoService.selectCtBuReceiptInfoList(ctBuReceiptInfo);
        ExcelUtil<CtBuReceiptInfo> util = new ExcelUtil<CtBuReceiptInfo>(CtBuReceiptInfo.class);
        return util.exportExcel(list, "receiptInfo");
    }

    /**
     * 获取收款单录入详细信息
     */
    //@PreAuthorize("@ss.hasPermi('collection:receiptInfo:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return AjaxResult.success(ctBuReceiptInfoService.selectCtBuReceiptInfoById(id));
    }

    /**
     * 新增收款单录入
     */
    //@PreAuthorize("@ss.hasPermi('collection:receiptInfo:add')")
    @Log(title = "收款单录入", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CtBuReceiptInfo ctBuReceiptInfo)
    {
        return toAjax(ctBuReceiptInfoService.insertCtBuReceiptInfo(ctBuReceiptInfo));
    }

    /**
     * 修改收款单录入
     */
    //@PreAuthorize("@ss.hasPermi('collection:receiptInfo:edit')")
    @Log(title = "收款单录入", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CtBuReceiptInfo ctBuReceiptInfo)
    {
        return toAjax(ctBuReceiptInfoService.updateCtBuReceiptInfo(ctBuReceiptInfo));
    }

    /**
     * 删除收款单录入
     */
    @PreAuthorize("@ss.hasPermi('collection:receiptInfo:remove')")
    @Log(title = "收款单录入", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(ctBuReceiptInfoService.deleteCtBuReceiptInfoByIds(ids));
    }

    /**
     * 查询收款单录入列表
     */
    //@PreAuthorize("@ss.hasPermi('collection:receiptInfo:selectNewCtBuReceiptInfoList')")
    @GetMapping("/selectNewCtBuReceiptInfoList")
    public TableDataInfo selectNewCtBuReceiptInfoList(CtBuReceiptInfo ctBuReceiptInfo)
    {
        startPage();
        List<CtBuReceiptInfo> list = ctBuReceiptInfoService.selectNewCtBuReceiptInfoList(ctBuReceiptInfo);
        return getDataTable(list);
    }


}

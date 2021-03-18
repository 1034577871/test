package com.ruoyi.projectApproval.ApprovalNg.controller;

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
import com.ruoyi.system.domain.CtBuMaterielInfo;
import com.ruoyi.system.service.ICtBuMaterielInfoService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * ctBuMaterielInfoController
 * 
 * @author ruoyi
 * @date 2021-02-23
 */
@RestController
@RequestMapping("/system/ctBuMaterielInfo")
public class CtBuMaterielInfoController extends BaseController
{
    @Autowired
    private ICtBuMaterielInfoService ctBuMaterielInfoService;

    /**
     * 查询ctBuMaterielInfo列表
     */
//    @PreAuthorize("@ss.hasPermi('system:ctBuMaterielInfo:list')")
    @GetMapping("/list")
    public TableDataInfo list(CtBuMaterielInfo ctBuMaterielInfo)
    {
        startPage();
        List<CtBuMaterielInfo> list = ctBuMaterielInfoService.selectCtBuMaterielInfoList(ctBuMaterielInfo);
        return getDataTable(list);
    }
    @GetMapping("/lists")
    public List<CtBuMaterielInfo>  lists(CtBuMaterielInfo ctBuMaterielInfo)
    {
        List<CtBuMaterielInfo> list = ctBuMaterielInfoService.selectCtBuMaterielInfoList(ctBuMaterielInfo);
        return (list);
    }
    /**
     * 导出ctBuMaterielInfo列表
     */
    @PreAuthorize("@ss.hasPermi('system:ctBuMaterielInfo:export')")
    @Log(title = "ctBuMaterielInfo", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(CtBuMaterielInfo ctBuMaterielInfo)
    {
        List<CtBuMaterielInfo> list = ctBuMaterielInfoService.selectCtBuMaterielInfoList(ctBuMaterielInfo);
        ExcelUtil<CtBuMaterielInfo> util = new ExcelUtil<CtBuMaterielInfo>(CtBuMaterielInfo.class);
        return util.exportExcel(list, "ctBuMaterielInfo");
    }

    /**
     * 获取ctBuMaterielInfo详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:ctBuMaterielInfo:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(ctBuMaterielInfoService.selectCtBuMaterielInfoById(id));
    }

    /**
     * 新增ctBuMaterielInfo
     */
    @PreAuthorize("@ss.hasPermi('system:ctBuMaterielInfo:add')")
    @Log(title = "ctBuMaterielInfo", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CtBuMaterielInfo ctBuMaterielInfo)
    {
        return toAjax(ctBuMaterielInfoService.insertCtBuMaterielInfo(ctBuMaterielInfo));
    }

    /**
     * 修改ctBuMaterielInfo
     */
    @PreAuthorize("@ss.hasPermi('system:ctBuMaterielInfo:edit')")
    @Log(title = "ctBuMaterielInfo", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CtBuMaterielInfo ctBuMaterielInfo)
    {
        return toAjax(ctBuMaterielInfoService.updateCtBuMaterielInfo(ctBuMaterielInfo));
    }

    /**
     * 删除ctBuMaterielInfo
     */
    @PreAuthorize("@ss.hasPermi('system:ctBuMaterielInfo:remove')")
    @Log(title = "ctBuMaterielInfo", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(ctBuMaterielInfoService.deleteCtBuMaterielInfoByIds(ids));
    }
}

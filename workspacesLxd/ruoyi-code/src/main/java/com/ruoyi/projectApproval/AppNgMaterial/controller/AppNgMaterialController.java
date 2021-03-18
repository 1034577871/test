package com.ruoyi.projectApproval.AppNgMaterial.controller;

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
import com.ruoyi.projectApproval.AppNgMaterial.domain.AppNgMaterial;
import com.ruoyi.projectApproval.AppNgMaterial.service.IAppNgMaterialService;

/**
 * 事前审批明细(集客类-材料使用情况)Controller
 *
 * @author Mu
 * @date 2020-12-09
 */
@RestController
@RequestMapping("/projectApprovalSubclass/AppNgMaterial")
public class AppNgMaterialController extends BaseController {

    @Autowired
    private IAppNgMaterialService appNgMaterialService;

    /**
     * 查询事前审批明细(集客类-材料使用情况)列表
     */
    @PreAuthorize("@ss.hasPermi('projectApprovalSubclass:AppNgMaterial:list')")
    @GetMapping("/list")
    public TableDataInfo list(AppNgMaterial appNgMaterial) {
        startPage();
        List<AppNgMaterial> list = appNgMaterialService.selectAppNgMaterialList(appNgMaterial);
        return getDataTable(list);
    }

    /**
     * 导出事前审批明细(集客类-材料使用情况)列表
     */
    @PreAuthorize("@ss.hasPermi('projectApprovalSubclass:AppNgMaterial:export')")
    @Log(title = "事前审批明细(集客类-材料使用情况)", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(AppNgMaterial appNgMaterial) {
        List<AppNgMaterial> list = appNgMaterialService.selectAppNgMaterialList(appNgMaterial);
        ExcelUtil<AppNgMaterial> util = new ExcelUtil<AppNgMaterial>(AppNgMaterial.class);
        return util.exportExcel(list, "AppNgMaterial");
    }

    /**
     * 获取事前审批明细(集客类-材料使用情况)详细信息
     */
    @PreAuthorize("@ss.hasPermi('projectApprovalSubclass:AppNgMaterial:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id) {
        return AjaxResult.success(appNgMaterialService.selectAppNgMaterialById(id));
    }

    /**
     * 新增事前审批明细(集客类-材料使用情况)
     */
    @PreAuthorize("@ss.hasPermi('projectApprovalSubclass:AppNgMaterial:add')")
    @Log(title = "事前审批明细(集客类-材料使用情况)", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AppNgMaterial appNgMaterial) {
        return toAjax(appNgMaterialService.insertAppNgMaterial(appNgMaterial));
    }

    /**
     * 修改事前审批明细(集客类-材料使用情况)
     */
    @PreAuthorize("@ss.hasPermi('projectApprovalSubclass:AppNgMaterial:edit')")
    @Log(title = "事前审批明细(集客类-材料使用情况)", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AppNgMaterial appNgMaterial) {
        return toAjax(appNgMaterialService.updateAppNgMaterial(appNgMaterial));
    }

    /**
     * 删除事前审批明细(集客类-材料使用情况)
     */
//    @PreAuthorize("@ss.hasPermi('projectApprovalSubclass:AppNgMaterial:remove')")
    @Log(title = "事前审批明细(集客类-材料使用情况)", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids) {
        return toAjax(appNgMaterialService.deleteAppNgMaterialByIds(ids));
    }

    //    @PreAuthorize("@ss.hasPermi('projectApprovalSubclass:AppNgMaterial:remove')")
    @Log(title = "事前审批明细(集客类-材料使用情况)", businessType = BusinessType.DELETE)
    @GetMapping("/removeMea/{ids}")
    public AjaxResult remove(@PathVariable String ids) {
        return toAjax(appNgMaterialService.deleteAppNgMaterialById(ids));
    }
}

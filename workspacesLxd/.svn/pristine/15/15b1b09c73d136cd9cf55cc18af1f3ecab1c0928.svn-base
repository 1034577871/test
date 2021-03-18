package com.ruoyi.projectApproval.AppNgBase.controller;

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
import com.ruoyi.projectApproval.AppNgBase.domain.AppNgBase;
import com.ruoyi.projectApproval.AppNgBase.service.IAppNgBaseService;

/**
 * 事前审批明细(集客类-项目基本情况)Controller
 *
 * @author Mu
 * @date 2020-12-09
 */
@RestController
@RequestMapping("/projectApproval/base")
public class AppNgBaseController extends BaseController {

    @Autowired
    private IAppNgBaseService appNgBaseService;

    /**
     * 查询事前审批明细(集客类-项目基本情况)列表
     */
    @PreAuthorize("@ss.hasPermi('projectApproval:base:list')")
    @GetMapping("/list")
    public TableDataInfo list(AppNgBase appNgBase) {
        startPage();
        List<AppNgBase> list = appNgBaseService.selectAppNgBaseList(appNgBase);
        return getDataTable(list);
    }

    /**
     * 导出事前审批明细(集客类-项目基本情况)列表
     */
    @PreAuthorize("@ss.hasPermi('projectApproval:base:export')")
    @Log(title = "事前审批明细(集客类-项目基本情况)", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(AppNgBase appNgBase) {
        List<AppNgBase> list = appNgBaseService.selectAppNgBaseList(appNgBase);
        ExcelUtil<AppNgBase> util = new ExcelUtil<AppNgBase>(AppNgBase.class);
        return util.exportExcel(list, "base");
    }

    /**
     * 获取事前审批明细(集客类-项目基本情况)详细信息
     */
    @PreAuthorize("@ss.hasPermi('projectApproval:base:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id) {
        return AjaxResult.success(appNgBaseService.selectAppNgBaseById(id));
    }

    /**
     * 新增事前审批明细(集客类-项目基本情况)
     */
    @PreAuthorize("@ss.hasPermi('projectApproval:base:add')")
    @Log(title = "事前审批明细(集客类-项目基本情况)", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AppNgBase appNgBase) {
        return toAjax(appNgBaseService.insertAppNgBase(appNgBase));
    }

    /**
     * 修改事前审批明细(集客类-项目基本情况)
     */
    @PreAuthorize("@ss.hasPermi('projectApproval:base:edit')")
    @Log(title = "事前审批明细(集客类-项目基本情况)", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AppNgBase appNgBase) {
        return toAjax(appNgBaseService.updateAppNgBase(appNgBase));
    }

    /**
     * 删除事前审批明细(集客类-项目基本情况)
     */
    @PreAuthorize("@ss.hasPermi('projectApproval:base:remove')")
    @Log(title = "事前审批明细(集客类-项目基本情况)", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids) {
        return toAjax(appNgBaseService.deleteAppNgBaseByIds(ids));
    }
}

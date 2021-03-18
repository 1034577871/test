package com.ruoyi.projectApproval.AppNgConst.controller;

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
import com.ruoyi.projectApproval.AppNgConst.domain.AppNgConst;
import com.ruoyi.projectApproval.AppNgConst.service.IAppNgConstService;

/**
 * 事前审批明细(集客类-施工费情况)Controller
 *
 * @author Mu
 * @date 2020-12-09
 */
@RestController
@RequestMapping("/projectApprovalSubclass/AppNgConst")
public class AppNgConstController extends BaseController {

    @Autowired
    private IAppNgConstService appNgConstService;

    /**
     * 查询事前审批明细(集客类-施工费情况)列表
     */
    @PreAuthorize("@ss.hasPermi('projectApprovalSubclass:AppNgConst:list')")
    @GetMapping("/list")
    public TableDataInfo list(AppNgConst appNgConst) {
        startPage();
        List<AppNgConst> list = appNgConstService.selectAppNgConstList(appNgConst);
        return getDataTable(list);
    }

    /**
     * 导出事前审批明细(集客类-施工费情况)列表
     */
    @PreAuthorize("@ss.hasPermi('projectApprovalSubclass:AppNgConst:export')")
    @Log(title = "事前审批明细(集客类-施工费情况)", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(AppNgConst appNgConst) {
        List<AppNgConst> list = appNgConstService.selectAppNgConstList(appNgConst);
        ExcelUtil<AppNgConst> util = new ExcelUtil<AppNgConst>(AppNgConst.class);
        return util.exportExcel(list, "AppNgConst");
    }

    /**
     * 获取事前审批明细(集客类-施工费情况)详细信息
     */
    @PreAuthorize("@ss.hasPermi('projectApprovalSubclass:AppNgConst:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id) {
        return AjaxResult.success(appNgConstService.selectAppNgConstById(id));
    }

    /**
     * 新增事前审批明细(集客类-施工费情况)
     */
    @PreAuthorize("@ss.hasPermi('projectApprovalSubclass:AppNgConst:add')")
    @Log(title = "事前审批明细(集客类-施工费情况)", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AppNgConst appNgConst) {
        return toAjax(appNgConstService.insertAppNgConst(appNgConst));
    }

    /**
     * 修改事前审批明细(集客类-施工费情况)
     */
    @PreAuthorize("@ss.hasPermi('projectApprovalSubclass:AppNgConst:edit')")
    @Log(title = "事前审批明细(集客类-施工费情况)", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AppNgConst appNgConst) {
        return toAjax(appNgConstService.updateAppNgConst(appNgConst));
    }

    /**
     * 删除事前审批明细(集客类-施工费情况)
     */
//    @PreAuthorize("@ss.hasPermi('projectApprovalSubclass:AppNgConst:remove')")
    @Log(title = "事前审批明细(集客类-施工费情况)", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids) {
        return toAjax(appNgConstService.deleteAppNgConstByIds(ids));
    }
    /**
     * 删除事前审批明细(集客类-施工费情况)
     */
//    @PreAuthorize("@ss.hasPermi('projectApprovalSubclass:AppNgConst:remove')")
    @Log(title = "事前审批明细(集客类-施工费情况)", businessType = BusinessType.DELETE)
    @GetMapping("/removeCon/{ids}")
    public AjaxResult remove(@PathVariable String ids) {
        return toAjax(appNgConstService.deleteAppNgConstById(ids));
    }
}

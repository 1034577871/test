package com.ruoyi.projectApproval.ApprovalNg.controller;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ruoyi.common.annotation.DataScope;
import com.ruoyi.common.annotation.RepeatSubmit;
import org.apache.ibatis.annotations.Param;
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
import com.ruoyi.projectApproval.ApprovalNg.domain.CtBuApprovalNg;
import com.ruoyi.projectApproval.ApprovalNg.service.ICtBuApprovalNgService;

/**
 * 事前审批主(集客类)Controller
 *
 * @author Mu
 * @date 2020-12-08
 */
@RestController
@RequestMapping("/projectApproval/collectProject")
public class CtBuApprovalNgController extends BaseController {

    @Autowired
    private ICtBuApprovalNgService ctBuApprovalNgService;

    //	@PreAuthorize("@ss.hasPermi('projectApproval:collectProject:list')")
    @GetMapping("/lists")
    public List<CtBuApprovalNg> lists(CtBuApprovalNg ctBuApprovalNg) {
        List<CtBuApprovalNg> list = ctBuApprovalNgService.selectCtBuApprovalNgLists(ctBuApprovalNg);
        return list;
    }

    /**
     * 根据bid和cid获取事前审批主(集客类)详细信息
     */
    //@PreAuthorize("@ss.hasPermi('projectApproval:collectProject:copyReqInfo')")
    @GetMapping(value = "/copyReqInfo/{id}")
    public AjaxResult copyReqInfo(@PathVariable("id") String id) {
        try {
            ctBuApprovalNgService.copyCtBuApprovalNgById(id);
            return AjaxResult.success("复制成功");
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.success("复制失败");
        }

    }

    /**
     * 根据bid和cid获取事前审批主(集客类)详细信息
     */
    //@PreAuthorize("@ss.hasPermi('projectApproval:collectProject:query')")
    @GetMapping(value = "/appReqInfo/{id}")
    public AjaxResult selectCtBuApprovalNgReqById(@PathVariable("id") String id) {
        return AjaxResult.success(ctBuApprovalNgService.selectCtBuApprovalNgReqById(id));
    }

    /**
     * 根据bid和cid获取事前审批主(集客类)详细信息
     */
    //@PreAuthorize("@ss.hasPermi('projectApproval:collectProject:query')")
    @GetMapping(value = "/appInfo/{id}/{cid}")
    public AjaxResult getAppInfo(@PathVariable("id") String id, @PathVariable("cid") String cid) {
        Map map = new HashMap<>();
        map.put("bid", id);
        map.put("cid", cid);
        return AjaxResult.success(ctBuApprovalNgService.selectCtBuApprovalFgsNgById(map));
    }

    /**
     * 查询事前审批主(集客类)列表
     */
    @PreAuthorize("@ss.hasPermi('projectApproval:collectProject:list')")
    @GetMapping("/list")
    public TableDataInfo list(CtBuApprovalNg ctBuApprovalNg) {
        startPage();
        List<CtBuApprovalNg> list = ctBuApprovalNgService.selectCtBuApprovalNgList(ctBuApprovalNg);
        return getDataTable(list);
    }

    /**
     * 导出事前审批主(集客类)列表
     */
    @PreAuthorize("@ss.hasPermi('projectApproval:collectProject:export')")
    @Log(title = "事前审批主(集客类)", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(CtBuApprovalNg ctBuApprovalNg) {
        List<CtBuApprovalNg> list = ctBuApprovalNgService.selectCtBuApprovalNgList(ctBuApprovalNg);
        ExcelUtil<CtBuApprovalNg> util = new ExcelUtil<CtBuApprovalNg>(CtBuApprovalNg.class);
        return util.exportExcel(list, "collectProject");
    }

    /**
     * 获取事前审批主(集客类)详细信息
     */
    //@PreAuthorize("@ss.hasPermi('projectApproval:collectProject:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id) {
        return AjaxResult.success(ctBuApprovalNgService.selectCtBuApprovalNgById(id));
    }

    /**
     * 新增事前审批主(集客类)
     */
    @RepeatSubmit
    @PreAuthorize("@ss.hasPermi('projectApproval:collectProject:add')")
    @Log(title = "事前审批主(集客类)", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CtBuApprovalNg ctBuApprovalNg) {
        return toAjax(ctBuApprovalNgService.insertCtBuApprovalNg(ctBuApprovalNg));
    }

    /**
     * 修改事前审批主(集客类)
     */
    @RepeatSubmit
    @PreAuthorize("@ss.hasPermi('projectApproval:collectProject:edit')")
    @Log(title = "事前审批主(集客类)", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CtBuApprovalNg ctBuApprovalNg) {
        return toAjax(ctBuApprovalNgService.updateCtBuApprovalNg(ctBuApprovalNg));
    }

    /**
     * 修改事前审批主(集客类)
     */
    @RepeatSubmit
    @PreAuthorize("@ss.hasPermi('projectApproval:collectProject:edits')")
    @Log(title = "事前审批主(集客类)", businessType = BusinessType.UPDATE)
    @PutMapping("/edits")
    public AjaxResult edits(@RequestBody CtBuApprovalNg ctBuApprovalNg) {
        return toAjax(ctBuApprovalNgService.updateCtBuApprovalNg(ctBuApprovalNg));
    }

    /**
     * 新增事前审批主(集客类)
     */
    //@PreAuthorize("@ss.hasPermi('projectApproval:collectProject:add')")
    @RepeatSubmit
    @Log(title = "事前审批主(集客类)", businessType = BusinessType.INSERT)
    @PostMapping("/addNg")
    public AjaxResult addNg(@RequestBody CtBuApprovalNg ctBuApprovalNg) {
        return toAjax(ctBuApprovalNgService.insertCtBuApprovalNg_(ctBuApprovalNg));
    }

    /**
     * 修改事前审批主(集客类)
     */
    @RepeatSubmit
    //@PreAuthorize("@ss.hasPermi('projectApproval:collectProject:edit')")
    @Log(title = "事前审批主(集客类)", businessType = BusinessType.UPDATE)
    @PutMapping("/editNg")
    public AjaxResult editNg(@RequestBody CtBuApprovalNg ctBuApprovalNg) {
        return toAjax(ctBuApprovalNgService.updateCtBuApprovalNg_(ctBuApprovalNg));
    }

    /**
     * 删除事前审批主(集客类)
     */
    @PreAuthorize("@ss.hasPermi('projectApproval:collectProject:remove')")
    @Log(title = "事前审批主(集客类)", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids) {
        return toAjax(ctBuApprovalNgService.deleteCtBuApprovalNgByIds(ids));
    }

    /**
     * @Title: CtBuApprovalNgController.java
     * @Description: 返回下一个事前审批编号
     * @Author M.Mu
     * @Date 2020-12-16
     */
    @GetMapping(value = "/findNextAppNo")
    public AjaxResult findNextAppNo() {

        return AjaxResult.success(ctBuApprovalNgService.findNextAppNo());
    }

    // 保存表单
    @PostMapping(value = "/updateCtBuApprovalNgOld/{uploads}/{nid}")
    public AjaxResult updateCtBuApprovalNgOld(@PathVariable("uploads") String uploads, @PathVariable("nid") String nid) throws ParseException {
        return toAjax(ctBuApprovalNgService.updateCtBuApprovalNgOld(uploads,nid));

    }
}
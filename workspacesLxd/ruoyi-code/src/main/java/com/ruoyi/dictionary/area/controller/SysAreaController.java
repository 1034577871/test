package com.ruoyi.dictionary.area.controller;

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
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.dictionary.area.domain.SysArea;
import com.ruoyi.dictionary.area.service.ISysAreaService;

/**
 * 地区信息字典Controller
 * 
 * @author Mu
 * @date 2020-12-08
 */
@RestController
@RequestMapping("/dictionary/area")
public class SysAreaController extends BaseController {

	@Autowired
	private ISysAreaService sysAreaService;

	/**
	 * 查询地区信息字典列表
	 */
	@PreAuthorize("@ss.hasPermi('dictionary:area:list')")
	@GetMapping("/list")
	public AjaxResult list(SysArea sysArea) {
		List<SysArea> list = sysAreaService.selectSysAreaList(sysArea);
		return AjaxResult.success(list);
	}

	/**
	 * 导出地区信息字典列表
	 */
	@PreAuthorize("@ss.hasPermi('dictionary:area:export')")
	@Log(title = "地区信息字典", businessType = BusinessType.EXPORT)
	@GetMapping("/export")
	public AjaxResult export(SysArea sysArea) {
		List<SysArea> list = sysAreaService.selectSysAreaList(sysArea);
		ExcelUtil<SysArea> util = new ExcelUtil<SysArea>(SysArea.class);
		return util.exportExcel(list, "area");
	}

	/**
	 * 获取地区信息字典详细信息
	 */
	@PreAuthorize("@ss.hasPermi('dictionary:area:query')")
	@GetMapping(value = "/{id}")
	public AjaxResult getInfo(@PathVariable("id") Integer id) {
		return AjaxResult.success(sysAreaService.selectSysAreaById(id));
	}

	/**
	 * 新增地区信息字典
	 */
	@PreAuthorize("@ss.hasPermi('dictionary:area:add')")
	@Log(title = "地区信息字典", businessType = BusinessType.INSERT)
	@PostMapping
	public AjaxResult add(@RequestBody SysArea sysArea) {
		return toAjax(sysAreaService.insertSysArea(sysArea));
	}

	/**
	 * 修改地区信息字典
	 */
	@PreAuthorize("@ss.hasPermi('dictionary:area:edit')")
	@Log(title = "地区信息字典", businessType = BusinessType.UPDATE)
	@PutMapping
	public AjaxResult edit(@RequestBody SysArea sysArea) {
		return toAjax(sysAreaService.updateSysArea(sysArea));
	}

	/**
	 * 删除地区信息字典
	 */
	@PreAuthorize("@ss.hasPermi('dictionary:area:remove')")
	@Log(title = "地区信息字典", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
	public AjaxResult remove(@PathVariable Integer[] ids) {
		return toAjax(sysAreaService.deleteSysAreaByIds(ids));
	}

	@GetMapping("/findAreaList")
	public AjaxResult findAreaList() {

		return AjaxResult.success("ok", sysAreaService.findAreaList());
	}
}
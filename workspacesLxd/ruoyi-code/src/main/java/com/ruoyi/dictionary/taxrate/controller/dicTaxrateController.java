package com.ruoyi.dictionary.taxrate.controller;

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
import com.ruoyi.dictionary.taxrate.domain.dicTaxrate;
import com.ruoyi.dictionary.taxrate.service.IdicTaxrateService;

/**
 * 税率字典Controller
 * 
 * @author Mu
 * @date 2020-12-21
 */
@RestController
@RequestMapping("/dictionary/taxrate")
public class dicTaxrateController extends BaseController {
	
	@Autowired
	private IdicTaxrateService dicTaxrateService;

	/**
	 * 查询税率字典列表
	 */
	@PreAuthorize("@ss.hasPermi('dictionary:taxrate:list')")
	@GetMapping("/list")
	public TableDataInfo list(dicTaxrate dicTaxrate) {
		startPage();
		List<dicTaxrate> list = dicTaxrateService.selectdicTaxrateList(dicTaxrate);
		return getDataTable(list);
	}

	/**
	 * 导出税率字典列表
	 */
	@PreAuthorize("@ss.hasPermi('dictionary:taxrate:export')")
	@Log(title = "税率字典", businessType = BusinessType.EXPORT)
	@GetMapping("/export")
	public AjaxResult export(dicTaxrate dicTaxrate) {
		List<dicTaxrate> list = dicTaxrateService.selectdicTaxrateList(dicTaxrate);
		ExcelUtil<dicTaxrate> util = new ExcelUtil<dicTaxrate>(dicTaxrate.class);
		return util.exportExcel(list, "taxrate");
	}

	/**
	 * 获取税率字典详细信息
	 */
	@PreAuthorize("@ss.hasPermi('dictionary:taxrate:query')")
	@GetMapping(value = "/{id}")
	public AjaxResult getInfo(@PathVariable("id") String id) {
		return AjaxResult.success(dicTaxrateService.selectdicTaxrateById(id));
	}

	/**
	 * 新增税率字典
	 */
	@PreAuthorize("@ss.hasPermi('dictionary:taxrate:add')")
	@Log(title = "税率字典", businessType = BusinessType.INSERT)
	@PostMapping
	public AjaxResult add(@RequestBody dicTaxrate dicTaxrate) {
		return toAjax(dicTaxrateService.insertdicTaxrate(dicTaxrate));
	}

	/**
	 * 修改税率字典
	 */
	@PreAuthorize("@ss.hasPermi('dictionary:taxrate:edit')")
	@Log(title = "税率字典", businessType = BusinessType.UPDATE)
	@PutMapping
	public AjaxResult edit(@RequestBody dicTaxrate dicTaxrate) {
		return toAjax(dicTaxrateService.updatedicTaxrate(dicTaxrate));
	}

	/**
	 * 删除税率字典
	 */
	@PreAuthorize("@ss.hasPermi('dictionary:taxrate:remove')")
	@Log(title = "税率字典", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
	public AjaxResult remove(@PathVariable String[] ids) {
		return toAjax(dicTaxrateService.deletedicTaxrateByIds(ids));
	}
}

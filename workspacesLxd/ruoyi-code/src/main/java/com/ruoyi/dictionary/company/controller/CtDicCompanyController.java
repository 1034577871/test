package com.ruoyi.dictionary.company.controller;

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
import com.ruoyi.dictionary.company.domain.CtDicCompany;
import com.ruoyi.dictionary.company.serivce.ICtDicCompanyService;

/**
 * @Title: CtDicCompanyController.java
 * @Description: 企业信息
 * @Author M.Mu
 * @Date 2020-12-07
 */
@RestController
@RequestMapping("/dictionary/company")
public class CtDicCompanyController extends BaseController {

	@Autowired
	private ICtDicCompanyService ctDicCompanyService;

	/**
	 * 查询企业信息列表
	 */
	@PreAuthorize("@ss.hasPermi('dictionary:company:list')")
	@GetMapping("/list")
	public TableDataInfo list(CtDicCompany ctDicCompany) {
		startPage();
		List<CtDicCompany> list = ctDicCompanyService.selectCtDicCompanyList(ctDicCompany);
		return getDataTable(list);
	}

	/**
	 * 导出企业信息列表
	 */
	@PreAuthorize("@ss.hasPermi('dictionary:company:export')")
	@Log(title = "企业信息", businessType = BusinessType.EXPORT)
	@GetMapping("/export")
	public AjaxResult export(CtDicCompany ctDicCompany) {
		List<CtDicCompany> list = ctDicCompanyService.selectCtDicCompanyList(ctDicCompany);
		ExcelUtil<CtDicCompany> util = new ExcelUtil<CtDicCompany>(CtDicCompany.class);
		return util.exportExcel(list, "company");
	}

	/**
	 * 获取企业信息详细信息
	 */
	@PreAuthorize("@ss.hasPermi('dictionary:company:query')")
	@GetMapping(value = "/{id}")
	public AjaxResult getInfo(@PathVariable("id") String id) {
		return AjaxResult.success(ctDicCompanyService.selectCtDicCompanyById(id));
	}

	/**
	 * 新增企业信息
	 */
	@PreAuthorize("@ss.hasPermi('dictionary:company:add')")
	@Log(title = "企业信息", businessType = BusinessType.INSERT)
	@PostMapping
	public AjaxResult add(@RequestBody CtDicCompany ctDicCompany) {
		return toAjax(ctDicCompanyService.insertCtDicCompany(ctDicCompany));
	}

	/**
	 * 修改企业信息
	 */
	@PreAuthorize("@ss.hasPermi('dictionary:company:edit')")
	@Log(title = "企业信息", businessType = BusinessType.UPDATE)
	@PutMapping
	public AjaxResult edit(@RequestBody CtDicCompany ctDicCompany) {
		return toAjax(ctDicCompanyService.updateCtDicCompany(ctDicCompany));
	}

	/**
	 * 删除企业信息
	 */
	@PreAuthorize("@ss.hasPermi('dictionary:company:remove')")
	@Log(title = "企业信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
	public AjaxResult remove(@PathVariable String[] ids) {
		return toAjax(ctDicCompanyService.deleteCtDicCompanyByIds(ids));
	}
}

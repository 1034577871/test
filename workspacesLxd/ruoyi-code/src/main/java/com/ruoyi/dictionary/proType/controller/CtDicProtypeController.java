package com.ruoyi.dictionary.proType.controller;

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
import com.ruoyi.dictionary.proType.domain.CtDicProtype;
import com.ruoyi.dictionary.proType.service.ICtDicProtypeService;

/**
 * 项目类型字典Controller
 * 
 * @author Mu
 * @date 2020-12-08
 */
@RestController
@RequestMapping("/dictionary/protype")
public class CtDicProtypeController extends BaseController {

	@Autowired
	private ICtDicProtypeService ctDicProtypeService;

	/**
	 * 查询项目类型字典列表
	 */
	@PreAuthorize("@ss.hasPermi('dictionary:protype:list')")
	@GetMapping("/list")
	public AjaxResult list(CtDicProtype ctDicProtype) {
		List<CtDicProtype> list = ctDicProtypeService.selectCtDicProtypeList(ctDicProtype);
		return AjaxResult.success(list);
	}

	/**
	 * 导出项目类型字典列表
	 */
	@PreAuthorize("@ss.hasPermi('dictionary:protype:export')")
	@Log(title = "项目类型字典", businessType = BusinessType.EXPORT)
	@GetMapping("/export")
	public AjaxResult export(CtDicProtype ctDicProtype) {
		List<CtDicProtype> list = ctDicProtypeService.selectCtDicProtypeList(ctDicProtype);
		ExcelUtil<CtDicProtype> util = new ExcelUtil<CtDicProtype>(CtDicProtype.class);
		return util.exportExcel(list, "protype");
	}

	/**
	 * 获取项目类型字典详细信息
	 */
	@PreAuthorize("@ss.hasPermi('dictionary:protype:query')")
	@GetMapping(value = "/{id}")
	public AjaxResult getInfo(@PathVariable("id") String id) {
		return AjaxResult.success(ctDicProtypeService.selectCtDicProtypeById(id));
	}

	/**
	 * 新增项目类型字典
	 */
	@PreAuthorize("@ss.hasPermi('dictionary:protype:add')")
	@Log(title = "项目类型字典", businessType = BusinessType.INSERT)
	@PostMapping
	public AjaxResult add(@RequestBody CtDicProtype ctDicProtype) {
		return toAjax(ctDicProtypeService.insertCtDicProtype(ctDicProtype));
	}

	/**
	 * 修改项目类型字典
	 */
	@PreAuthorize("@ss.hasPermi('dictionary:protype:edit')")
	@Log(title = "项目类型字典", businessType = BusinessType.UPDATE)
	@PutMapping
	public AjaxResult edit(@RequestBody CtDicProtype ctDicProtype) {
		return toAjax(ctDicProtypeService.updateCtDicProtype(ctDicProtype));
	}

	/**
	 * 删除项目类型字典
	 */
	@PreAuthorize("@ss.hasPermi('dictionary:protype:remove')")
	@Log(title = "项目类型字典", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
	public AjaxResult remove(@PathVariable String[] ids) {
		return toAjax(ctDicProtypeService.deleteCtDicProtypeByIds(ids));
	}

	/**
	 * @Title: CtDicProtypeController.java
	 * @Description: 查询项目类型----用于工具类
	 * @Author M.Mu
	 * @Date 2020-12-08
	 */
	@GetMapping("/findProjectType")
	public AjaxResult findProjectType() {

		return AjaxResult.success(ctDicProtypeService.findProjectType());
	}
}
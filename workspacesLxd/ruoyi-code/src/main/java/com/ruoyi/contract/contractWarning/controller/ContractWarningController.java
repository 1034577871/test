package com.ruoyi.contract.contractWarning.controller;

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
import com.ruoyi.contract.contractWarning.domain.ContractWarning;
import com.ruoyi.contract.contractWarning.service.IContractWarningService;

/**
 * 合同预警Controller
 * 
 * @author ruoyi
 * @date 2020-12-09
 */
@RestController
@RequestMapping("/contract/warning")
public class ContractWarningController extends BaseController {
	@Autowired
	private IContractWarningService contractWarningService;

	/**
	 * 查询合同预警列表
	 */
	@PreAuthorize("@ss.hasPermi('contract:warning:list')")
	@GetMapping("/list")
	public TableDataInfo list(ContractWarning contractWarning) {
		startPage();
		List<ContractWarning> list = contractWarningService.selectContractWarningList(contractWarning);
		return getDataTable(list);
	}

	/**
	 * 导出合同预警列表
	 */
	@PreAuthorize("@ss.hasPermi('contract:warning:export')")
	@Log(title = "合同预警", businessType = BusinessType.EXPORT)
	@GetMapping("/export")
	public AjaxResult export(ContractWarning contractWarning) {
		List<ContractWarning> list = contractWarningService.selectContractWarningList(contractWarning);
		ExcelUtil<ContractWarning> util = new ExcelUtil<ContractWarning>(ContractWarning.class);
		return util.exportExcel(list, "warning");
	}

	/**
	 * 获取合同预警详细信息
	 */
	@PreAuthorize("@ss.hasPermi('contract:warning:query')")
	@GetMapping(value = "/{id}")
	public AjaxResult getInfo(@PathVariable("id") String id) {
		return AjaxResult.success(contractWarningService.selectContractWarningById(id));
	}

	/**
	 * 新增合同预警
	 */
	@PreAuthorize("@ss.hasPermi('contract:warning:add')")
	@Log(title = "合同预警", businessType = BusinessType.INSERT)
	@PostMapping
	public AjaxResult add(@RequestBody ContractWarning contractWarning) {
		return toAjax(contractWarningService.insertContractWarning(contractWarning));
	}

	/**
	 * 修改合同预警
	 */
	@PreAuthorize("@ss.hasPermi('contract:warning:edit')")
	@Log(title = "合同预警", businessType = BusinessType.UPDATE)
	@PutMapping
	public AjaxResult edit(@RequestBody ContractWarning contractWarning) {
		return toAjax(contractWarningService.updateContractWarning(contractWarning));
	}

	/**
	 * 删除合同预警
	 */
	@PreAuthorize("@ss.hasPermi('contract:warning:remove')")
	@Log(title = "合同预警", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
	public AjaxResult remove(@PathVariable String[] ids) {
		return toAjax(contractWarningService.deleteContractWarningByIds(ids));
	}
}

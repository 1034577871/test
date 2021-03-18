package com.ruoyi.contract.contractWarning.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.contract.contractWarning.domain.ContractWarning;
import com.ruoyi.contract.contractWarning.mapper.ContractWarningMapper;
import com.ruoyi.contract.contractWarning.service.IContractWarningService;

/**
 * 合同预警Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-12-09
 */
@Service
public class ContractWarningServiceImpl implements IContractWarningService {
	@Autowired
	private ContractWarningMapper contractWarningMapper;

	/**
	 * 查询合同预警
	 * 
	 * @param id 合同预警ID
	 * @return 合同预警
	 */
	@Override
	public ContractWarning selectContractWarningById(String id) {
		return contractWarningMapper.selectContractWarningById(id);
	}

	/**
	 * 查询合同预警列表
	 * 
	 * @param contractWarning 合同预警
	 * @return 合同预警
	 */
	@Override
	public List<ContractWarning> selectContractWarningList(ContractWarning contractWarning) {
		return contractWarningMapper.selectContractWarningList(contractWarning);
	}

	/**
	 * 新增合同预警
	 * 
	 * @param contractWarning 合同预警
	 * @return 结果
	 */
	@Override
	public int insertContractWarning(ContractWarning contractWarning) {
		contractWarning.setCreateTime(DateUtils.getNowDate());
		return contractWarningMapper.insertContractWarning(contractWarning);
	}

	/**
	 * 修改合同预警
	 * 
	 * @param contractWarning 合同预警
	 * @return 结果
	 */
	@Override
	public int updateContractWarning(ContractWarning contractWarning) {
		contractWarning.setUpdateTime(DateUtils.getNowDate());
		return contractWarningMapper.updateContractWarning(contractWarning);
	}

	/**
	 * 批量删除合同预警
	 * 
	 * @param ids 需要删除的合同预警ID
	 * @return 结果
	 */
	@Override
	public int deleteContractWarningByIds(String[] ids) {
		return contractWarningMapper.deleteContractWarningByIds(ids);
	}

	/**
	 * 删除合同预警信息
	 * 
	 * @param id 合同预警ID
	 * @return 结果
	 */
	@Override
	public int deleteContractWarningById(String id) {
		return contractWarningMapper.deleteContractWarningById(id);
	}
}

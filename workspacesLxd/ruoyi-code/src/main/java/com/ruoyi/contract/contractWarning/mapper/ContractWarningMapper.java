package com.ruoyi.contract.contractWarning.mapper;

import java.util.List;

import com.ruoyi.contract.contractWarning.domain.ContractWarning;

/**
 * 合同预警Mapper接口
 * 
 * @author ruoyi
 * @date 2020-12-09
 */
public interface ContractWarningMapper {
	
	/**
	 * 查询合同预警
	 * 
	 * @param id 合同预警ID
	 * @return 合同预警
	 */
	public ContractWarning selectContractWarningById(String id);

	/**
	 * 查询合同预警列表
	 * 
	 * @param contractWarning 合同预警
	 * @return 合同预警集合
	 */
	public List<ContractWarning> selectContractWarningList(ContractWarning contractWarning);

	/**
	 * 新增合同预警
	 * 
	 * @param contractWarning 合同预警
	 * @return 结果
	 */
	public int insertContractWarning(ContractWarning contractWarning);

	/**
	 * 修改合同预警
	 * 
	 * @param contractWarning 合同预警
	 * @return 结果
	 */
	public int updateContractWarning(ContractWarning contractWarning);

	/**
	 * 删除合同预警
	 * 
	 * @param id 合同预警ID
	 * @return 结果
	 */
	public int deleteContractWarningById(String id);

	/**
	 * 批量删除合同预警
	 * 
	 * @param ids 需要删除的数据ID
	 * @return 结果
	 */
	public int deleteContractWarningByIds(String[] ids);
}

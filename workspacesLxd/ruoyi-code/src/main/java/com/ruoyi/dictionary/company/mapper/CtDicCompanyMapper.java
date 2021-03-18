package com.ruoyi.dictionary.company.mapper;

import java.util.List;

import com.ruoyi.dictionary.company.domain.CtDicCompany;

/**
 * 企业信息Mapper接口
 * 
 * @author Mu
 * @date 2020-12-07
 */
public interface CtDicCompanyMapper {
	/**
	 * 查询企业信息
	 * 
	 * @param id 企业信息ID
	 * @return 企业信息
	 */
	public CtDicCompany selectCtDicCompanyById(String id);

	/**
	 * 查询企业信息列表
	 * 
	 * @param ctDicCompany 企业信息
	 * @return 企业信息集合
	 */
	public List<CtDicCompany> selectCtDicCompanyList(CtDicCompany ctDicCompany);

	/**
	 * 新增企业信息
	 * 
	 * @param ctDicCompany 企业信息
	 * @return 结果
	 */
	public int insertCtDicCompany(CtDicCompany ctDicCompany);

	/**
	 * 修改企业信息
	 * 
	 * @param ctDicCompany 企业信息
	 * @return 结果
	 */
	public int updateCtDicCompany(CtDicCompany ctDicCompany);

	/**
	 * 删除企业信息
	 * 
	 * @param id 企业信息ID
	 * @return 结果
	 */
	public int deleteCtDicCompanyById(String id);

	/**
	 * 批量删除企业信息
	 * 
	 * @param ids 需要删除的数据ID
	 * @return 结果
	 */
	public int deleteCtDicCompanyByIds(String[] ids);
}

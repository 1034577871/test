package com.ruoyi.dictionary.company.serivce;

import java.util.List;

import com.ruoyi.dictionary.company.domain.CtDicCompany;

/**
 * @Title: ICtDicCompanyService.java
 * @Description: 企业信息Service接口
 * @Author M.Mu
 * @Date 2020-12-07
 */
public interface ICtDicCompanyService {
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
	 * 批量删除企业信息
	 * 
	 * @param ids 需要删除的企业信息ID
	 * @return 结果
	 */
	public int deleteCtDicCompanyByIds(String[] ids);

	/**
	 * 删除企业信息信息
	 * 
	 * @param id 企业信息ID
	 * @return 结果
	 */
	public int deleteCtDicCompanyById(String id);
}

package com.ruoyi.dictionary.taxrate.service;

import java.util.List;

import com.ruoyi.dictionary.taxrate.domain.dicTaxrate;

/**
 * 税率字典Service接口
 * 
 * @author Mu
 * @date 2020-12-21
 */
public interface IdicTaxrateService {
	
	/**
	 * 查询税率字典
	 * 
	 * @param id 税率字典ID
	 * @return 税率字典
	 */
	public dicTaxrate selectdicTaxrateById(String id);

	/**
	 * 查询税率字典列表
	 * 
	 * @param dicTaxrate 税率字典
	 * @return 税率字典集合
	 */
	public List<dicTaxrate> selectdicTaxrateList(dicTaxrate dicTaxrate);

	/**
	 * 新增税率字典
	 * 
	 * @param dicTaxrate 税率字典
	 * @return 结果
	 */
	public int insertdicTaxrate(dicTaxrate dicTaxrate);

	/**
	 * 修改税率字典
	 * 
	 * @param dicTaxrate 税率字典
	 * @return 结果
	 */
	public int updatedicTaxrate(dicTaxrate dicTaxrate);

	/**
	 * 批量删除税率字典
	 * 
	 * @param ids 需要删除的税率字典ID
	 * @return 结果
	 */
	public int deletedicTaxrateByIds(String[] ids);

	/**
	 * 删除税率字典信息
	 * 
	 * @param id 税率字典ID
	 * @return 结果
	 */
	public int deletedicTaxrateById(String id);
}

package com.ruoyi.dictionary.proType.mapper;

import java.util.List;

import com.ruoyi.dictionary.proType.domain.CtDicProtype;

/**
 * 项目类型字典Mapper接口
 * 
 * @author Mu
 * @date 2020-12-08
 */
public interface CtDicProtypeMapper {

	/**
	 * 查询项目类型字典
	 * 
	 * @param id 项目类型字典ID
	 * @return 项目类型字典
	 */
	public CtDicProtype selectCtDicProtypeById(String id);

	/**
	 * 查询项目类型字典列表
	 * 
	 * @param ctDicProtype 项目类型字典
	 * @return 项目类型字典集合
	 */
	public List<CtDicProtype> selectCtDicProtypeList(CtDicProtype ctDicProtype);

	/**
	 * 新增项目类型字典
	 * 
	 * @param ctDicProtype 项目类型字典
	 * @return 结果
	 */
	public int insertCtDicProtype(CtDicProtype ctDicProtype);

	/**
	 * 修改项目类型字典
	 * 
	 * @param ctDicProtype 项目类型字典
	 * @return 结果
	 */
	public int updateCtDicProtype(CtDicProtype ctDicProtype);

	/**
	 * 删除项目类型字典
	 * 
	 * @param id 项目类型字典ID
	 * @return 结果
	 */
	public int deleteCtDicProtypeById(String id);

	/**
	 * 批量删除项目类型字典
	 * 
	 * @param ids 需要删除的数据ID
	 * @return 结果
	 */
	public int deleteCtDicProtypeByIds(String[] ids);

	/**
	 * @Title: CtDicProtypeController.java
	 * @Description: 查询项目类型----用于工具类
	 * @Author M.Mu
	 * @Date 2020-12-08
	 */
	public List<CtDicProtype> findProjectType();
}
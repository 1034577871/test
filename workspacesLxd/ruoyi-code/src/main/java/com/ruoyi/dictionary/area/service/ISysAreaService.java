package com.ruoyi.dictionary.area.service;

import java.util.List;

import com.ruoyi.dictionary.area.domain.SysArea;

/**
 * 地区信息字典Service接口
 * 
 * @author Mu
 * @date 2020-12-08
 */
public interface ISysAreaService {
	/**
	 * 查询地区信息字典
	 * 
	 * @param id 地区信息字典ID
	 * @return 地区信息字典
	 */
	public SysArea selectSysAreaById(Integer id);

	/**
	 * 查询地区信息字典列表
	 * 
	 * @param sysArea 地区信息字典
	 * @return 地区信息字典集合
	 */
	public List<SysArea> selectSysAreaList(SysArea sysArea);

	/**
	 * 新增地区信息字典
	 * 
	 * @param sysArea 地区信息字典
	 * @return 结果
	 */
	public int insertSysArea(SysArea sysArea);

	/**
	 * 修改地区信息字典
	 * 
	 * @param sysArea 地区信息字典
	 * @return 结果
	 */
	public int updateSysArea(SysArea sysArea);

	/**
	 * 批量删除地区信息字典
	 * 
	 * @param ids 需要删除的地区信息字典ID
	 * @return 结果
	 */
	public int deleteSysAreaByIds(Integer[] ids);

	/**
	 * 删除地区信息字典信息
	 * 
	 * @param id 地区信息字典ID
	 * @return 结果
	 */
	public int deleteSysAreaById(Integer id);

	/**
	 * @Title: ISysAreaService.java
	 * @Description: 获取地区信息列表
	 * @Author M.Mu
	 * @Date 2020-12-08
	 */
	public Object findAreaList();
}
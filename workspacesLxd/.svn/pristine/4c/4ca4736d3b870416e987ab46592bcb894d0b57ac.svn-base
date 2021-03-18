package com.ruoyi.base.cache.service;

import java.util.List;

import com.ruoyi.common.core.domain.entity.SysDept;
import com.ruoyi.dictionary.proType.domain.CtDicProtype;

/**
 * @Title: CacheService.java
 * @Description: 缓存工具类(Redis)
 * @Author M.Mu
 * @Date 2020-12-12
 */
public interface CacheService {

	/**
	 * @Title: CacheService.java
	 * @Description: 根据项目类型ID获取项目类型名称
	 * @Author M.Mu
	 * @Date 2020-12-12
	 */
	public CtDicProtype findProtypeById(String id);

	/**
	 * @Title: CacheService.java
	 * @Description: 根据部门ID获取部门信息(分公司)
	 * @Author M.Mu
	 * @Date 2020-12-12
	 */
	public SysDept findSysDeptById(String id);

	/**
	 * @Title: CacheService.java
	 * @Description: 根据当前登录人获取所属分公司
	 * @Author M.Mu
	 * @Date 2020-12-16
	 */
	public String findLoginbyCompany();
	
	/**
	 * @Title: ISysDeptService.java
	 * @Description: 根据分公司ID获取下属部门信息
	 * @Author M.Mu
	 * @Date 2020-12-19
	 */
	public List<SysDept> findDeptByBranchOffice(String id);
}
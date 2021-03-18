package com.ruoyi.base.cache.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.ruoyi.base.cache.service.CacheService;
import com.ruoyi.common.core.domain.entity.SysDept;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.dictionary.proType.domain.CtDicProtype;
import com.ruoyi.dictionary.proType.service.ICtDicProtypeService;
import com.ruoyi.system.service.ISysDeptService;

/**
 * @Title: CacheService.java
 * @Description: 缓存工具类(Redis)
 * @Author M.Mu
 * @Date 2020-12-12
 */
@Service
public class CacheServiceImpl implements CacheService {

	@Autowired
	private RedisTemplate<String, Serializable> redis1;

	@Autowired
	private RedisTemplate<String, Serializable> redis5;

	@Autowired
	private ICtDicProtypeService protypeService;

	@Autowired
	private ISysDeptService deptService;

	/**
	 * @Title: CacheService.java
	 * @Description: 根据项目类型ID获取项目类型名称 ----后期需要根据项目编辑删除redis
	 * @Author M.Mu
	 * @Date 2020-12-12
	 */
	@Override
	public CtDicProtype findProtypeById(String id) {
		CtDicProtype protype = new CtDicProtype();
		if (StringUtils.isNotBlank(id)) {
			String key = "Project";
			String hashKey = id;
			/** 判断是否存在 **/
			if (redis1.opsForHash().hasKey(key, hashKey)!=null && redis1.opsForHash().hasKey(key, hashKey)) {
				protype = (CtDicProtype) redis1.opsForHash().get(key, hashKey);
				if (protype != null && StringUtils.isNotBlank(protype.getId())) {
					return protype;
				} else {
					redis1.opsForHash().delete(key, hashKey);
					return new CtDicProtype();
				}
			} else {
				protype = protypeService.selectCtDicProtypeById(id);
				if (protype != null && StringUtils.isNotBlank(protype.getId())) {
					/** 存放 **/
					redis1.opsForHash().put(key, hashKey, protype);
					return protype;
				} else {
					return new CtDicProtype();
				}
			}
		}
		return protype;
	}

	/**
	 * @Title: CacheService.java
	 * @Description: 根据部门ID获取部门信息(分公司)
	 * @Author M.Mu
	 * @Date 2020-12-12
	 */
	@Override
	public SysDept findSysDeptById(String id) {
		SysDept sysDept = new SysDept();
		if (StringUtils.isNotBlank(id)) {
			String key = "SysDept";
			String hashKey = id;
			/** 判断是否存在 **/
			if (redis1.opsForHash().hasKey(key, hashKey)!=null && redis1.opsForHash().hasKey(key, hashKey)) {
				sysDept = (SysDept) redis1.opsForHash().get(key, hashKey);
				if (sysDept != null && StringUtils.isNotBlank(sysDept.getDeptName())) {
					return sysDept;
				} else {
					redis1.opsForHash().delete(key, hashKey);
					return new SysDept();
				}
			} else {
				sysDept = deptService.selectDeptById(Long.valueOf(id));
				if (sysDept != null && StringUtils.isNotBlank(sysDept.getDeptName())) {
					/** 存放 **/
					redis1.opsForHash().put(key, hashKey, sysDept);
					return sysDept;
				}
			}
		}
		return sysDept;
	}

	/**
	 * @Title: CacheService.java
	 * @Description: 根据当前登录人获取所属分公司
	 * @Author M.Mu
	 * @Date 2020-12-16
	 */
	@Override
	public String findLoginbyCompany() {
		String key = "LoginbyCompany";
		String hashKey = "";
		String companyName = "";
		try {
			hashKey = SecurityUtils.getLoginUser().getUser().getCompanyId().toString();
		} catch (Exception e) {

		}
		if (StringUtils.isNotBlank(hashKey)) {
			/** 判断是否存在该用户所属分公司 **/
			if (redis5.opsForHash().hasKey(key, hashKey)) {
				companyName = (String) redis5.opsForHash().get(key, hashKey);
			} else {
				/** 根据当前登录人ID获取所属分公司名称 **/
				SysDept sysDept = deptService.selectDeptById(Long.valueOf(hashKey));
				if (sysDept != null && StringUtils.isNotBlank(sysDept.getDeptName())) {
					companyName = sysDept.getDeptName();
					redis5.opsForHash().put(key, hashKey, companyName);
				}
			}
		}
		return companyName;
	}

	/**
	 * @Title: ISysDeptService.java
	 * @Description: 根据分公司ID获取下属部门信息
	 * @Author M.Mu
	 * @Date 2020-12-19
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<SysDept> findDeptByBranchOffice(String id) {
		String key = "DeptByBranchOffice";
		String hashKey = id;
		List<SysDept> list = new ArrayList<>();
		if (redis1.opsForHash().hasKey(key, hashKey)) {
			list = (List<SysDept>) redis1.opsForHash().get(key, hashKey);
		} else {
			list = deptService.findDeptByBranchOffice(id);
			if (list != null && !list.isEmpty()) {
				redis1.opsForHash().put(key, hashKey, list);
			}
		}
		return list;
	}
}
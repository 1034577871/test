package com.ruoyi.dictionary.proType.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.uuid.UUID;
import com.ruoyi.dictionary.proType.domain.CtDicProtype;
import com.ruoyi.dictionary.proType.mapper.CtDicProtypeMapper;
import com.ruoyi.dictionary.proType.service.ICtDicProtypeService;

/**
 * 项目类型字典Service业务层处理
 * 
 * @author Mu
 * @date 2020-12-08
 */
@Service
public class CtDicProtypeServiceImpl implements ICtDicProtypeService {
	
	@Autowired
	private CtDicProtypeMapper ctDicProtypeMapper;

	/**
	 * 查询项目类型字典
	 * 
	 * @param id 项目类型字典ID
	 * @return 项目类型字典
	 */
	@Override
	public CtDicProtype selectCtDicProtypeById(String id) {
		return ctDicProtypeMapper.selectCtDicProtypeById(id);
	}

	/**
	 * 查询项目类型字典列表
	 * 
	 * @param ctDicProtype 项目类型字典
	 * @return 项目类型字典
	 */
	@Override
	public List<CtDicProtype> selectCtDicProtypeList(CtDicProtype ctDicProtype) {
		return ctDicProtypeMapper.selectCtDicProtypeList(ctDicProtype);
	}

	/**
	 * 新增项目类型字典
	 * 
	 * @param ctDicProtype 项目类型字典
	 * @return 结果
	 */
	@Override
	public int insertCtDicProtype(CtDicProtype ctDicProtype) {
		ctDicProtype.setId(UUID.fastUUID().toString(true));
		String userid = "";
		try {
			userid = SecurityUtils.getLoginUser().getUser().getUserId().toString();
		} catch (Exception e) {
			
		}
		ctDicProtype.setCreateBy(userid);
		ctDicProtype.setDelFlag(1);
		ctDicProtype.setCreateTime(DateUtils.getNowDate());
		return ctDicProtypeMapper.insertCtDicProtype(ctDicProtype);
	}

	/**
	 * 修改项目类型字典
	 * 
	 * @param ctDicProtype 项目类型字典
	 * @return 结果
	 */
	@Override
	public int updateCtDicProtype(CtDicProtype ctDicProtype) {
		ctDicProtype.setUpdateTime(DateUtils.getNowDate());
		String userid = "";
		try {
			userid = SecurityUtils.getLoginUser().getUser().getUserId().toString();
		} catch (Exception e) {
			
		}
		ctDicProtype.setUpdateBy(userid);
		return ctDicProtypeMapper.updateCtDicProtype(ctDicProtype);
	}

	/**
	 * 批量删除项目类型字典
	 * 
	 * @param ids 需要删除的项目类型字典ID
	 * @return 结果
	 */
	@Override
	public int deleteCtDicProtypeByIds(String[] ids) {
		return ctDicProtypeMapper.deleteCtDicProtypeByIds(ids);
	}

	/**
	 * 删除项目类型字典信息
	 * 
	 * @param id 项目类型字典ID
	 * @return 结果
	 */
	@Override
	public int deleteCtDicProtypeById(String id) {
		return ctDicProtypeMapper.deleteCtDicProtypeById(id);
	}

	/**
	 * @Title: CtDicProtypeController.java
	 * @Description: 查询项目类型----用于工具类
	 * @Author M.Mu
	 * @Date 2020-12-08
	 */
	@Override
	public List<CtDicProtype> findProjectType() {
		
		return ctDicProtypeMapper.findProjectType();
	}
}
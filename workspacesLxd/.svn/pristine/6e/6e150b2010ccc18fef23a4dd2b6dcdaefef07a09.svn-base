package com.ruoyi.dictionary.taxrate.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.uuid.UUID;
import com.ruoyi.dictionary.taxrate.domain.dicTaxrate;
import com.ruoyi.dictionary.taxrate.mapper.dicTaxrateMapper;
import com.ruoyi.dictionary.taxrate.service.IdicTaxrateService;

/**
 * 税率字典Service业务层处理
 * 
 * @author Mu
 * @date 2020-12-21
 */
@Service
public class dicTaxrateServiceImpl implements IdicTaxrateService {

	@Autowired
	private dicTaxrateMapper dicTaxrateMapper;

	/**
	 * 查询税率字典
	 * 
	 * @param id 税率字典ID
	 * @return 税率字典
	 */
	@Override
	public dicTaxrate selectdicTaxrateById(String id) {
		return dicTaxrateMapper.selectdicTaxrateById(id);
	}

	/**
	 * 查询税率字典列表
	 * 
	 * @param dicTaxrate 税率字典
	 * @return 税率字典
	 */
	@Override
	public List<dicTaxrate> selectdicTaxrateList(dicTaxrate dicTaxrate) {
		return dicTaxrateMapper.selectdicTaxrateList(dicTaxrate);
	}

	/**
	 * 新增税率字典
	 * 
	 * @param dicTaxrate 税率字典
	 * @return 结果
	 */
	@Override
	public int insertdicTaxrate(dicTaxrate dicTaxrate) {
		dicTaxrate.setId(UUID.fastUUID().toString(true));
		String userId = "";
		try {
			userId = SecurityUtils.getLoginUser().getUser().getUserId().toString();
			if(StringUtils.isNotBlank(userId)) {
				dicTaxrate.setCreateBy(userId);
			}
		} catch (Exception e) {
			
		}
		dicTaxrate.setCreateTime(DateUtils.getNowDate());
		dicTaxrate.setDelFlag(1);
		return dicTaxrateMapper.insertdicTaxrate(dicTaxrate);
	}

	/**
	 * 修改税率字典
	 * 
	 * @param dicTaxrate 税率字典
	 * @return 结果
	 */
	@Override
	public int updatedicTaxrate(dicTaxrate dicTaxrate) {
		String userId = "";
		try {
			userId = SecurityUtils.getLoginUser().getUser().getUserId().toString();
			if(StringUtils.isNotBlank(userId)) {
				dicTaxrate.setUpdateBy(userId);
			}
		} catch (Exception e) {
			
		}
		dicTaxrate.setUpdateTime(DateUtils.getNowDate());
		return dicTaxrateMapper.updatedicTaxrate(dicTaxrate);
	}

	/**
	 * 批量删除税率字典
	 * 
	 * @param ids 需要删除的税率字典ID
	 * @return 结果
	 */
	@Override
	public int deletedicTaxrateByIds(String[] ids) {
		if (ids != null && ids.length > 0) {
			for (int i = 0; i < ids.length; i++) {
				dicTaxrateMapper.deletedicTaxrateById(ids[i]);
			}
		}
		return 1;
	}

	/**
	 * 删除税率字典信息
	 * 
	 * @param id 税率字典ID
	 * @return 结果
	 */
	@Override
	public int deletedicTaxrateById(String id) {
		return dicTaxrateMapper.deletedicTaxrateById(id);
	}
}

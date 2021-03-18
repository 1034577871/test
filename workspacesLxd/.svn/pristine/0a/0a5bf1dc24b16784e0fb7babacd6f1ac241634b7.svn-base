package com.ruoyi.dictionary.company.serivce.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.uuid.UUID;
import com.ruoyi.dictionary.company.domain.CtDicCompany;
import com.ruoyi.dictionary.company.mapper.CtDicCompanyMapper;
import com.ruoyi.dictionary.company.serivce.ICtDicCompanyService;

/**
 * 企业信息Service业务层处理
 * 
 * @author Mu
 * @date 2020-12-07
 */
@Service
public class CtDicCompanyServiceImpl implements ICtDicCompanyService {
	@Autowired
	private CtDicCompanyMapper ctDicCompanyMapper;

	/**
	 * 查询企业信息
	 * 
	 * @param id 企业信息ID
	 * @return 企业信息
	 */
	@Override
	public CtDicCompany selectCtDicCompanyById(String id) {
		return ctDicCompanyMapper.selectCtDicCompanyById(id);
	}

	/**
	 * 查询企业信息列表
	 * 
	 * @param ctDicCompany 企业信息
	 * @return 企业信息
	 */
	@Override
	public List<CtDicCompany> selectCtDicCompanyList(CtDicCompany ctDicCompany) {
		return ctDicCompanyMapper.selectCtDicCompanyList(ctDicCompany);
	}

	/**
	 * 新增企业信息
	 * 
	 * @param ctDicCompany 企业信息
	 * @return 结果
	 */
	@Override
	public int insertCtDicCompany(CtDicCompany ctDicCompany) {
		ctDicCompany.setId(UUID.fastUUID().toString(true));
		ctDicCompany.setDelFlag(1);
		/** 判断当前登录人 **/
		LoginUser loginUser = SecurityUtils.getLoginUser();
		if (loginUser != null && loginUser.getUser() != null) {
			ctDicCompany.setCreateBy(loginUser.getUser().getUserId().toString());
		}
		ctDicCompany.setCreateTime(DateUtils.getNowDate());
		return ctDicCompanyMapper.insertCtDicCompany(ctDicCompany);
	}

	/**
	 * 修改企业信息
	 * 
	 * @param ctDicCompany 企业信息
	 * @return 结果
	 */
	@Override
	public int updateCtDicCompany(CtDicCompany ctDicCompany) {
		ctDicCompany.setUpdateTime(DateUtils.getNowDate());
		String userid = "";
		try {
			userid = SecurityUtils.getLoginUser().getUser().getUserId().toString();
		} catch (Exception e) {
			
		}
		ctDicCompany.setUpdateBy(userid);
		return ctDicCompanyMapper.updateCtDicCompany(ctDicCompany);
	}

	/**
	 * 批量删除企业信息
	 * 
	 * @param ids 需要删除的企业信息ID
	 * @return 结果
	 */
	@Override
	public int deleteCtDicCompanyByIds(String[] ids) {
		return ctDicCompanyMapper.deleteCtDicCompanyByIds(ids);
	}

	/**
	 * 删除企业信息信息
	 * 
	 * @param id 企业信息ID
	 * @return 结果
	 */
	@Override
	public int deleteCtDicCompanyById(String id) {
		return ctDicCompanyMapper.deleteCtDicCompanyById(id);
	}
}

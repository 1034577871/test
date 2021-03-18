package com.ruoyi.contract.contractContent.service.impl;

import java.util.HashMap;
import java.util.List;

import com.ruoyi.common.core.domain.entity.SysDept;
import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.system.mapper.SysDeptMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.contract.contractContent.mapper.CtBuContractContentMapper;
import com.ruoyi.contract.contractContent.domain.CtBuContractContent;
import com.ruoyi.contract.contractContent.service.ICtBuContractContentService;
import com.ruoyi.contract.contractPayinfo.domain.CtBuContractPayinfo;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * 合同内容Service业务层处理
 *
 * @author ruoyi
 * @date 2020-12-09
 */
@Service
public class CtBuContractContentServiceImpl implements ICtBuContractContentService {
    @Autowired
    private CtBuContractContentMapper ctBuContractContentMapper;

    /**
     * 查询合同内容
     *
     * @param id 合同内容ID
     * @return 合同内容
     */
    @Override
    public CtBuContractContent selectCtBuContractContentById(String id) {
        return ctBuContractContentMapper.selectCtBuContractContentById(id);
    }

    /**
     * 查询合同内容列表
     *
     * @param ctBuContractContent 合同内容
     * @return 合同内容
     */
    @Override
    public List<CtBuContractContent> selectCtBuContractContentList(CtBuContractContent ctBuContractContent) {
        return ctBuContractContentMapper.selectCtBuContractContentList(ctBuContractContent);
    }

    /**
     * 新增合同内容
     *
     * @param ctBuContractContent 合同内容
     * @return 结果
     */
    @Override
    public int insertCtBuContractContent(CtBuContractContent ctBuContractContent) {
        ctBuContractContent.setCreateTime(DateUtils.getNowDate());
        return ctBuContractContentMapper.insertCtBuContractContent(ctBuContractContent);
    }

    /**
     * 修改合同内容
     *
     * @param ctBuContractContent 合同内容
     * @return 结果
     */
    @Override
    public int updateCtBuContractContent(CtBuContractContent ctBuContractContent) {
        ctBuContractContent.setUpdateTime(DateUtils.getNowDate());
        return ctBuContractContentMapper.updateCtBuContractContent(ctBuContractContent);
    }

    /**
     * 批量删除合同内容
     *
     * @param ids 需要删除的合同内容ID
     * @return 结果
     */
    @Override
    public int deleteCtBuContractContentByIds(String[] ids) {
        return ctBuContractContentMapper.deleteCtBuContractContentByIds(ids);
    }

    /**
     * 删除合同内容信息
     *
     * @param id 合同内容ID
     * @return 结果
     */
    @Override
    public int deleteCtBuContractContentById(String id) {
        return ctBuContractContentMapper.deleteCtBuContractContentById(id);
    }

    /**
     * 批量删除合同内容
     *
     * @param ids 需要删除的合同内容ID
     * @return 结果
     */
    @Override
    public int updateCtBuContractContentByIds(String[] ids) {
        return ctBuContractContentMapper.updateCtBuContractContentByIds(ids);
    }


}

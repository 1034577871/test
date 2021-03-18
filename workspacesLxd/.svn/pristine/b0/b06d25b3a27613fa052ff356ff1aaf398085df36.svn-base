package com.ruoyi.projectApproval.ApprovalNg.service.impl;

import java.util.List;

import com.ruoyi.projectApproval.ApprovalNg.domain.CtBuConstructionInfo;
import com.ruoyi.projectApproval.ApprovalNg.mapper.CtBuConstructionInfoMapper;
import com.ruoyi.projectApproval.ApprovalNg.service.ICtBuConstructionInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ConstructionInfoService业务层处理
 * 
 * @author ruoyi
 * @date 2021-02-23
 */
@Service
public class CtBuConstructionInfoServiceImpl implements ICtBuConstructionInfoService
{
    @Autowired
    private CtBuConstructionInfoMapper ctBuConstructionInfoMapper;

    /**
     * 查询ConstructionInfo
     * 
     * @param id ConstructionInfoID
     * @return ConstructionInfo
     */
    @Override
    public CtBuConstructionInfo selectCtBuConstructionInfoById(Long id)
    {
        return ctBuConstructionInfoMapper.selectCtBuConstructionInfoById(id);
    }

    /**
     * 查询ConstructionInfo列表
     * 
     * @param ctBuConstructionInfo ConstructionInfo
     * @return ConstructionInfo
     */
    @Override
    public List<CtBuConstructionInfo> selectCtBuConstructionInfoList(CtBuConstructionInfo ctBuConstructionInfo)
    {
        return ctBuConstructionInfoMapper.selectCtBuConstructionInfoList(ctBuConstructionInfo);
    }

    /**
     * 新增ConstructionInfo
     * 
     * @param ctBuConstructionInfo ConstructionInfo
     * @return 结果
     */
    @Override
    public int insertCtBuConstructionInfo(CtBuConstructionInfo ctBuConstructionInfo)
    {
        return ctBuConstructionInfoMapper.insertCtBuConstructionInfo(ctBuConstructionInfo);
    }

    /**
     * 修改ConstructionInfo
     * 
     * @param ctBuConstructionInfo ConstructionInfo
     * @return 结果
     */
    @Override
    public int updateCtBuConstructionInfo(CtBuConstructionInfo ctBuConstructionInfo)
    {
        return ctBuConstructionInfoMapper.updateCtBuConstructionInfo(ctBuConstructionInfo);
    }

    /**
     * 批量删除ConstructionInfo
     * 
     * @param ids 需要删除的ConstructionInfoID
     * @return 结果
     */
    @Override
    public int deleteCtBuConstructionInfoByIds(Long[] ids)
    {
        return ctBuConstructionInfoMapper.deleteCtBuConstructionInfoByIds(ids);
    }

    /**
     * 删除ConstructionInfo信息
     * 
     * @param id ConstructionInfoID
     * @return 结果
     */
    @Override
    public int deleteCtBuConstructionInfoById(Long id)
    {
        return ctBuConstructionInfoMapper.deleteCtBuConstructionInfoById(id);
    }
}

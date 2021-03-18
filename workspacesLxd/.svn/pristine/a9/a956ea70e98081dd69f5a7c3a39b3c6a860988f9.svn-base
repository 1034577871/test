package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.CtBuMaterielInfoMapper;
import com.ruoyi.system.domain.CtBuMaterielInfo;
import com.ruoyi.system.service.ICtBuMaterielInfoService;

/**
 * ctBuMaterielInfoService业务层处理
 * 
 * @author ruoyi
 * @date 2021-02-23
 */
@Service
public class CtBuMaterielInfoServiceImpl implements ICtBuMaterielInfoService 
{
    @Autowired
    private CtBuMaterielInfoMapper ctBuMaterielInfoMapper;

    /**
     * 查询ctBuMaterielInfo
     * 
     * @param id ctBuMaterielInfoID
     * @return ctBuMaterielInfo
     */
    @Override
    public CtBuMaterielInfo selectCtBuMaterielInfoById(Long id)
    {
        return ctBuMaterielInfoMapper.selectCtBuMaterielInfoById(id);
    }

    /**
     * 查询ctBuMaterielInfo列表
     * 
     * @param ctBuMaterielInfo ctBuMaterielInfo
     * @return ctBuMaterielInfo
     */
    @Override
    public List<CtBuMaterielInfo> selectCtBuMaterielInfoList(CtBuMaterielInfo ctBuMaterielInfo)
    {
        return ctBuMaterielInfoMapper.selectCtBuMaterielInfoList(ctBuMaterielInfo);
    }

    /**
     * 新增ctBuMaterielInfo
     * 
     * @param ctBuMaterielInfo ctBuMaterielInfo
     * @return 结果
     */
    @Override
    public int insertCtBuMaterielInfo(CtBuMaterielInfo ctBuMaterielInfo)
    {
        return ctBuMaterielInfoMapper.insertCtBuMaterielInfo(ctBuMaterielInfo);
    }

    /**
     * 修改ctBuMaterielInfo
     * 
     * @param ctBuMaterielInfo ctBuMaterielInfo
     * @return 结果
     */
    @Override
    public int updateCtBuMaterielInfo(CtBuMaterielInfo ctBuMaterielInfo)
    {
        return ctBuMaterielInfoMapper.updateCtBuMaterielInfo(ctBuMaterielInfo);
    }

    /**
     * 批量删除ctBuMaterielInfo
     * 
     * @param ids 需要删除的ctBuMaterielInfoID
     * @return 结果
     */
    @Override
    public int deleteCtBuMaterielInfoByIds(Long[] ids)
    {
        return ctBuMaterielInfoMapper.deleteCtBuMaterielInfoByIds(ids);
    }

    /**
     * 删除ctBuMaterielInfo信息
     * 
     * @param id ctBuMaterielInfoID
     * @return 结果
     */
    @Override
    public int deleteCtBuMaterielInfoById(Long id)
    {
        return ctBuMaterielInfoMapper.deleteCtBuMaterielInfoById(id);
    }
}

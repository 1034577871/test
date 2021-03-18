package com.ruoyi.projectApproval.ApprovalNg.service;

import com.ruoyi.projectApproval.ApprovalNg.domain.CtBuConstructionInfo;

import java.util.List;

/**
 * ConstructionInfoService接口
 * 
 * @author ruoyi
 * @date 2021-02-23
 */
public interface ICtBuConstructionInfoService 
{
    /**
     * 查询ConstructionInfo
     * 
     * @param id ConstructionInfoID
     * @return ConstructionInfo
     */
    public CtBuConstructionInfo selectCtBuConstructionInfoById(Long id);

    /**
     * 查询ConstructionInfo列表
     * 
     * @param ctBuConstructionInfo ConstructionInfo
     * @return ConstructionInfo集合
     */
    public List<CtBuConstructionInfo> selectCtBuConstructionInfoList(CtBuConstructionInfo ctBuConstructionInfo);

    /**
     * 新增ConstructionInfo
     * 
     * @param ctBuConstructionInfo ConstructionInfo
     * @return 结果
     */
    public int insertCtBuConstructionInfo(CtBuConstructionInfo ctBuConstructionInfo);

    /**
     * 修改ConstructionInfo
     * 
     * @param ctBuConstructionInfo ConstructionInfo
     * @return 结果
     */
    public int updateCtBuConstructionInfo(CtBuConstructionInfo ctBuConstructionInfo);

    /**
     * 批量删除ConstructionInfo
     * 
     * @param ids 需要删除的ConstructionInfoID
     * @return 结果
     */
    public int deleteCtBuConstructionInfoByIds(Long[] ids);

    /**
     * 删除ConstructionInfo信息
     * 
     * @param id ConstructionInfoID
     * @return 结果
     */
    public int deleteCtBuConstructionInfoById(Long id);
}

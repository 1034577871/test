package com.ruoyi.projectApproval.ApprovalNg.mapper;

import com.ruoyi.projectApproval.ApprovalNg.domain.CtBuConstructionInfo;

import java.util.List;

/**
 * ConstructionInfoMapper接口
 * 
 * @author ruoyi
 * @date 2021-02-23
 */
public interface CtBuConstructionInfoMapper 
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
     * 删除ConstructionInfo
     * 
     * @param id ConstructionInfoID
     * @return 结果
     */
    public int deleteCtBuConstructionInfoById(Long id);

    /**
     * 批量删除ConstructionInfo
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteCtBuConstructionInfoByIds(Long[] ids);
}

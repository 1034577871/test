package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.CtBuMaterielInfo;

/**
 * ctBuMaterielInfoMapper接口
 * 
 * @author ruoyi
 * @date 2021-02-23
 */
public interface CtBuMaterielInfoMapper 
{
    /**
     * 查询ctBuMaterielInfo
     * 
     * @param id ctBuMaterielInfoID
     * @return ctBuMaterielInfo
     */
    public CtBuMaterielInfo selectCtBuMaterielInfoById(Long id);

    /**
     * 查询ctBuMaterielInfo列表
     * 
     * @param ctBuMaterielInfo ctBuMaterielInfo
     * @return ctBuMaterielInfo集合
     */
    public List<CtBuMaterielInfo> selectCtBuMaterielInfoList(CtBuMaterielInfo ctBuMaterielInfo);

    /**
     * 新增ctBuMaterielInfo
     * 
     * @param ctBuMaterielInfo ctBuMaterielInfo
     * @return 结果
     */
    public int insertCtBuMaterielInfo(CtBuMaterielInfo ctBuMaterielInfo);

    /**
     * 修改ctBuMaterielInfo
     * 
     * @param ctBuMaterielInfo ctBuMaterielInfo
     * @return 结果
     */
    public int updateCtBuMaterielInfo(CtBuMaterielInfo ctBuMaterielInfo);

    /**
     * 删除ctBuMaterielInfo
     * 
     * @param id ctBuMaterielInfoID
     * @return 结果
     */
    public int deleteCtBuMaterielInfoById(Long id);

    /**
     * 批量删除ctBuMaterielInfo
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteCtBuMaterielInfoByIds(Long[] ids);
}

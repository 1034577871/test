package com.ruoyi.collection.mapper;

import java.util.List;
import com.ruoyi.collection.domain.CtBuReceiptInfo;

/**
 * 收款单录入Mapper接口
 * 
 * @author ruoyi
 * @date 2020-12-10
 */
public interface CtBuReceiptInfoMapper 
{

    public List<CtBuReceiptInfo> selectHxCtBuReceiptInfoList(CtBuReceiptInfo ctBuReceiptInfo);
    /**
     * 查询收款单录入为录入列表
     *
     * @param ctBuReceiptInfo 收款单录入
     * @return 收款单录入集合
     */
    public List<CtBuReceiptInfo> selectCtBuReceiptInfoList_(CtBuReceiptInfo ctBuReceiptInfo);
    /**
     * 查询收款单录入列表
     *
     * @param ctBuReceiptInfo 收款单录入
     * @return 收款单录入集合
     */
    public List<CtBuReceiptInfo> selectNewCtBuReceiptInfoList(CtBuReceiptInfo ctBuReceiptInfo);
    /**
     * 查询收款单录入
     * 
     * @param id 收款单录入ID
     * @return 收款单录入
     */
    public CtBuReceiptInfo selectCtBuReceiptInfoById(String id);

    /**
     * 查询收款单录入列表
     * 
     * @param ctBuReceiptInfo 收款单录入
     * @return 收款单录入集合
     */
    public List<CtBuReceiptInfo> selectCtBuReceiptInfoList(CtBuReceiptInfo ctBuReceiptInfo);

    /**
     * 新增收款单录入
     * 
     * @param ctBuReceiptInfo 收款单录入
     * @return 结果
     */
    public int insertCtBuReceiptInfo(CtBuReceiptInfo ctBuReceiptInfo);

    /**
     * 修改收款单录入
     * 
     * @param ctBuReceiptInfo 收款单录入
     * @return 结果
     */
    public int updateCtBuReceiptInfo(CtBuReceiptInfo ctBuReceiptInfo);

    /**
     * 删除收款单录入
     * 
     * @param id 收款单录入ID
     * @return 结果
     */
    public int deleteCtBuReceiptInfoById(String id);

    /**
     * 批量删除收款单录入
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteCtBuReceiptInfoByIds(String[] ids);

    /**
     * 修改收款单录入
     *
     * @param ctBuReceiptInfo 收款单录入
     * @return 结果
     */
    public int updateEndCtBuReceiptInfo(CtBuReceiptInfo ctBuReceiptInfo);

    public int updateCtBuReceiptInfoByIds(String[] id);


}

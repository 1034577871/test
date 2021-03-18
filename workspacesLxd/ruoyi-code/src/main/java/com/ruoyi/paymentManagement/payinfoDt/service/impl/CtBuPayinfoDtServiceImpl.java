package com.ruoyi.paymentManagement.payinfoDt.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.paymentManagement.payinfoDt.mapper.CtBuPayinfoDtMapper;
import com.ruoyi.paymentManagement.payinfoDt.domain.CtBuPayinfoDt;
import com.ruoyi.paymentManagement.payinfoDt.service.ICtBuPayinfoDtService;

/**
 * 付款申请单明细Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-01-12
 */
@Service
public class CtBuPayinfoDtServiceImpl implements ICtBuPayinfoDtService 
{
    @Autowired
    private CtBuPayinfoDtMapper ctBuPayinfoDtMapper;

    /**
     * 查询付款申请单明细
     * 
     * @param id 付款申请单明细ID
     * @return 付款申请单明细
     */
    @Override
    public CtBuPayinfoDt selectCtBuPayinfoDtById(String id)
    {
        return ctBuPayinfoDtMapper.selectCtBuPayinfoDtById(id);
    }

    /**
     * 查询付款申请单明细列表
     * 
     * @param ctBuPayinfoDt 付款申请单明细
     * @return 付款申请单明细
     */
    @Override
    public List<CtBuPayinfoDt> selectCtBuPayinfoDtList(CtBuPayinfoDt ctBuPayinfoDt)
    {
        return ctBuPayinfoDtMapper.selectCtBuPayinfoDtList(ctBuPayinfoDt);
    }

    /**
     * 新增付款申请单明细
     * 
     * @param ctBuPayinfoDt 付款申请单明细
     * @return 结果
     */
    @Override
    public int insertCtBuPayinfoDt(CtBuPayinfoDt ctBuPayinfoDt)
    {
        ctBuPayinfoDt.setCreateTime(DateUtils.getNowDate());
        return ctBuPayinfoDtMapper.insertCtBuPayinfoDt(ctBuPayinfoDt);
    }

    /**
     * 修改付款申请单明细
     * 
     * @param ctBuPayinfoDt 付款申请单明细
     * @return 结果
     */
    @Override
    public int updateCtBuPayinfoDt(CtBuPayinfoDt ctBuPayinfoDt)
    {
        ctBuPayinfoDt.setUpdateTime(DateUtils.getNowDate());
        return ctBuPayinfoDtMapper.updateCtBuPayinfoDt(ctBuPayinfoDt);
    }

    /**
     * 批量删除付款申请单明细
     * 
     * @param ids 需要删除的付款申请单明细ID
     * @return 结果
     */
    @Override
    public int deleteCtBuPayinfoDtByIds(String[] ids)
    {
        return ctBuPayinfoDtMapper.deleteCtBuPayinfoDtByIds(ids);
    }

    /**
     * 删除付款申请单明细信息
     * 
     * @param id 付款申请单明细ID
     * @return 结果
     */
    @Override
    public int deleteCtBuPayinfoDtById(String id)
    {
        return ctBuPayinfoDtMapper.deleteCtBuPayinfoDtById(id);
    }
}

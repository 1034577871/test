package com.ruoyi.projectApproval.AppNgConst.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.projectApproval.AppNgConst.domain.AppNgConst;
import com.ruoyi.projectApproval.AppNgConst.mapper.AppNgConstMapper;
import com.ruoyi.projectApproval.AppNgConst.service.IAppNgConstService;

/**
 * 事前审批明细(集客类-施工费情况)Service业务层处理
 *
 * @author Mu
 * @date 2020-12-09
 */
@Service
public class AppNgConstServiceImpl implements IAppNgConstService {

    @Autowired
    private AppNgConstMapper appNgConstMapper;

    /**
     * 查询事前审批明细(集客类-施工费情况)
     *
     * @param id 事前审批明细(集客类-施工费情况)ID
     * @return 事前审批明细(集客类 - 施工费情况)
     */
    @Override
    public AppNgConst selectAppNgConstById(String id) {
        return appNgConstMapper.selectAppNgConstById(id);
    }

    /**
     * @Title: IAppNgConstService.java
     * @Description: 根据事前审批主表ID获取施工费信息
     * @Author M.Mu
     * @Date 2020-12-09
     */
    @Override
    public AppNgConst selectAppNgConstByBid(String id) {

        return appNgConstMapper.selectAppNgConstByBid(id);
    }

    /**
     * 查询事前审批明细(集客类-施工费情况)列表
     *
     * @param appNgConst 事前审批明细(集客类-施工费情况)
     * @return 事前审批明细(集客类 - 施工费情况)
     */
    @Override
    public List<AppNgConst> selectAppNgConstList(AppNgConst appNgConst) {
        return appNgConstMapper.selectAppNgConstList(appNgConst);
    }

    /**
     * 新增事前审批明细(集客类-施工费情况)
     *
     * @param appNgConst 事前审批明细(集客类-施工费情况)
     * @return 结果
     */
    @Override
    public int insertAppNgConst(AppNgConst appNgConst) {
        appNgConst.setCreateTime(DateUtils.getNowDate());
        return appNgConstMapper.insertAppNgConst(appNgConst);
    }

    /**
     * 修改事前审批明细(集客类-施工费情况)
     *
     * @param appNgConst 事前审批明细(集客类-施工费情况)
     * @return 结果
     */
    @Override
    public int updateAppNgConst(AppNgConst appNgConst) {
        appNgConst.setUpdateTime(DateUtils.getNowDate());
        return appNgConstMapper.updateAppNgConst(appNgConst);
    }

    /**
     * 批量删除事前审批明细(集客类-施工费情况)
     *
     * @param ids 需要删除的事前审批明细(集客类-施工费情况)ID
     * @return 结果
     */
    @Override
    public int deleteAppNgConstByIds(String[] ids) {
        return appNgConstMapper.deleteAppNgConstByIds(ids);
    }

    /**
     * 删除事前审批明细(集客类-施工费情况)信息
     *
     * @param id 事前审批明细(集客类-施工费情况)ID
     * @return 结果
     */
    @Override
    public int deleteAppNgConstById(String id) {
        return appNgConstMapper.deleteAppNgConstById(id);
    }

    /**
     * @Title: IAppNgConstService.java
     * @Description: 根据事前审批主表ID逻辑删除施工费信息
     * @Author M.Mu
     * @Date 2020-12-09
     */
    @Override
    public int deleteAppNgConstByBid(String id) {

        return appNgConstMapper.deleteAppNgConstByBid(id);
    }
}
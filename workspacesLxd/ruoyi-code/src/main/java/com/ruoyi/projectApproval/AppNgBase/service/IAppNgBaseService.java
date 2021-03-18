package com.ruoyi.projectApproval.AppNgBase.service;

import java.util.List;

import com.ruoyi.projectApproval.AppNgBase.domain.AppNgBase;

/**
 * 事前审批明细(集客类-项目基本情况)Service接口
 *
 * @author Mu
 * @date 2020-12-09
 */
public interface IAppNgBaseService {

    /**
     * 查询事前审批明细(集客类-项目基本情况)
     *
     * @param id 事前审批明细(集客类-项目基本情况)ID
     * @return 事前审批明细(集客类 - 项目基本情况)
     */
    public AppNgBase selectAppNgBaseById(String id);

    /**
     * @Title: IAppNgBaseService.java
     * @Description: 根据事前审批主表ID获取基本信息
     * @Author M.Mu
     * @Date 2020-12-09
     */
    public AppNgBase selectAppNgBaseByBid(String id);

    /**
     * 查询事前审批明细(集客类-项目基本情况)列表
     *
     * @param appNgBase 事前审批明细(集客类-项目基本情况)
     * @return 事前审批明细(集客类 - 项目基本情况)集合
     */
    public List<AppNgBase> selectAppNgBaseList(AppNgBase appNgBase);

    /**
     * 新增事前审批明细(集客类-项目基本情况)
     *
     * @param appNgBase 事前审批明细(集客类-项目基本情况)
     * @return 结果
     */
    public int insertAppNgBase(AppNgBase appNgBase);

    /**
     * 修改事前审批明细(集客类-项目基本情况)
     *
     * @param appNgBase 事前审批明细(集客类-项目基本情况)
     * @return 结果
     */
    public int updateAppNgBase(AppNgBase appNgBase);

    /**
     * 批量删除事前审批明细(集客类-项目基本情况)
     *
     * @param ids 需要删除的事前审批明细(集客类-项目基本情况)ID
     * @return 结果
     */
    public int deleteAppNgBaseByIds(String[] ids);

    /**
     * 删除事前审批明细(集客类-项目基本情况)信息
     *
     * @param id 事前审批明细(集客类-项目基本情况)ID
     * @return 结果
     */
    public int deleteAppNgBaseById(String id);

    /**
     * @Title: IAppNgBaseService.java
     * @Description: 根据事前审批主表ID逻辑删除项目基本信息
     * @Author M.Mu
     * @Date 2020-12-09
     */
    public int deleteAppNgBaseByBid(String id);
}

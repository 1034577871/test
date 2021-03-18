package com.ruoyi.projectApproval.AppNgc.service;

import java.util.List;

import com.ruoyi.projectApproval.AppNgc.domain.AppNgc;

/**
 * 非集客项目Service接口
 *
 * @author ruoyi
 * @date 2020-12-11
 */
public interface IAppNgcService {
    /**
     * 查询非集客项目
     *
     * @param id 非集客项目ID
     * @return 非集客项目
     */
    public AppNgc selectAppNgcById(String id);

    /**
     * 查询非集客项目列表
     *
     * @param appNgc 非集客项目
     * @return 非集客项目集合
     */
    public List<AppNgc> selectAppNgcList(AppNgc appNgc);

    /**
     * 新增非集客项目
     *
     * @param appNgc 非集客项目
     * @return 结果
     */
    public int insertAppNgc(AppNgc appNgc);

    /**
     * 修改非集客项目
     *
     * @param appNgc 非集客项目
     * @return 结果
     */
    public int updateAppNgc(AppNgc appNgc);

    /**
     * 修改非集客项目 根据instancid
     *
     * @param appNgc 非集客项目
     * @return 结果
     */
    public int updateAppNgcByInstanceId(AppNgc appNgc);

    /**
     * 批量删除非集客项目
     *
     * @param ids 需要删除的非集客项目ID
     * @return 结果
     */
    public int deleteAppNgcByIds(String[] ids);

    /**
     * 删除非集客项目信息
     *
     * @param id 非集客项目ID
     * @return 结果
     */
    public int deleteAppNgcById(String id);

    /**
     * 校验项目名称是否唯一
     *
     * @param proName 项目名称
     * @return 结果
     */
    public int checkProNameUnique(String proName);

    /**
     * 逻辑删除非集客项目信息
     *
     * @param ids 非集客项目ID
     * @return 结果
     */
    public int updateAppNgcById(String[] ids);


    public String findNextAppNo(Integer falg);
}

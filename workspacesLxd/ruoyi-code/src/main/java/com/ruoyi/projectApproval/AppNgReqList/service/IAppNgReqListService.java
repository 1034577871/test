package com.ruoyi.projectApproval.AppNgReqList.service;

import java.util.List;

import com.ruoyi.projectApproval.AppNgReqList.domain.AppNgReqList;

/**
 * 成本子类Service接口
 *
 * @author Mu
 * @date 2020-12-18
 */
public interface IAppNgReqListService {
    /**
     * 查询成本子类
     *
     * @param id 成本子类ID
     * @return 成本子类
     */
    public AppNgReqList selectAppNgReqListById(String id);

    /**
     * 查询成本子类列表
     *
     * @param appNgReqList 成本子类
     * @return 成本子类集合
     */
    public List<AppNgReqList> selectAppNgReqListList(AppNgReqList appNgReqList);

    /**
     * 新增成本子类
     *
     * @param appNgReqList 成本子类
     * @return 结果
     */
    public int insertAppNgReqList(AppNgReqList appNgReqList);

    /**
     * 修改成本子类
     *
     * @param appNgReqList 成本子类
     * @return 结果
     */
    public int updateAppNgReqList(AppNgReqList appNgReqList);

    /**
     * 批量删除成本子类
     *
     * @param ids 需要删除的成本子类ID
     * @return 结果
     */
    public int deleteAppNgReqListByIds(String[] ids);

    /**
     * 删除成本子类信息
     *
     * @param id 成本子类ID
     * @return 结果
     */
    public int deleteAppNgReqListById(String id);
}

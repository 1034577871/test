package com.ruoyi.contract.contractContent.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.ruoyi.contract.contractContent.domain.CtBuContractContent;

/**
 * 合同内容Service接口
 *
 * @author ruoyi
 * @date 2020-12-09
 */
public interface ICtBuContractContentService {
    /**
     * 查询合同内容
     *
     * @param id 合同内容ID
     * @return 合同内容
     */
    public CtBuContractContent selectCtBuContractContentById(String id);

    /**
     * 查询合同内容列表
     *
     * @param ctBuContractContent 合同内容
     * @return 合同内容集合
     */
    public List<CtBuContractContent> selectCtBuContractContentList(CtBuContractContent ctBuContractContent);

    /**
     * 新增合同内容
     *
     * @param ctBuContractContent 合同内容
     * @return 结果
     */
    public int insertCtBuContractContent(CtBuContractContent ctBuContractContent);

    /**
     * 修改合同内容
     *
     * @param ctBuContractContent 合同内容
     * @return 结果
     */
    public int updateCtBuContractContent(CtBuContractContent ctBuContractContent);

    /**
     * 批量删除合同内容
     *
     * @param ids 需要删除的合同内容ID
     * @return 结果
     */
    public int deleteCtBuContractContentByIds(String[] ids);

    /**
     * 删除合同内容信息
     *
     * @param id 合同内容ID
     * @return 结果
     */
    public int deleteCtBuContractContentById(String id);

    /**
     * 批量逻辑删除合同内容
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int updateCtBuContractContentByIds(String[] ids);


}

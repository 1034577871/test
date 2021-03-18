package com.ruoyi.contract.contractIncomeType.mapper;

import java.util.List;
import com.ruoyi.contract.contractIncomeType.domain.CtBuContractIncomeType;

/**
 * 合同收入类型Mapper接口
 * 
 * @author ruoyi
 * @date 2021-02-22
 */
public interface CtBuContractIncomeTypeMapper 
{
    /**
     * 查询合同收入类型
     * 
     * @param id 合同收入类型ID
     * @return 合同收入类型
     */
    public CtBuContractIncomeType selectCtBuContractIncomeTypeById(String id);

    /**
     * 查询合同收入类型列表
     * 
     * @param ctBuContractIncomeType 合同收入类型
     * @return 合同收入类型集合
     */
    public List<CtBuContractIncomeType> selectCtBuContractIncomeTypeList(CtBuContractIncomeType ctBuContractIncomeType);

    /**
     * 新增合同收入类型
     * 
     * @param ctBuContractIncomeType 合同收入类型
     * @return 结果
     */
    public int insertCtBuContractIncomeType(CtBuContractIncomeType ctBuContractIncomeType);

    /**
     * 修改合同收入类型
     * 
     * @param ctBuContractIncomeType 合同收入类型
     * @return 结果
     */
    public int updateCtBuContractIncomeType(CtBuContractIncomeType ctBuContractIncomeType);

    /**
     * 删除合同收入类型
     * 
     * @param id 合同收入类型ID
     * @return 结果
     */
    public int deleteCtBuContractIncomeTypeById(String id);

    /**
     * 批量删除合同收入类型
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteCtBuContractIncomeTypeByIds(String[] ids);

    /**
     * 根据合同Id查询付款类型
     * @param contractId
     * @return
     */
    public List<CtBuContractIncomeType> selectCtBuContractIncomeTypeByContractIdList(String contractId);

    /**
     * 逻辑删除
     * @param id
     * @return
     */
    public int updateCtBuContractIncomeTypeById(String id);
}

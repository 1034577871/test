package com.ruoyi.contract.contractIncomeType.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.contract.contractIncomeType.mapper.CtBuContractIncomeTypeMapper;
import com.ruoyi.contract.contractIncomeType.domain.CtBuContractIncomeType;
import com.ruoyi.contract.contractIncomeType.service.ICtBuContractIncomeTypeService;

/**
 * 合同收入类型Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-02-22
 */
@Service
public class CtBuContractIncomeTypeServiceImpl implements ICtBuContractIncomeTypeService 
{
    @Autowired
    private CtBuContractIncomeTypeMapper ctBuContractIncomeTypeMapper;

    /**
     * 查询合同收入类型
     * 
     * @param id 合同收入类型ID
     * @return 合同收入类型
     */
    @Override
    public CtBuContractIncomeType selectCtBuContractIncomeTypeById(String id)
    {
        return ctBuContractIncomeTypeMapper.selectCtBuContractIncomeTypeById(id);
    }

    /**
     * 查询合同收入类型列表
     * 
     * @param ctBuContractIncomeType 合同收入类型
     * @return 合同收入类型
     */
    @Override
    public List<CtBuContractIncomeType> selectCtBuContractIncomeTypeList(CtBuContractIncomeType ctBuContractIncomeType)
    {
        return ctBuContractIncomeTypeMapper.selectCtBuContractIncomeTypeList(ctBuContractIncomeType);
    }

    /**
     * 新增合同收入类型
     * 
     * @param ctBuContractIncomeType 合同收入类型
     * @return 结果
     */
    @Override
    public int insertCtBuContractIncomeType(CtBuContractIncomeType ctBuContractIncomeType)
    {
        ctBuContractIncomeType.setCreateTime(DateUtils.getNowDate());
        return ctBuContractIncomeTypeMapper.insertCtBuContractIncomeType(ctBuContractIncomeType);
    }

    /**
     * 修改合同收入类型
     * 
     * @param ctBuContractIncomeType 合同收入类型
     * @return 结果
     */
    @Override
    public int updateCtBuContractIncomeType(CtBuContractIncomeType ctBuContractIncomeType)
    {
        ctBuContractIncomeType.setUpdateTime(DateUtils.getNowDate());
        return ctBuContractIncomeTypeMapper.updateCtBuContractIncomeType(ctBuContractIncomeType);
    }

    /**
     * 批量删除合同收入类型
     * 
     * @param ids 需要删除的合同收入类型ID
     * @return 结果
     */
    @Override
    public int deleteCtBuContractIncomeTypeByIds(String[] ids)
    {
        return ctBuContractIncomeTypeMapper.deleteCtBuContractIncomeTypeByIds(ids);
    }

    /**
     * 删除合同收入类型信息
     * 
     * @param id 合同收入类型ID
     * @return 结果
     */
    @Override
    public int deleteCtBuContractIncomeTypeById(String id)
    {
        return ctBuContractIncomeTypeMapper.deleteCtBuContractIncomeTypeById(id);
    }

    /**
     * 批量逻辑删除
     *
     * @param ids 需要删除
     * @return 结果
     */
    @Override
    public int updateCtBuContractIncomeTypeByIds(String[] ids) {
        if (ids != null && ids.length > 0) {
            for (int i = 0; i < ids.length; i++) {
                int i1 = ctBuContractIncomeTypeMapper.updateCtBuContractIncomeTypeById(ids[i]);
            }
        }
        return 1;
    }
}

package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.CtPdeptDeptMapper;
import com.ruoyi.system.domain.CtPdeptDept;
import com.ruoyi.system.service.ICtPdeptDeptService;

/**
 * 本部门-分公司部门对照Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-12-30
 */
@Service
public class CtPdeptDeptServiceImpl implements ICtPdeptDeptService 
{
    @Autowired
    private CtPdeptDeptMapper ctPdeptDeptMapper;

    /**
     * 查询本部门-分公司部门对照
     * 
     * @param id 本部门-分公司部门对照ID
     * @return 本部门-分公司部门对照
     */
    @Override
    public CtPdeptDept selectCtPdeptDeptById(String id)
    {
        return ctPdeptDeptMapper.selectCtPdeptDeptById(id);
    }

    /**
     * 查询本部门-分公司部门对照列表
     * 
     * @param ctPdeptDept 本部门-分公司部门对照
     * @return 本部门-分公司部门对照
     */
    @Override
    public List<CtPdeptDept> selectCtPdeptDeptList(CtPdeptDept ctPdeptDept)
    {
        return ctPdeptDeptMapper.selectCtPdeptDeptList(ctPdeptDept);
    }

    /**
     * 新增本部门-分公司部门对照
     * 
     * @param ctPdeptDept 本部门-分公司部门对照
     * @return 结果
     */
    @Override
    public int insertCtPdeptDept(CtPdeptDept ctPdeptDept)
    {
        return ctPdeptDeptMapper.insertCtPdeptDept(ctPdeptDept);
    }

    /**
     * 修改本部门-分公司部门对照
     * 
     * @param ctPdeptDept 本部门-分公司部门对照
     * @return 结果
     */
    @Override
    public int updateCtPdeptDept(CtPdeptDept ctPdeptDept)
    {
        return ctPdeptDeptMapper.updateCtPdeptDept(ctPdeptDept);
    }

    /**
     * 批量删除本部门-分公司部门对照
     * 
     * @param ids 需要删除的本部门-分公司部门对照ID
     * @return 结果
     */
    @Override
    public int deleteCtPdeptDeptByIds(String[] ids)
    {
        return ctPdeptDeptMapper.deleteCtPdeptDeptByIds(ids);
    }

    /**
     * 删除本部门-分公司部门对照信息
     * 
     * @param id 本部门-分公司部门对照ID
     * @return 结果
     */
    @Override
    public int deleteCtPdeptDeptById(String id)
    {
        return ctPdeptDeptMapper.deleteCtPdeptDeptById(id);
    }
}

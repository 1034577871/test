package com.ruoyi.projectApproval.AppNgCompany.service.impl;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.projectApproval.AppNgCompany.domain.CtBuApprovaldtNgCompany;
import com.ruoyi.projectApproval.AppNgCompany.mapper.CtBuApprovaldtNgCompanyMapper;
import com.ruoyi.projectApproval.AppNgCompany.service.ICtBuApprovaldtNgCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 事前审批明细(集客类-涉及分公司)Service业务层处理
 *
 * @author ruoyi
 * @date 2021-01-19
 */
@Service
public class CtBuApprovaldtNgCompanyServiceImpl implements ICtBuApprovaldtNgCompanyService {
    @Autowired
    private CtBuApprovaldtNgCompanyMapper ctBuApprovaldtNgCompanyMapper;

    /**
     * 查询事前审批明细(集客类-涉及分公司)
     *
     * @param id 事前审批明细(集客类-涉及分公司)ID
     * @return 事前审批明细(集客类 - 涉及分公司)
     */
    @Override
    public CtBuApprovaldtNgCompany selectCtBuApprovaldtNgCompanyById(String id) {
        return ctBuApprovaldtNgCompanyMapper.selectCtBuApprovaldtNgCompanyById(id);
    }

    /**
     * 查询事前审批明细(集客类-涉及分公司)列表
     *
     * @param ctBuApprovaldtNgCompany 事前审批明细(集客类-涉及分公司)
     * @return 事前审批明细(集客类 - 涉及分公司)
     */
    @Override
    public List<CtBuApprovaldtNgCompany> selectCtBuApprovaldtNgCompanyList(CtBuApprovaldtNgCompany ctBuApprovaldtNgCompany) {
        return ctBuApprovaldtNgCompanyMapper.selectCtBuApprovaldtNgCompanyList(ctBuApprovaldtNgCompany);
    }

    /**
     * 新增事前审批明细(集客类-涉及分公司)
     *
     * @param ctBuApprovaldtNgCompany 事前审批明细(集客类-涉及分公司)
     * @return 结果
     */
    @Override
    public int insertCtBuApprovaldtNgCompany(CtBuApprovaldtNgCompany ctBuApprovaldtNgCompany) {
        ctBuApprovaldtNgCompany.setCreateTime(DateUtils.getNowDate());
        return ctBuApprovaldtNgCompanyMapper.insertCtBuApprovaldtNgCompany(ctBuApprovaldtNgCompany);
    }

    /**
     * 修改事前审批明细(集客类-涉及分公司)
     *
     * @param ctBuApprovaldtNgCompany 事前审批明细(集客类-涉及分公司)
     * @return 结果
     */
    @Override
    public int updateCtBuApprovaldtNgCompany(CtBuApprovaldtNgCompany ctBuApprovaldtNgCompany) {
        ctBuApprovaldtNgCompany.setUpdateTime(DateUtils.getNowDate());
        return ctBuApprovaldtNgCompanyMapper.updateCtBuApprovaldtNgCompany(ctBuApprovaldtNgCompany);
    }

    /**
     * 批量删除事前审批明细(集客类-涉及分公司)
     *
     * @param ids 需要删除的事前审批明细(集客类-涉及分公司)ID
     * @return 结果
     */
    @Override
    public int deleteCtBuApprovaldtNgCompanyByIds(String[] ids) {
        return ctBuApprovaldtNgCompanyMapper.deleteCtBuApprovaldtNgCompanyByIds(ids);
    }

    /**
     * 删除事前审批明细(集客类-涉及分公司)信息
     *
     * @param id 事前审批明细(集客类-涉及分公司)ID
     * @return 结果
     */
    @Override
    public int deleteCtBuApprovaldtNgCompanyById(String id) {
        return ctBuApprovaldtNgCompanyMapper.deleteCtBuApprovaldtNgCompanyById(id);
    }
}

package com.ruoyi.contract.contractIncomeType.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 合同收入类型对象 ct_bu_contract_income_type
 * 
 * @author ruoyi
 * @date 2021-02-22
 */
public class CtBuContractIncomeType extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 唯一主键 */
    private String id;

    /** 合同ID */
    @Excel(name = "合同ID")
    private String contractId;

    /** 合同编号 */
    @Excel(name = "合同编号")
    private String contractNo;

    /** 合同名称 */
    @Excel(name = "合同名称")
    private String contractName;

    /** 收入类型ID */
    @Excel(name = "收入类型ID")
    private String incomeTypeId;

    /** 收入类型名称 */
    @Excel(name = "收入类型名称")
    private String incomeTypeName;

    /** 收入类型金额 */
    @Excel(name = "收入类型金额")
    private BigDecimal incomeTypeMoney;

    /**
     * 删除标记
     */
    private Integer delFlag;

    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
    }
    public void setContractId(String contractId) 
    {
        this.contractId = contractId;
    }

    public String getContractId() 
    {
        return contractId;
    }
    public void setContractNo(String contractNo) 
    {
        this.contractNo = contractNo;
    }

    public String getContractNo() 
    {
        return contractNo;
    }
    public void setContractName(String contractName) 
    {
        this.contractName = contractName;
    }

    public String getContractName() 
    {
        return contractName;
    }
    public void setIncomeTypeId(String incomeTypeId) 
    {
        this.incomeTypeId = incomeTypeId;
    }

    public String getIncomeTypeId() 
    {
        return incomeTypeId;
    }
    public void setIncomeTypeName(String incomeTypeName) 
    {
        this.incomeTypeName = incomeTypeName;
    }

    public String getIncomeTypeName() 
    {
        return incomeTypeName;
    }
    public void setIncomeTypeMoney(BigDecimal incomeTypeMoney) 
    {
        this.incomeTypeMoney = incomeTypeMoney;
    }

    public BigDecimal getIncomeTypeMoney() 
    {
        return incomeTypeMoney;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("contractId", getContractId())
            .append("contractNo", getContractNo())
            .append("contractName", getContractName())
            .append("incomeTypeId", getIncomeTypeId())
            .append("incomeTypeName", getIncomeTypeName())
            .append("incomeTypeMoney", getIncomeTypeMoney())
            .toString();
    }
}

package com.ruoyi.dictionary.taxrate.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 税率字典对象 ct_dic_taxrate
 * 
 * @author Mu
 * @date 2020-12-21
 */
public class dicTaxrate extends BaseEntity {

	private static final long serialVersionUID = 1L;

	/** 唯一ID */
	private String id;

	/** 税率名称 */
	@Excel(name = "税率名称")
	private String name;

	/** 税率% */
	@Excel(name = "税率%")
	private String taxrate;

	/** 删除标志 */
	private Integer delFlag;

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setTaxrate(String taxrate) {
		this.taxrate = taxrate;
	}

	public String getTaxrate() {
		return taxrate;
	}

	public void setDelFlag(Integer delFlag) {
		this.delFlag = delFlag;
	}

	public Integer getDelFlag() {
		return delFlag;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE).append("id", getId())
				.append("createBy", getCreateBy()).append("createTime", getCreateTime())
				.append("updateBy", getUpdateBy()).append("updateTime", getUpdateTime()).append("name", getName())
				.append("taxrate", getTaxrate()).append("delFlag", getDelFlag()).append("remark", getRemark())
				.toString();
	}
}

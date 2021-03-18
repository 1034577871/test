package com.ruoyi.dictionary.area.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.TreeEntity;

/**
 * 地区信息字典对象 sys_area
 * 
 * @author Mu
 * @date 2020-12-08
 */
public class SysArea extends TreeEntity {

	private static final long serialVersionUID = 1L;

	/** 唯一ID */
	private Integer id;

	/** 名称 */
	@Excel(name = "名称")
	private String cname;

	/** 类型 */
	@Excel(name = "类型")
	private Integer ctype;

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getCname() {
		return cname;
	}

	public void setCtype(Integer ctype) {
		this.ctype = ctype;
	}

	public Integer getCtype() {
		return ctype;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE).append("id", getId())
				.append("parentId", getParentId()).append("cname", getCname()).append("ctype", getCtype()).toString();
	}
}

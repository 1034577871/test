package com.ruoyi.dictionary.proType.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.TreeEntity;

/**
 * @Title: CtDicProtype.java
 * @Description: 项目类型
 * @Author M.Mu
 * @Date 2020-12-08
 */
public class CtDicProtype extends TreeEntity {

	private static final long serialVersionUID = 1L;

	/** 唯一ID */
	private String id;

	/** 类型名称 */
	@Excel(name = "类型名称")
	private String typeName;

	/** 父节点 */
	@Excel(name = "父节点")
	private String pid;

	/** 删除标志 */
	private Integer delFlag;

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getPid() {
		return pid;
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
				.append("updateBy", getUpdateBy()).append("updateTime", getUpdateTime())
				.append("typeName", getTypeName()).append("pid", getPid()).append("delFlag", getDelFlag())
				.append("remark", getRemark()).toString();
	}
}

package com.ruoyi.base.fileManage.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 文件管理对象 ct_bu_file
 * 
 * @author Mu
 * @date 2020-12-11
 */
public class CtBuFile extends BaseEntity {
	
	private static final long serialVersionUID = 1L;

	/** 唯一ID */
	private String id;

	/** 所属ID */
	private String pid;

	/** 文件类型 */
	@Excel(name = "文件类型")
	private Integer ptype;

	/** 文件地址 */
	@Excel(name = "文件地址")
	private String path;

	/** 是否删除 */
	private Integer delFlag;

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getPid() {
		return pid;
	}

	public void setPtype(Integer ptype) {
		this.ptype = ptype;
	}

	public Integer getPtype() {
		return ptype;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getPath() {
		return path;
	}

	public void setDelFlag(Integer delFlag) {
		this.delFlag = delFlag;
	}

	public Integer getDelFlag() {
		return delFlag;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE).append("id", getId()).append("pid", getPid())
				.append("ptype", getPtype()).append("path", getPath()).append("createTime", getCreateTime())
				.append("createBy", getCreateBy()).append("delFlag", getDelFlag()).toString();
	}
}

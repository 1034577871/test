package com.ruoyi.dictionary.company.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * @Title: CtDicCompany.java
 * @Description: 企业信息对象
 * @Author M.Mu
 * @Date 2020-12-07
 */
@JsonIgnoreProperties({"hibernateLazyInitializer" ,"handler" })
public class CtDicCompany extends BaseEntity {

	private static final long serialVersionUID = 1L;

	/** 主键 */
	private String id;

	/** 统一社会信用代码 */
	@Excel(name = "统一社会信用代码")
	private String creditCode;

	/** 企业名称 */
	@Excel(name = "企业名称")
	private String companyName;

	/** 所属省份编号 */
//	@Excel(name = "所属省份编号")
	private String provinceId;

	/** 所属省份名称 */
//	@Excel(name = "所属省份名称")
	private String provinceName;

	/** 所属地市编号 */
//	@Excel(name = "所属地市编号")
	private String cityId;

	/** 所属地市名称 */
//	@Excel(name = "所属地市名称")
	private String cityName;

	/** 存储地区 **/
	private String[] provinceNameS;

	/** 地址 */
	@Excel(name = "地址")
	private String address;

	/** 联系人 */
	@Excel(name = "联系人")
	private String linkMan;

	/** 联系方式 */
	@Excel(name = "联系方式")
	private String linkPhone;

	/** 开户行 */
	@Excel(name = "开户行")
	private String openingBank;

	/** 开户账号 */
	@Excel(name = "开户账号")
	private String openingAccount;

	/** 企业类型1:甲方 2:乙方 */
	@Excel(name = "企业类型1:甲方 2:乙方")
	private String companyType;

	/** 删除标志 1未删除 2已删除 */
	private Integer delFlag;

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setCreditCode(String creditCode) {
		this.creditCode = creditCode;
	}

	public String getCreditCode() {
		return creditCode;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddress() {
		return address;
	}

	public void setLinkMan(String linkMan) {
		this.linkMan = linkMan;
	}

	public String getLinkMan() {
		return linkMan;
	}

	public void setLinkPhone(String linkPhone) {
		this.linkPhone = linkPhone;
	}

	public String getLinkPhone() {
		return linkPhone;
	}

	public void setOpeningBank(String openingBank) {
		this.openingBank = openingBank;
	}

	public String getOpeningBank() {
		return openingBank;
	}

	public void setOpeningAccount(String openingAccount) {
		this.openingAccount = openingAccount;
	}

	public String getOpeningAccount() {
		return openingAccount;
	}

	public void setCompanyType(String companyType) {
		this.companyType = companyType;
	}

	public String getCompanyType() {
		return companyType;
	}

	public void setDelFlag(Integer delFlag) {
		this.delFlag = delFlag;
	}

	public Integer getDelFlag() {
		return delFlag;
	}

	public String getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(String provinceId) {
		this.provinceId = provinceId;
	}

	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	public String getCityId() {
		return cityId;
	}

	public void setCityId(String cityId) {
		this.cityId = cityId;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String[] getProvinceNameS() {
		return provinceNameS;
	}

	public void setProvinceNameS(String[] provinceNameS) {
		this.provinceNameS = provinceNameS;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
				.append("id", getId())
				.append("createBy", getCreateBy())
				.append("createTime", getCreateTime())
				.append("updateBy", getUpdateBy())
				.append("updateTime", getUpdateTime())
				.append("creditCode", getCreditCode())
				.append("companyName", getCompanyName())
				.append("provinceId", getProvinceId())
				.append("provinceName", getProvinceName())
				.append("cityId", getCityId())
				.append("cityName", getCityName())
				.append("address", getAddress())
				.append("linkMan", getLinkMan())
				.append("linkPhone", getLinkPhone())
				.append("openingBank", getOpeningBank())
				.append("openingAccount", getOpeningAccount())
				.append("companyType", getCompanyType())
				.append("delFlag", getDelFlag())
				.append("remark", getRemark())
				.toString();
	}
}
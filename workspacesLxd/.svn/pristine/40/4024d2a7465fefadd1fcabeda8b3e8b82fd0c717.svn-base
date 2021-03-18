package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 本部门-分公司部门对照对象 ct_pdept_dept
 * 
 * @author ruoyi
 * @date 2020-12-30
 */
public class CtPdeptDept extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    private String fgld;

    public String getFgld() {
        return fgld;
    }

    public void setFgld(String fgld) {
        this.fgld = fgld;
    }

    public String getFgldid() {
        return fgldid;
    }

    public void setFgldid(String fgldid) {
        this.fgldid = fgldid;
    }

    private String fgldid;

    /** 主键 */
    private String id;

    /** 本部名称 */
    @Excel(name = "本部名称")
    private String pname;

    /** 分公司部门名称 */
    @Excel(name = "分公司部门名称")
    private String name;

    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
    }
    public void setPname(String pname) 
    {
        this.pname = pname;
    }

    public String getPname() 
    {
        return pname;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("pname", getPname())
            .append("name", getName())
            .toString();
    }
}

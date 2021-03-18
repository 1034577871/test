package com.ruoyi.activiti.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PublicMapper {


    /**
     * 指定表的指定字段更新为指定值, 根据指定列的指定值
     * <p>
     * 参数：表名、列名、列值、条件列名、条件列值
     */
    public int updateColumnBy(
            @Param("tableName") String tableName,
            @Param("columnName") String columnName,
            @Param("columnValue") Object columnValue,
            @Param("whereName") String whereName,
            @Param("whereValue") Object whereValue
    );
}

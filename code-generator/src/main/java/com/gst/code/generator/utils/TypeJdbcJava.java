package com.gst.code.generator.utils;

import java.util.Map;

public class TypeJdbcJava {

    private static Map<String,String> map;

    static {
        map.put("varchar2", "String");
        map.put("varchar", "String");
        map.put("int", "Integer");
        map.put("datetime", "Date");
        map.put("date", "Date");
        map.put("timestamp", "Date");
        map.put("nvarchar", "String");
        map.put("char", "String");
        map.put("uniqueidentifier", "String");
        map.put("number", "BigDecimal");
        map.put("decimal", "BigDecimal");
        map.put("bigint", "Long");
        map.put("tinyint", "Integer");
        map.put("blob", "Blob");
        map.put("clob", "String");
        map.put("text", "String");
    }

    public static String getJavaType(String jdbcType){
        return map.get(jdbcType);
    }
}

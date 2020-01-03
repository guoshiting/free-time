package com.gst.boot.shiro.utils;

import com.google.common.base.CaseFormat;
import com.google.common.base.Converter;

public class StringUtils {
    // 驼峰转下划线, userName -> user_name
    private static Converter<String, String> HUMP_TO_LINE = CaseFormat.LOWER_CAMEL.converterTo(CaseFormat.LOWER_UNDERSCORE);
    // 驼峰转连接符, userName -> user-name
    private static Converter<String, String> HUMP_TO_HYPHEN = CaseFormat.LOWER_CAMEL.converterTo(CaseFormat.LOWER_HYPHEN);
    // 驼峰转首字符大写驼峰, userName -> UserName
    private static Converter<String, String> FIRST_UPPER = CaseFormat.LOWER_CAMEL.converterTo(CaseFormat.UPPER_CAMEL);
    // 驼峰转大写下划线, userName -> USER_NAME
    private static Converter<String, String> HUMP_TO_LINE_ALL_UPPER = CaseFormat.LOWER_CAMEL.converterTo(CaseFormat.UPPER_UNDERSCORE);
    // 下划线转驼峰, user_name-> userName
    private static Converter<String, String> LINE_TO_HUMP = CaseFormat.LOWER_UNDERSCORE.converterTo(CaseFormat.UPPER_CAMEL);
    // 下划线转下划线, user_name -> UserName
    private static Converter<String, String> LINE_TO_HUMP_FIRST_UPPER = CaseFormat.UPPER_UNDERSCORE.converterTo(CaseFormat.UPPER_CAMEL);

    /**
     * 驼峰转下划线, userName -> user_name
     * @param str
     * @return
     */
    public static String humpToLine(String str){
        return HUMP_TO_LINE.convert(str);
    }
    /**
     * 驼峰转连接符, userName -> user-name
     * @param str
     * @return
     */
    public static String humpToHyphen(String str){
        return HUMP_TO_HYPHEN.convert(str);
    }
    /**
     * 驼峰转首字符大写驼峰, userName -> UserName
     * @param str
     * @return
     */
    public static String firstUpper(String str){
        return FIRST_UPPER.convert(str);
    }
    /**
     * 驼峰转大写下划线, userName -> USER_NAME
     * @param str
     * @return
     */
    public static String humpToLineAllUpper(String str){
        return HUMP_TO_LINE_ALL_UPPER.convert(str);
    }
    /**
     * 下划线转驼峰, user_name-> userName
     * @param str
     * @return
     */
    public static String lineToHump(String str){
        return LINE_TO_HUMP.convert(str);
    }
    /**
     * 下划线转下划线, user_name -> UserName
     * @param str
     * @return
     */
    public static String lineToHumpFirstUpper(String str){
        return LINE_TO_HUMP_FIRST_UPPER.convert(str);
    }

    public static boolean isNotBlank(String str) {
        return org.apache.commons.lang3.StringUtils.isNotBlank(str);
    }
}

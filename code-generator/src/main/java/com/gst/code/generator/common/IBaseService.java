package com.gst.code.generator.common;

import java.util.Map;

/**
 * 公共接口
 * @param <T> 实体类
 * @param <V> 主键类型
 */
public interface IBaseService<T,V> {

    /**
     * 保存
     * @return
     */
    Message save(T t);

    /**
     * 通过主键id修改
     * @param t
     * @return
     */
    Message modifyById(T t);

    /**
     * 通过主键id删除
     * @param id
     * @return
     */
    Message removeById(V id);

    /**
     * 通过主键id查询
     * @param id
     * @return
     */
    Message queryById(V id);

    /**
     * 分页查询
     * @param limit
     * @param offset
     * @param params
     * @return
     */
    Message page(String limit, String offset, Map<String,Object> params,Class<T> clazz);

    /**
     * 分页查询
     * @param limit
     * @param offset
     * @param params
     * @return
     */
    Message pageTime(String limit, String offset, Map<String,Object> params,Class<T> clazz,Map<String,String> timeMap);
}

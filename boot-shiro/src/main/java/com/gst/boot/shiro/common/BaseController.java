package com.gst.boot.shiro.common;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 *
 * @param <T> 实体类
 * @param <V> 主键类型
 */
public abstract class BaseController<T,V> {

    private static final Logger LOGGER = LoggerFactory.getLogger(BaseController.class);

    public IBaseService service;
    private Class<T> clazz;

    public abstract void setService(IBaseService service);

    @ApiOperation(value = "分页查询",notes = "分页查询")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "query",name = "pageSize",value = "每页大小",required = false),
            @ApiImplicitParam(paramType = "query",name = "pageNum",value = "起始页数,从1开始",required = false),
            @ApiImplicitParam(paramType = "query", name = "params", dataType = "Map", value = "查询条件", required = false)})
    @GetMapping("/page")
    public Message page(@RequestParam(value = "pageSize", required = false) String pageSize,
                        @RequestParam(value = "pageNum", required = false) String pageNum,
                        @RequestParam Map<String, Object> params){
        LOGGER.info("分页查询的方法执行,参数pageSize=>{},pageNum=>{},params=>{}",pageSize,pageNum,params);
        Message message = null;
        try {
            message = service.page(pageSize,pageNum,params,clazz);
        } catch (Exception e) {
            LOGGER.error("分页查询异常",e);
            message = Message.failure(BaseCode.FAILED,"系统异常,请稍后再试");
        }
        return message;
    }

    @ApiOperation(value = "查询接口", notes = "查询接口")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "query", name = "id", value = "主键id", required = false)})
    @GetMapping
    public Message queryById(V id){
        LOGGER.info("查询方法开始执行,参数id->{}",id);
        Message message = null;
        try {
            message = service.queryById(id);
        } catch (Exception e) {
            LOGGER.error("查询异常",e);
            message = Message.failure(BaseCode.FAILED,"系统异常,请稍后再试");
        }
        return message;
    }

    @ApiOperation(value = "保存接口", notes = "保存接口")
    @PostMapping
    public Message save(T t) {
        LOGGER.info("保存方法开始执行,参数t->{}",t);
        Message message = null;
        try {
            message = service.save(t);
        } catch (Exception e) {
            LOGGER.error("保存异常",e);
            message = Message.failure(BaseCode.FAILED,"系统异常,请稍后再试");
        }
        return message;
    }

    @ApiOperation(value = "删除接口",notes = "删除接口")
    @DeleteMapping("/{id}")
    public Message removeById(@PathVariable("id")V id){
        LOGGER.info("删除方法开始执行,参数id->{}",id);
        Message message = null;
        try {
            message = service.removeById(id);
        } catch (Exception e) {
            LOGGER.error("删除方法异常",e);
            message = Message.failure(BaseCode.FAILED,"系统异常,请稍后再试");
        }
        return message;
    }

    @ApiOperation(value = "修改接口",notes = "修改接口")
    @PutMapping
    public Message modifyById(T t){
        LOGGER.info("修改方法开始执行,参数t->{}",t);
        Message message = null;
        try {
            message = service.modifyById(t);
        } catch (Exception e) {
            LOGGER.error("修改异常",e);
            message = Message.failure(BaseCode.FAILED,"系统异常,请稍后再试");
        }
        return message;
    }

}

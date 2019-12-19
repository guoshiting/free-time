package com.gst.code.generator.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "swagger集成测试")
public class SwaggerController {

    private final static Logger logger = LoggerFactory.getLogger(SwaggerController.class);

    @ApiOperation(value = "swagger集成测试接口", notes = "swagger集成测试接口")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "query", name = "limit", value = "每页记录数,从1开始", required = false),})
    @GetMapping("/swaggerTest")
    public Object swaggerTest(String limit){
        logger.info("测试方法开始执行,参数limit=>{}",limit);
        return "666";
    }
}

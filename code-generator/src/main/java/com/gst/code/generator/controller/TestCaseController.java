package com.gst.code.generator.controller;

import com.gst.code.generator.common.BaseController;
import com.gst.code.generator.common.BaseMapper;
import com.gst.code.generator.common.IBaseService;
import com.gst.code.generator.entity.TestCase;
import com.gst.code.generator.service.ITestCaseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.Service;

@RequestMapping("testCase")
@Api(tags = "单标测试")
@RestController
public class TestCaseController extends BaseController<TestCase,String> {

    private static final Logger LOGGER = LoggerFactory.getLogger(TestCaseController.class);

    @Autowired
    private ITestCaseService testCaseService;

    @Override
    @Autowired
    public void setService(IBaseService testCaseService) {
        this.service = testCaseService;
    }
}

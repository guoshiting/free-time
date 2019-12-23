package com.gst.code.generator.service.impl;

import com.gst.code.generator.common.BaseServiceImpl;
import com.gst.code.generator.dao.TestCaseMapper;
import com.gst.code.generator.entity.TestCase;
import com.gst.code.generator.service.ITestCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestCaseServiceImpl extends BaseServiceImpl<TestCase, String> implements ITestCaseService {

    @Autowired
    private TestCaseMapper testCaseMapper;

    @Override
    @Autowired
    public void setMapper() {
        mapper = testCaseMapper;
    }
}

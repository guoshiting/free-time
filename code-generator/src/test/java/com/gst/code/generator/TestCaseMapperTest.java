package com.gst.code.generator;

import com.gst.code.generator.dao.TestCaseMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;

@SpringBootTest
public class TestCaseMapperTest {

    @Autowired
    private TestCaseMapper mapper;

    @Test
    public void testSelect(){
        System.out.println(mapper.selectAll());
    }
}

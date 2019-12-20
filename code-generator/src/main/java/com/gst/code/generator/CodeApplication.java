package com.gst.code.generator;

import com.gst.code.generator.common.BaseMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@SpringBootApplication
@ComponentScan(excludeFilters = {@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {BaseMapper.class})})
public class CodeApplication {

    public static void main(String[] args) {
        SpringApplication.run(CodeApplication.class,args);
    }
}

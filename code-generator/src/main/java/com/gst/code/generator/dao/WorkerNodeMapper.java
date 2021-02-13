package com.gst.code.generator.dao;

import com.gst.code.generator.common.BaseMapper;
import com.gst.code.generator.entity.TestCase;
import com.gst.code.generator.entity.WorkerNode;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface WorkerNodeMapper extends BaseMapper<WorkerNode> {
}
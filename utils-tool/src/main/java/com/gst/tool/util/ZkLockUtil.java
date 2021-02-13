package com.gst.tool.util;

import com.gst.tool.lock.ZookeeperClient;
import lombok.Getter;
import lombok.Setter;
import org.apache.curator.framework.CuratorFramework;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ZkLockUtil {

    private static final Logger logger = LoggerFactory.getLogger(ZkLockUtil.class);

    @Setter
    @Getter
    private static ZookeeperClient zookeeperClient;


}

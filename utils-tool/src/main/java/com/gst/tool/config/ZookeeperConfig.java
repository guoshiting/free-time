package com.gst.tool.config;

import com.gst.tool.lock.ZookeeperClient;
import com.gst.tool.util.ZkLockUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ZookeeperConfig {

    @Value("${zookeeper.server}")
    private String zookeeperServer;
    @Value("${zookeeper.lockPath}")
    private String zookeeperLockPath;

    @Bean(initMethod = "init" , destroyMethod = "destroy")
    public ZookeeperClient zookeeperClient() {
        ZookeeperClient zookeeperClient = new ZookeeperClient(zookeeperServer, zookeeperLockPath);
        ZkLockUtil.setZookeeperClient(zookeeperClient);
        return zookeeperClient;
    }
}

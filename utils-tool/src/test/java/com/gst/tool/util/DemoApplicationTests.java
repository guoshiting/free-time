package com.gst.tool.util;

import com.gst.tool.lock.ZookeeperClient;
import com.gst.tool.test.TestLock;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    private ZookeeperClient zookeeperClient;

    @Test
    public void test1() {
        String lockId = "123";
        String result = zookeeperClient.lock(new TestLock<String>(lockId) {
            @Override
            public String execute() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return this.getLockId();
            }
        });

        if (result == null) {
            System.out.println("执行失败");
        } else {
            System.out.println("执行成功");
        }
    }
}

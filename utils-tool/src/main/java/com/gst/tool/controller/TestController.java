package com.gst.tool.controller;

import com.gst.tool.lock.ZookeeperClient;
import com.gst.tool.test.TestLock;
import com.gst.tool.util.RedissLockUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sound.midi.Soundbank;
import java.util.concurrent.TimeUnit;

@RestController
public class TestController {

    @Autowired
    private ZookeeperClient zookeeperClient;

    @GetMapping("zk")
    public String zkLock(){
        String result = zookeeperClient.lock(new TestLock<String>("lockId") {
            @Override
            public String execute() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return this.getLockId();
            }
        });
        if (result == null) {
            System.out.println("执行失败");
            return "执行失败";
        } else {
            System.out.println("执行成功");
            return "执行成功";
        }
    }

    @RequestMapping("trylock")
    public Object tryLock(){
        RedissLockUtil.lock("testkey",10);
        return "666";
    }

    @RequestMapping("trylock1")
    public Object tryLock1(String str){
        if(RedissLockUtil.tryLock("testkey", TimeUnit.SECONDS, 1, 10)){
            if("r".equals(str)){
                RedissLockUtil.unlock("testkey");
            }
            return "666";
        }else{
            return "777";
        }

    }
}

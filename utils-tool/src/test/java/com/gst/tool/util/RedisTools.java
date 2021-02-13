package com.gst.tool.util;

import org.springframework.boot.test.context.SpringBootTest;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisSentinelPool;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@SpringBootTest
public class RedisTools {

    public static void main(String[] args) {
        //连接池配置
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(10);
        jedisPoolConfig.setMaxIdle(5);
        jedisPoolConfig.setMinIdle(5);
        jedisPoolConfig.setMaxWaitMillis(6000);
        //哨兵信息
        Set<String> sentinels = new HashSet<String>(Arrays.asList(
                "192.168.32.130:26379",
                "192.168.32.130:26380",
                "192.168.32.130:26381"
        ));
        //创建连接池
        //mymaster是我们配置给哨兵的服务名称
        //sentinels是哨兵信息
        //jedisPoolConfig是连接池配置
        //abcdefg是连接Redis服务器的密码
        JedisSentinelPool pool = new JedisSentinelPool("mymaster", sentinels, jedisPoolConfig, "123456");
        //获取客户端
        Jedis jedis = pool.getResource();
        //执行两个命令
//        jedis.set("mykey", "myvalue");
//        String myvalue = jedis.get("mykey");
//        //打印信息
//        System.out.println(myvalue);
        jedis.set("mykey", "world3");
        String value = jedis.get("mykey");
        System.out.println("mykey" + ' ' + value);
    }
}

package com.gst.tool.util;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisUtilTest {

    @Test
    public void expire() {
    }

    @Test
    public void getExpire() {
    }

    @Test
    public void hasKey() {
    }

    @Test
    public void del() {
    }

    @Test
    public void get() {
        System.out.println(RedisUtil.get("mykey"));
    }

    @Test
    public void set() {
    }

    @Test
    public void testSet() {
    }

    @Test
    public void incr() {
        System.out.println(RedisUtil.incr("test2",1));
    }

    @Test
    public void decr() {
    }

    @Test
    public void hget() {
    }

    @Test
    public void hmget() {
    }

    @Test
    public void hmset() {
    }

    @Test
    public void testHmset() {
    }

    @Test
    public void hset() {
    }

    @Test
    public void testHset() {
    }

    @Test
    public void hdel() {
    }

    @Test
    public void hHasKey() {
    }

    @Test
    public void hincr() {
    }

    @Test
    public void hdecr() {
    }

    @Test
    public void sGet() {
    }

    @Test
    public void sHasKey() {
    }

    @Test
    public void sSet() {
    }

    @Test
    public void sSetAndTime() {
    }

    @Test
    public void sGetSetSize() {
    }

    @Test
    public void setRemove() {
    }

    @Test
    public void lGet() {
    }

    @Test
    public void lGetListSize() {
    }

    @Test
    public void lGetIndex() {
    }

    @Test
    public void lSet() {
    }

    @Test
    public void testLSet() {
    }

    @Test
    public void testLSet1() {
    }

    @Test
    public void testLSet2() {
    }

    @Test
    public void lUpdateIndex() {
    }

    @Test
    public void lRemove() {
    }

    @Test
    public void keys() {
    }

    @Test
    public void convertAndSend() {
    }

    @Test
    public void addToListRight() {
    }

    @Test
    public void rangeList() {
    }

    @Test
    public void rifhtPop() {
    }

    public static void main(String[] args) {
        System.out.println(4>>1);
    }
}
package com.gst.tool.util;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class RedissLockUtilTest {

    @Test
    public void setLocker() {
    }

    @Test
    public void lock() {
    }

    @Test
    public void unlock() {
    }

    @Test
    public void testUnlock() {
    }

    @Test
    public void testLock() {
    }

    @Test
    public void testLock1() {
    }

    @Test
    public void tryLock() {
        System.out.println(RedissLockUtil.tryLock("testkey", TimeUnit.SECONDS, 2, 10));
        System.out.println(RedissLockUtil.tryLock("testkey", TimeUnit.SECONDS, 2, 10));
        RedissLockUtil.unlock("testkey");
        System.out.println(RedissLockUtil.tryLock("testkey", TimeUnit.SECONDS, 2, 10));
    }

    @Test
    public void testTryLock() {
    }
}
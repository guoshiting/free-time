package com.gst.tool.test;

import com.gst.tool.lock.AbstractZookeeperLock;
import lombok.Getter;

public abstract class TestLock<String> extends AbstractZookeeperLock<String> {

    private static final java.lang.String LOCK_PATH = "test_";

    @Getter
    private String lockId;

    public TestLock(String lockId) {
        this.lockId = lockId;
    }

    @Override
    public java.lang.String getLockPath() {
        return LOCK_PATH + this.lockId;
    }
}

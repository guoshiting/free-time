package com.gst.tool.lock;

import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.TimeUnit;

public interface DistributedLocker {

    public RLock lock(String lockKey);

    public RLock lock(String lockKey, int timeout) ;

    public RLock lock(String lockKey, TimeUnit unit, int timeout);

    public boolean tryLock(String lockKey, TimeUnit unit, int waitTime, int leaseTime);

    public void unlock(String lockKey);

    public void unlock(RLock lock);
}

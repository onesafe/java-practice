package com._onesafe.zk.curator;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.curator.utils.CloseableUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Created by onesafe on 11/01/2019.
 */
public class DistLock {

    private static final String rootPath = "distLock";

    private static final int DEFAULT_CONNECT_TIMEOUT = 2000;

    private static final int DEFAULT_SESSION_TIMEOUT = 2000;

    private static final int DEFAULT_LOCK_TIMEOUT = 120;

    private String connectionString;

    private int connectionTimeout;

    private int sessionTimeout;

    private CuratorFramework client;

    private Map<String, InterProcessMutex> locks;

    public DistLock() {
        this.connectionString = System.getenv("ZookeeperCluster") != null ? System.getenv("ZookeeperCluster") : "172.27.132.65:2181";
        this.connectionTimeout = System.getenv("CONNECTION_TIMEOUT") != null ? Integer.valueOf(System.getenv("CONNECTION_TIMEOUT")) : DEFAULT_CONNECT_TIMEOUT;
        this.sessionTimeout = System.getenv("SESSION_TIMEOUT") != null ? Integer.valueOf(System.getenv("SESSION_TIMEOUT")) : DEFAULT_SESSION_TIMEOUT;

        this.client = CuratorFrameworkFactory.builder().connectString(connectionString)
                .retryPolicy(new ExponentialBackoffRetry(1000, 3))
                .connectionTimeoutMs(this.connectionTimeout)
                .sessionTimeoutMs(this.sessionTimeout)
                .namespace(rootPath)
                .build();

        this.client.start();
        locks = new HashMap<>(32);
    }

    public CuratorFramework getClient() {
        return client;
    }

    public boolean lock(String action, String lockId, int time) throws Exception {
        String uniqueLockId = action + "_" + lockId;

        InterProcessMutex lock = new InterProcessMutex(this.client, "/" + uniqueLockId);
        boolean isLocked = lock.acquire(time, TimeUnit.HOURS);
        System.out.println(Thread.currentThread().getName() + " is  locked, isLocked = " + isLocked);
        if (isLocked) {
            this.locks.put(uniqueLockId, lock);
        }
        return isLocked;
    }

    public boolean lock(String action, String lockId) throws Exception {
        return lock(action, lockId, DEFAULT_LOCK_TIMEOUT);
    }

    public void unlock(String action, String lockId) throws Exception {
        String uniqueLockId = action + "_" + lockId;
        InterProcessMutex lock = null;

        if ((lock = this.locks.get(uniqueLockId)) != null) {
            this.locks.remove(uniqueLockId);
            lock.release();
        }
        System.out.println(Thread.currentThread().getName() + " is release lock");
    }

    public void close() {
        CloseableUtils.closeQuietly(this.client);
    }
}

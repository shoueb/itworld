package com.shoueb.itworld.common.redistranlock;

import redis.clients.jedis.Jedis;

import java.util.Collections;

/**
 * @Description: 居于Redis做分布式锁
 * @Author: yuangui.hu
 * @Date: 2019/3/14 16:07
 */
public class RedisLockUtils {
    private static final String SET_IF_NOT_EXIST = "NX";
    private static final String SET_WITH_EXPIRE_TIME = "PX";
    private static final String LOCK_SUCCESS = "OK";
    private static final Long RELEASE_SUCCESS = 1L;

    /**
     * 获取锁
     * @param expireTime ms
     */
    public static boolean tryLock(Jedis jedis, String lockName, String resourcePath, int expireTime) {
        String result = jedis.set(lockName, resourcePath, SET_IF_NOT_EXIST, SET_WITH_EXPIRE_TIME, expireTime);
        if (LOCK_SUCCESS.equals(result)) {
            return true;
        }
        return false;
    }

    /**
     * 释放锁
     * @param jedis
     * @param lockName
     * @param resourcePath
     * @return
     */
    public static boolean release(Jedis jedis, String lockName, String resourcePath) {
        String script = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";
        Object result = jedis.eval(script, Collections.singletonList(lockName), Collections.singletonList(resourcePath));
        if (RELEASE_SUCCESS.equals(result)) {
            return true;
        }
        return false;
    }
}
//package com.shoueb.itworld.member;
//
//import com.shoueb.itworld.common.redistranlock.DistributedLock;
//import com.shoueb.itworld.common.redistranlock.RedisLockService;
//import com.shoueb.itworld.common.redistranlock.RedisLockUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import redis.clients.jedis.Jedis;
//import redis.clients.jedis.JedisPool;
//
///**
// * @Description:
// * @Author: yuangui.hu
// * @Date: 2019/3/14 13:12
// */
//@RestController("/")
//public class RedisDistributedTranController {
//    @Autowired
//    private RedisLockService redisLockService;
//    @Autowired
//    private JedisPool jedisPool;
//
//    private static final String LOCK_NAME = "LOCK_ID";
//    private static final String PATH = "TEST_UUID/TEST";
//    /**
//     *
//     * @return
//     */
//    @RequestMapping("tran_lock")
//    public String lock(){
////        return redisLockService.lock("hello");
//        Jedis jedis = jedisPool.getResource();
//        boolean lockStatus = RedisLockUtils.tryLock(jedis, LOCK_NAME, PATH, 100000);
//        if (lockStatus) {
//            System.out.println("拿到锁了");
//            // debugger
//            RedisLockUtils.release(jedis, LOCK_NAME, PATH);
//        } else {
//            System.out.println("没有拿到锁");
//        }
//        return "";
//    }
//
//    @RequestMapping("tran_unlock")
//    public String unlock(){
////        return redisLockService.releaseLock("ddd");
////        RedisDistributedLock.unlock()
////        return  redisDistributedLock.releaseLock("hello","123")?"1":"0";
//        return "0";
//    }
//    @RequestMapping("oklock")
//    public String oklock(){
//        return redisLockService.releaseLock("hello","c65d1da3-e090-4620-bca2-1d05ebd7883f")?"1":"0";
//        //return  redisDistributedLock.releaseLock("hello","223")?"1":"0";
////        return distributedLock.releaseLock("hello");
////        return "1";
//    }
//}

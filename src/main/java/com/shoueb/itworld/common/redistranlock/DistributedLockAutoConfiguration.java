package com.shoueb.itworld.common.redistranlock;

/**
 * @Description:
 * @Author: yuangui.hu
 * @Date: 2019/3/14 14:25
 */
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;


/**
 * @author fuwei.deng
 * @date 2017年6月14日 下午3:11:31
 * @version 1.0.0
 */
@Configuration
@AutoConfigureAfter(RedisAutoConfiguration.class)
public class DistributedLockAutoConfiguration {

    @Bean
    @ConditionalOnBean(RedisTemplate.class)
    public DistributedLock redisDistributedLock(RedisTemplate<Object, Object> redisTemplate){
        return new RedisDistributedLock(redisTemplate);
    }

}
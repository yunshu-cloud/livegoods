package com.livegoods.detail.config;

import com.livegoods.cache.config.RedisCacheConfiguration;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;

@Configuration
public class DetailsConfiguration extends RedisCacheConfiguration {

    /**
     * 创建缓存管理器。
     * @param redisConnectionFactory Redis连接工厂
     * @return
     */
    @Bean
    public CacheManager cacheManager(RedisConnectionFactory redisConnectionFactory){
        return super.cacheManager(redisConnectionFactory);
    }
}

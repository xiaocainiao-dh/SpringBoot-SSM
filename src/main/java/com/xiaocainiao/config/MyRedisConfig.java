package com.xiaocainiao.config;

import com.xiaocainiao.model.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

@Configuration
public class MyRedisConfig {

    @Bean
    public RedisTemplate<Object, User> userRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<Object, User> template = new RedisTemplate<Object, User>();
        template.setConnectionFactory(redisConnectionFactory);
        Jackson2JsonRedisSerializer<User> ser = new Jackson2JsonRedisSerializer<User>(User.class);
        template.setDefaultSerializer(ser);
        return template;
    }

    @Bean
    public RedisCacheManager userCacheManager(RedisTemplate<Object, Object> userRedisTemplate) {
        RedisCacheManager cacheManager = new RedisCacheManager(userRedisTemplate);
        cacheManager.setUsePrefix(true);
        return cacheManager;
    }
}

package xyz.zerotone.demo.infrastructure.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

/**
 * 缓存操作工具率
 */
@Service("redisUtil")
public class RedisUtil {
    @Autowired
    private StringRedisTemplate redisTemplate;

    public void set(String key, String value) {
        redisTemplate.opsForValue().set(key, value);
    }

    public String get(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    public void delete(String key) {
        redisTemplate.delete(key);
    }
}

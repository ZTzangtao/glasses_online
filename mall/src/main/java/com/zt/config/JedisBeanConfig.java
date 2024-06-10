package com.zt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @Author Tommy
 * @Date 2024/6/10 14:22
 * @Version 1.0
 */
@Configuration
public class JedisBeanConfig {

    @Bean
    public Jedis jedis() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(5);
        jedisPoolConfig.setMaxTotal(5);
        JedisPool jedisPool = new JedisPool(jedisPoolConfig, "localhost", 6379);
        Jedis jedis = jedisPool.getResource();
        return jedis;
    }

}

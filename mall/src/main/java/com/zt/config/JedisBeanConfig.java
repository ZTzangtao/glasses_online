package com.zt.config;

import org.springframework.beans.factory.annotation.Value;
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

    @Value("${redis.host}")
    private String host;

    @Value("${redis.port}")
    private Integer port;

    @Value("${redis.maxTotal}")
    private Integer maxTotal;

    @Value("${redis.maxIdle}")
    private Integer maxIdle;

    @Value("${redis.testOnBorrow}")
    private Boolean testOnBorrow;



    @Bean
    public Jedis jedis() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(maxIdle);
        jedisPoolConfig.setTestOnBorrow(testOnBorrow);
        jedisPoolConfig.setMaxTotal(maxTotal);
        JedisPool jedisPool = new JedisPool(jedisPoolConfig, host, port);
        Jedis jedis = jedisPool.getResource();
        return jedis;
    }

}

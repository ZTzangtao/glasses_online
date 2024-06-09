package com.zt.config;

import com.zt.converter.MoneyReadConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.convert.MongoCustomConversions;

import java.util.Arrays;

/**
 * @Author Tommy
 * @Date 2024/6/9 16:52
 * @Version 1.0
 */
@Configuration
public class MongoConversionsConfig {

    @Bean
    public MongoCustomConversions mongoCustomConversions() {
        return new MongoCustomConversions(Arrays.asList(new MoneyReadConverter()));
    }

}

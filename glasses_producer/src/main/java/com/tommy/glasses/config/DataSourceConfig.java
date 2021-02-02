package com.tommy.glasses.config;

import com.zaxxer.hikari.HikariDataSource;
import org.beetl.sql.ext.spring4.BeetlSqlDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;

/**
 * @Author Tommy
 * @Date 2021/2/2 10:30 PM
 * @Version 1.0
 */
@Configuration
public class DataSourceConfig {

    @Bean(name = "dataSource")
    public DataSource dataSource(Environment environment) {
        //配置数据源连接器,此处使用hikari,你也可以换为Druid
        HikariDataSource dataSourceObjForHikari = new HikariDataSource();
        dataSourceObjForHikari.setJdbcUrl(environment.getProperty("spring.datasource.url"));
        dataSourceObjForHikari.setUsername(environment.getProperty("spring.datasource.username"));
        dataSourceObjForHikari.setPassword(environment.getProperty("spring.datasource.password"));
        dataSourceObjForHikari.setDriverClassName(environment.getProperty("spring.datasource.driver-class-name"));
        return dataSourceObjForHikari;

    }

    @Bean
    public BeetlSqlDataSource beetlSqlDataSource(@Qualifier("dataSource") DataSource dataSource) {
        BeetlSqlDataSource source = new BeetlSqlDataSource();
        source.setMasterSource(dataSource);
        return source;
    }


}

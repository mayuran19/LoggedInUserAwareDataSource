package com.mayuran19.datasourceconfig.config;

import com.mayuran19.datasourceconfig.datasource.LoggedInUserAwareHikariDataSource;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DatasourceConfig{
    @Bean
    public DataSource dataSource() {
        HikariDataSource dataSource = new LoggedInUserAwareHikariDataSource(hikariConfig());
        return dataSource;
    }

    @Bean
    @ConfigurationProperties("spring.datasource.hikari")
    public HikariConfig hikariConfig(){
        return new HikariConfig();
    }
}

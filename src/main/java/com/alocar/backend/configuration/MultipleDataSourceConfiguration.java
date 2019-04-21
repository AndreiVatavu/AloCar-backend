package com.alocar.backend.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * Created by Andrei Vatavu on 4/22/2019
 */

@Configuration
public class MultipleDataSourceConfiguration {
    @Bean(name = "users")
    @Primary
    @ConfigurationProperties(value = "users.datasource", prefix = "users.datasource")
    public DataSource primaryDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "cars")
    @ConfigurationProperties("cars.datasource")
    public DataSource secondaryDataSource() {
        return DataSourceBuilder.create().build();
    }
}

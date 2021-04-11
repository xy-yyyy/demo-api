package com.demo.order.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.transaction.SpringManagedTransactionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import javax.sql.DataSource;
import io.seata.rm.datasource.DataSourceProxy;
/**
 * @Author: sunYF
 * @Description:代理数据源
 * @Date: Create in 11:10 2020/8/27
 */
@Configuration
@Slf4j
public class DataSourceConfig {

    @Value("${mybatis.mapper-locations}")
    private String mapperLocations;
    /**
     * 使用spring.datasource.hikari为前缀连接数据库
     * DataSource 默认为spring.datasource连接
     */
    @Bean(name = "dataSource") //作为一个bean对象并命名
    @ConfigurationProperties(prefix = "spring.datasource.hikari")
    public DataSource PrimaryDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Primary
    @Bean
    public DataSourceProxy dataSourceProxy(DataSource druidDataSource) {
        return new DataSourceProxy(druidDataSource);
    }

    @Bean
    public SqlSessionFactory sqlSessionFactoryBean(DataSourceProxy dataSourceProxy) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSourceProxy);
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        bean.setMapperLocations(resolver.getResources(mapperLocations));
        bean.setTransactionFactory(new SpringManagedTransactionFactory());
        return bean.getObject();
    }

}
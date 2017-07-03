package com.ouzhx.repository;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.tomcat.jdbc.pool.DataSourceFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import com.alibaba.druid.pool.DruidDataSource;
import com.baomidou.mybatisplus.entity.GlobalConfiguration;
import com.baomidou.mybatisplus.spring.MybatisSqlSessionFactoryBean;
import com.ouzhx.common.MybatisUtils;

/**
 * Created by ouzhx on 2017/4/14.
 */
@Configuration
@PropertySource("mybatis.properties")
@MapperScan(basePackages = "com.ouzhx.repository.mapper")
public class mybatisConfig {
  @Autowired
  private Environment env;

  /**
   * 使用 druid 数据源
   * @return
   * @throws Exception
   */
  @Bean
  @Profile("dev")
  public DataSource dataSource1() throws Exception {
    System.out.println("正在使用 dev 数据源!");
    // 这里出现一个问题 有系统属性username会优先于自定义配置的username 所以添加了mysql前缀
    Resource resource = new ClassPathResource(MybatisUtils.configPropertiesFileName);
    Properties properties = new Properties();
    properties.load(resource.getInputStream());

    DruidDataSource dataSource = new DruidDataSource();
    dataSource.setUsername(properties.getProperty("mysql.username"));
    dataSource.setUrl(properties.getProperty("mysql.url"));
    dataSource.setDriverClassName(properties.getProperty("mysql.driver"));
    dataSource.setPassword(properties.getProperty("mysql.password"));
    return dataSource;
  }

  @Bean
  @Profile("default")
  public DataSource dataSource2() throws Exception {
    System.out.println("正在使用 default 数据源!");
    Resource resource = new ClassPathResource(MybatisUtils.configPropertiesFileName);
    Properties properties = new Properties();
    properties.load(resource.getInputStream());
    DataSourceFactory factory = new DataSourceFactory();
    return factory.createDataSource(properties);
  }

  /*
   * @Bean public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource) throws
   * Exception { SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
   * sqlSessionFactoryBean.setDataSource(dataSource); Resource[] xmlMappers = new
   * PathMatchingResourcePatternResolver().getResources("classpath:xmlmapper
   *//*
     * .xml"); sqlSessionFactoryBean.setMapperLocations(xmlMappers); //
     * sqlSessionFactoryBean.setConfigLocation(new ClassPathResource("mybatis-config.xml"));
     * sqlSessionFactoryBean.setTypeAliasesPackage(env.getProperty("mybatis.typeAliasesPackage"));
     * return sqlSessionFactoryBean; }
     */

  @Bean
  public MybatisSqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource)
      throws Exception {
    // SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
    // Mybatis-Plus 的集成非常简单，对于 Spring，我们仅仅需要把 Mybatis 自带的MybatisSqlSessionFactoryBean替换为 MP 自带的即可。
    MybatisSqlSessionFactoryBean sqlSessionFactoryBean = new MybatisSqlSessionFactoryBean();
    sqlSessionFactoryBean.setDataSource(dataSource);
    Resource[] xmlMappers =
        new PathMatchingResourcePatternResolver().getResources("classpath:xmlmapper/*.xml");
    sqlSessionFactoryBean.setMapperLocations(xmlMappers);
    // 配置 Mybatis 配置文件（可无）
    // sqlSessionFactoryBean.setConfigLocation(new ClassPathResource("mybatis-config.xml"));
    sqlSessionFactoryBean.setTypeAliasesPackage("com.ouzhx.entity");
    sqlSessionFactoryBean.setGlobalConfig(globalConfig());
    return sqlSessionFactoryBean;
  }

  @Bean
  public GlobalConfiguration globalConfig() {
    GlobalConfiguration configuration = new GlobalConfiguration();
    configuration.setIdType(3);
    configuration.setDbType("mysql");
    // 表为下划线命名设置 true
    configuration.setDbColumnUnderline(true);
    return configuration;
  }

}

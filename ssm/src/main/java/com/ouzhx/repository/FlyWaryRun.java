package com.ouzhx.repository;

import java.util.Properties;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSource;
import org.flywaydb.core.Flyway;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.ouzhx.AppConfig;
import com.ouzhx.common.MybatisUtils;

/**
 * Created by ouzhx on 2017/4/17.
 */
public class FlyWaryRun {
  /**
   * 添加新的sql版本后 可以手动执行版本合并动作 (或者:默认启动容器时就会执行版本合并)
   * @param args
   * @throws Exception
   */
  public static void main(String[] args) throws Exception {
    // 创建数据源
    Resource resource = new ClassPathResource(MybatisUtils.configPropertiesFileName);
    Properties properties = new Properties();
    properties.load(resource.getInputStream());
    Flyway flyway = new Flyway();

    DruidDataSource dataSource = new DruidDataSource();
    dataSource.setUsername(properties.getProperty("mysql.username"));
    dataSource.setUrl(properties.getProperty("mysql.url"));
    dataSource.setDriverClassName(properties.getProperty("mysql.driver"));
    dataSource.setPassword(properties.getProperty("mysql.password"));

    flyway.setDataSource(dataSource);

    // start migration
    flyway.migrate();

  }
}

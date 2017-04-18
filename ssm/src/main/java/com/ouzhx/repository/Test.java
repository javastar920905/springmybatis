package com.ouzhx.repository;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ouzhx.AppConfig;
import com.ouzhx.entity.City;
import com.ouzhx.repository.mapper.CityMapper;

/**
 * Created by Administrator on 2017/4/15.
 */

public class Test {
  public static void main(String[] args) {
    AnnotationConfigApplicationContext context =
        new AnnotationConfigApplicationContext(FlywayConfig.class);
    CityMapper cityMapper = context.getBean(CityMapper.class);
    City city = cityMapper.selectByPrimaryKey(Long.parseLong("1"));
    System.out.println(city.getName());
  }
}

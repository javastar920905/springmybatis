package com.ouzhx.repository;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.ouzhx.entity.User;
import com.ouzhx.repository.mapper.UserMapper;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ouzhx.AppConfig;
import com.ouzhx.entity.City;
import com.ouzhx.repository.mapper.CityMapper;

import java.util.List;
import java.util.UUID;

/**
 * Created by Administrator on 2017/4/15.
 */

public class Test {
  public static void main(String[] args) {
    AnnotationConfigApplicationContext context =
        new AnnotationConfigApplicationContext(mybatisConfig.class);
    UserMapper userMapper = context.getBean(UserMapper.class);
    // 初始化 影响行数
    int result = 0;
    // 初始化 User 对象
    User user = new User();

    // 插入 User (插入成功会自动回写主键到实体类)
    user.setUsername("ouzhx");
    user.setId(UUID.randomUUID().toString().replaceAll("-", ""));
    user.setSalt(UUID.randomUUID().toString().replaceAll("-", ""));
    user.setPassword("123456");
    result = userMapper.insert(user);

    // 查询 User
    User exampleUser = userMapper.selectById(user.getId());

    // 查询姓名为‘张三’的所有用户记录
    List<User> userList = userMapper.selectList(new EntityWrapper<User>().eq("username", "ouzhx"));

    // 删除 User
    result = userMapper.deleteById(user.getId());


    // 分页查询 10 条姓名为‘ouzhx’的用户记录
    List<User> userListPage1 = userMapper.selectPage(new Page<User>(1, 10),
        new EntityWrapper<User>().eq("username", "ouzhx"));

    // 分页查询 10 条姓名为‘张三’、性别为男，且年龄在18至50之间的用户记录
    List<User> userListPage2 = userMapper.selectPage(new Page<User>(1, 10),
        new EntityWrapper<User>().eq("sex", 20).between("age", "0", "50"));
  }
}

package com.ouzhx.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.ouzhx.entity.User;
import com.ouzhx.repository.mapper.UserMapper;
import com.ouzhx.service.IUserService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ouzhx
 * @since 2017-07-03
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
	
}

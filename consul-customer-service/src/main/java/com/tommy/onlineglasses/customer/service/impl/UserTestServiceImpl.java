package com.tommy.onlineglasses.customer.service.impl;

import com.tommy.onlineglasses.customer.mapper.UserTestMapper;
import com.tommy.onlineglasses.customer.service.UserTestService;
import org.beetl.sql.core.SQLManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author Tommy
 * @Date 2021/2/5 10:51 PM
 * @Version 1.0
 */
@Service
public class UserTestServiceImpl implements UserTestService {

    @Autowired
    UserTestMapper userTestMapper;

    @Autowired
    SQLManager sqlManager;

    @Override
    public Object userTest() {
        return userTestMapper.getUserTestInfo().toString();
    }
}

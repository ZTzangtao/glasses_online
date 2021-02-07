package com.tommy.onlineglasses.customer.mapper;

import com.tommy.onlineglasses.customer.model.User;
import org.beetl.sql.mapper.BaseMapper;
import org.beetl.sql.mapper.annotation.SqlResource;

/**
 * @Author Tommy
 * @Date 2021/2/5 9:48 PM
 * @Version 1.0
 */
@SqlResource("userTest")
public interface UserTestMapper extends BaseMapper<User> {

    /**
     * getUserTestInfo
     *
     * @return
     */
    User getUserTestInfo();
}

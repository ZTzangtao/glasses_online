package com.zt.mapper;


import com.zt.entity.GlassesUser;
import org.beetl.sql.mapper.BaseMapper;
import org.beetl.sql.mapper.annotation.SqlResource;

import java.util.List;

/**
 * @author zangtao
 * @date 2020/1/2 12:21
 */
@SqlResource("user")
public interface GlassesUserMapper extends BaseMapper<GlassesUser> {

    /**
     * demo
     *
     * @param name
     * @return
     */
     List<GlassesUser> selectUser(String name);
}

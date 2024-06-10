package com.zt.service.impl;

import com.zt.base.Response;
import com.zt.mapper.GlassesUserMapper;
import com.zt.service.GlassesMallService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * @Author Tommy
 * @Date 2024/6/10 11:51
 * @Version 1.0
 */
@Service
public class GlassesMallServiceImpl implements GlassesMallService {

    @Resource
    private GlassesUserMapper glassesUserMapper;

    @Override
    public Response testBeetlSql() {
        return Response.success(glassesUserMapper.selectUser("z"));
    }
}

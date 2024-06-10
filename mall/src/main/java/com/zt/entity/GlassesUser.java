package com.zt.entity;


import lombok.Data;
import org.beetl.sql.annotation.entity.AutoID;
import org.beetl.sql.annotation.entity.Table;


/**
 * @author zangtao
 * @date 2020/1/2 10:01
 */

@Table(name="glasses_user")
@Data
public class GlassesUser {
    @AutoID
    private Integer id;

    private String userName;

    private String userPassword;

   
}

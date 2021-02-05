package com.tommy.onlineglasses.customer.controller;

import com.tommy.onlineglasses.customer.service.UserTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Tommy
 * @Date 2021/2/5 10:32 PM
 * @Version 1.0
 */
@RestController
public class UerController {

    @Autowired
    private UserTestService userTestService;


    @GetMapping("/userTest")
    public  Object UserTest(){
        return userTestService.userTest();
    }

}

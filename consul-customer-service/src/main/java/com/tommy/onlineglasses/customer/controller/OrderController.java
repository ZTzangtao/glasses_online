package com.tommy.onlineglasses.customer.controller;

import com.tommy.onlineglasses.customer.base.Response;
import com.tommy.onlineglasses.customer.model.NewOrderRequest;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

/**
 * @Author Tommy
 * @Date 2021/2/23 9:30 PM
 * @Version 1.0
 */
@RestController
public class OrderController {


    @GetMapping("order")
    @CircuitBreaker(name = "order")
    public Response createOrder() {
        NewOrderRequest orderRequest = NewOrderRequest.builder()
                .customer("Li Lei")
                .items(Arrays.asList("capuccino"))
                .build();
        return Response.success();
    }
}

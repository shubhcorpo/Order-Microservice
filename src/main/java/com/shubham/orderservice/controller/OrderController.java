package com.shubham.orderservice.controller;

import com.netflix.discovery.converters.Auto;
import com.shubham.orderservice.model.OrderRequest;
import com.shubham.orderservice.service.OrdersService;
import lombok.extern.log4j.Log4j2;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
@RequestMapping("/orderservice/order")
public class OrderController {

    @Autowired
    private OrdersService ordersService;

    @PostMapping("/placeOrder")
    public ResponseEntity<Long> placeOrder(@RequestBody OrderRequest orderRequest){
        log.info("Inside Order controller palceorder api with request"+orderRequest);
       long order_Id=ordersService.palceOrder(orderRequest);
       return new ResponseEntity<>(order_Id, HttpStatus.CREATED);
    }


}

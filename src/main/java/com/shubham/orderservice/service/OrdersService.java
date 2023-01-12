package com.shubham.orderservice.service;

import com.shubham.orderservice.model.OrderRequest;

public interface OrdersService {
    long palceOrder(OrderRequest orderRequest);
}

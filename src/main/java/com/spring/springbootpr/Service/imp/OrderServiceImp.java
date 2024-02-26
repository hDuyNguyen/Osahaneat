package com.spring.springbootpr.Service.imp;

import com.spring.springbootpr.Payload.Request.OrderRequest;

public interface OrderServiceImp {
    boolean insertOrder(OrderRequest orderRequest);
}

package com.spring.springbootpr.Controller;

import com.spring.springbootpr.Payload.Request.OrderRequest;
import com.spring.springbootpr.Service.imp.OrderServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderServiceImp orderServiceImp;

    @PostMapping()
    public ResponseEntity<?> getAllUser(@RequestBody OrderRequest orderRequest) {

        return new ResponseEntity<>(orderServiceImp.insertOrder(orderRequest), HttpStatus.OK);
    }
}

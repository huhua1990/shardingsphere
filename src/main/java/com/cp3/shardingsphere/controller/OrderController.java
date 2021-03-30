package com.cp3.shardingsphere.controller;

import com.cp3.shardingsphere.common.R;
import com.cp3.shardingsphere.entity.OrderDTO;
import com.cp3.shardingsphere.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Title: OrderController
 * @Description:
 * @author: huhua
 * @date: 2021/3/13 18:04
 */
@RestController
@RequestMapping("order")
@Slf4j
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("create")
    public R create(@RequestBody OrderDTO orderDTO){
        return orderService.createOrder(orderDTO);
    }

    @PostMapping("update")
    public R updateUserUserNameByPhone(@RequestBody OrderDTO orderDTO){
        return orderService.updateOrder(orderDTO);
    }

    @PostMapping("delete")
    public R deleteUserByPhone(@RequestParam String orderId){
        return orderService.deleteOrder(orderId);
    }

    @GetMapping("query")
    public R query(@RequestParam(required = false) String buyer){
        return orderService.findList(buyer);
    }
}

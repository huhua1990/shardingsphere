package com.cp3.shardingsphere.service;

import com.cp3.shardingsphere.common.R;
import com.cp3.shardingsphere.entity.OrderDTO;

/**
 * @Title: OrderService
 * @Description:
 * @author: huhua
 * @date: 2021/3/26 18:21
 */
public interface OrderService {
    R createOrder(OrderDTO orderDTO);

    R updateOrder(OrderDTO orderDTO);

    R deleteOrder(String orderId);

    R findList(String buyer);
}

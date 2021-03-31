package com.cp3.shardingsphere.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.RandomUtil;
import com.cp3.shardingsphere.common.R;
import com.cp3.shardingsphere.entity.Order;
import com.cp3.shardingsphere.entity.OrderDTO;
import com.cp3.shardingsphere.mapper.OrderMapper;
import com.cp3.shardingsphere.service.OrderService;
import com.cp3.shardingsphere.utils.shardingsphere.SnowFlakeUtil;
import com.cp3.shardingsphere.utils.twitter.IdWorkerUtils;
import com.cp3.shardingsphere.utils.uuid.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Title: OrderServiceImpl
 * @Description:
 * @author: huhua
 * @date: 2021/3/26 18:27
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;

    @Override
    public R createOrder(OrderDTO orderDTO) {
        Order order = new Order();
        BeanUtil.copyProperties(orderDTO, order);
        order.setOrderId(Long.valueOf(RandomUtil.randomNumbers(2)));
        order.setOrderNo("NO"+RandomUtil.randomNumbers(6));
        order.setOrderStatus("1");
        orderMapper.insert(order);
        return R.success();
    }

    @Override
    public R updateOrder(OrderDTO orderDTO) {
        Order order = new Order();
        BeanUtil.copyProperties(orderDTO, order);
        orderMapper.updateStatus(order);
        return R.success();
    }

    @Override
    public R deleteOrder(String orderId) {
        return R.success(orderMapper.deleteOrder(orderId));
    }

    @Override
    public R findList(String buyer) {
        List<Order> orderList = orderMapper.findList(buyer);
        return R.success(orderList);
    }
}

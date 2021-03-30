package com.cp3.shardingsphere.entity;

import lombok.Data;

/**
 * @Title: OrderDTO
 * @Description:
 * @author: huhua
 * @date: 2021/3/26 18:23
 */
@Data
public class OrderDTO {
    private String orderId;
    private String goodName;
    private String buyer;
    private String orderStatus;
}

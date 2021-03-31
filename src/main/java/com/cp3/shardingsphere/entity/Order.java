package com.cp3.shardingsphere.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Title: Order
 * @Description:
 * @author: huhua
 * @date: 2021/3/26 18:21
 */
@Data
public class Order implements Serializable {
    private Long orderId;
    private String orderNo;
    private String goodName;
    private String buyer;
    private String orderStatus;
    private Date createTime;
}

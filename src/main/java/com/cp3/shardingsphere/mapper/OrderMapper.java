package com.cp3.shardingsphere.mapper;

import com.cp3.shardingsphere.entity.Order;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Title: OrderMapper
 * @Description:
 * @author: huhua
 * @date: 2021/3/26 18:28
 */
@Mapper
public interface OrderMapper {
    @Insert("insert into `order`(order_id, order_no, order_status, good_name, buyer, create_time) values (#{orderId}, #{orderNo}, #{orderStatus}, #{goodName}, #{buyer}, now()) ")
    int insert(Order order);

    @Select({"<script>",
            "select * from `order`",
            "<if test=\"buyer !=null and buyer !=''\">",
            "where buyer = #{buyer} ",
            "</if>",
            "order by create_time",
            "</script>"})
    List<Order> findList(@Param("buyer") String buyer);

    @Update("update `order` set order_status = #{orderStatus} where order_id = #{orderId}")
    public Integer updateStatus(Order order);

    @Delete("delete from `order` where order_id = #{orderId}")
    public Integer deleteOrder(@Param("orderId") String orderId);
}

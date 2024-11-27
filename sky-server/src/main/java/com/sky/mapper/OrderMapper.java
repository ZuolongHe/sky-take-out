package com.sky.mapper;

import com.sky.dto.OrdersPageQueryDTO;
import com.sky.entity.Orders;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Title sky-take-out
 * @Author hzl
 * @Date 2024/11/27 15:39
 * @Description 订单dao层接口
 */
@Mapper
public interface OrderMapper {

    // 返回订单在总记录数
    int getTotal();

    // 分页查询当前页订单数据集合
    List<Orders> getAllOrder(OrdersPageQueryDTO ordersPageQueryDTO);
}

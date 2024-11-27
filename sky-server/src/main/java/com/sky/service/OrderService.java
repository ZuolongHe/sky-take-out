package com.sky.service;

import com.sky.dto.OrdersPageQueryDTO;
import com.sky.result.PageResult;

/**
 * @Title sky-take-out
 * @Author hzl
 * @Date 2024/11/27 15:31
 * @Description
 */
public interface OrderService {

    /**
     * 分页查询订单
     */
    PageResult getAllOrder(OrdersPageQueryDTO ordersPageQueryDTO);

}

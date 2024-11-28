package com.sky.service;

import com.sky.dto.OrdersPageQueryDTO;
import com.sky.result.PageResult;
import com.sky.vo.OrderStatisticsVO;
import com.sky.vo.OrderVO;

/**
 * @Title sky-take-out
 * @Author hzl
 * @Date 2024/11/27 15:31
 * @Description
 */
public interface OrderService {

    /**
     * 分页查询订单
     * @param ordersPageQueryDTO
     * @return
     */
    PageResult getAllOrder(OrdersPageQueryDTO ordersPageQueryDTO);

    /**
     * 各个状态的订单数量统计
     * @return
     */
    OrderStatisticsVO statistics();

    /**
     * 查询订单详情
     * @param id
     * @return
     */
    OrderVO getOrderDetails(Integer id);
}

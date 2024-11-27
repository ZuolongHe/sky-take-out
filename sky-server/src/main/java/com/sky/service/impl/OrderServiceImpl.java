package com.sky.service.impl;

import com.sky.dto.OrdersPageQueryDTO;
import com.sky.entity.Orders;
import com.sky.mapper.OrderMapper;
import com.sky.result.PageResult;
import com.sky.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Title sky-take-out
 * @Author hzl
 * @Date 2024/11/27 15:32
 * @Description  订单相关接口
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    /**
     * 分页查询订单
     * @return PageResult
     */
    @Override
    public PageResult getAllOrder(OrdersPageQueryDTO ordersPageQueryDTO) {
        // 进行分页
        int page = ordersPageQueryDTO.getPage();
        int pageSize = ordersPageQueryDTO.getPageSize();
        // 赋值页码索引page
        ordersPageQueryDTO.setPage((page - 1) * pageSize);
        // 返回查询订单List集合
        List<Orders> allOrder = orderMapper.getAllOrder(ordersPageQueryDTO);
        // 返回总记录数total
        int total = orderMapper.getTotal();
        return new PageResult(total, allOrder);
    }
}

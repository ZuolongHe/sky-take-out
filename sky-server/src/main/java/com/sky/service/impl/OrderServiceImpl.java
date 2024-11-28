package com.sky.service.impl;

import com.sky.dto.OrdersPageQueryDTO;
import com.sky.entity.OrderDetail;
import com.sky.entity.Orders;
import com.sky.mapper.OrderMapper;
import com.sky.result.PageResult;
import com.sky.service.OrderService;
import com.sky.vo.OrderStatisticsVO;
import com.sky.vo.OrderVO;
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

    /**
     * 查询各个状态的订单数量
     * @return
     */
    @Override
    public OrderStatisticsVO statistics() {

        return null;
    }

    /**
     * 查询订单详情
     * @param id
     * @return
     */
    @Override
    public OrderVO getOrderDetails(Integer id) {
        // 1. 查询订单详情数据
        List<OrderDetail> orderDetailList = orderMapper.getOrderDetails(id);
        // 2. 根据orderId查询order信息
        Orders orders = orderMapper.getOrderById(id);
        OrderVO orderVO = new OrderVO();
        orderVO.setOrderDishes("null");
        orderVO.setOrderDetailList(orderDetailList);
        orderVO.setId(orders.getId());
        orderVO.setNumber(orders.getNumber());
        orderVO.setStatus(orders.getStatus());
        orderVO.setUserId(orders.getUserId());
        orderVO.setAddressBookId(orders.getAddressBookId());
        orderVO.setOrderTime(orders.getOrderTime());
        orderVO.setCheckoutTime(orders.getCheckoutTime());
        orderVO.setPayMethod(orders.getPayMethod());
        orderVO.setPayStatus(orders.getPayStatus());
        orderVO.setAmount(orders.getAmount());
        orderVO.setRemark(orders.getRemark());
        orderVO.setUserName(orders.getUserName());
        orderVO.setPhone(orders.getPhone());
        orderVO.setAddress(orders.getAddress());
        orderVO.setConsignee(orders.getConsignee());
        orderVO.setCancelReason(orders.getCancelReason());
        orderVO.setRejectionReason(orders.getRejectionReason());
        orderVO.setCancelTime(orders.getCancelTime());
        orderVO.setEstimatedDeliveryTime(orders.getEstimatedDeliveryTime());
        orderVO.setDeliveryStatus(orders.getDeliveryStatus());
        orderVO.setDeliveryTime(orders.getDeliveryTime());
        orderVO.setPackAmount(orders.getPackAmount());
        orderVO.setTablewareNumber(orders.getTablewareNumber());
        orderVO.setTablewareStatus(orders.getTablewareStatus());

        return orderVO;
    }


}

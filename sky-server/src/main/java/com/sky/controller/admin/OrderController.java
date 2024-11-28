package com.sky.controller.admin;

import com.sky.dto.OrdersPageQueryDTO;
import com.sky.entity.OrderDetail;
import com.sky.result.PageResult;
import com.sky.result.Result;
import com.sky.service.OrderService;
import com.sky.vo.OrderStatisticsVO;
import com.sky.vo.OrderVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Title sky-take-out
 * @Author hzl
 * @Date 2024/11/27 15:24
 * @Description
 */
@RestController
@RequestMapping("/admin/order")
@Slf4j
@Api(tags = "订单相关接口")
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     * 分页查询订单
     * @param ordersPageQueryDTO
     * @return Result<PageResult>
     */
    @GetMapping("/conditionSearch")
    public Result<PageResult> getAllOrder(OrdersPageQueryDTO ordersPageQueryDTO){
        PageResult allOrder = orderService.getAllOrder(ordersPageQueryDTO);
        return Result.success(allOrder);

    }

    /**
     * 各个状态的订单数量统计
     * @return
     */
    @GetMapping("/statistics")
    public Result statistics(){
        OrderStatisticsVO orderStatisticsVO = orderService.statistics();
        return Result.success();
    }

    /**
     * 查询订单详情
     * @param id
     * @return OrderVO
     */
    @GetMapping("/details/{id}")
    public Result<OrderVO> getOrderDetails(@PathVariable Integer id){
        log.info("接收参数{}", id);
        OrderVO orderVO = orderService.getOrderDetails(id);
        return Result.success(orderVO);
    }


}

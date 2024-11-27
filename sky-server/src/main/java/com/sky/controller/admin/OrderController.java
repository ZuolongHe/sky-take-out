package com.sky.controller.admin;

import com.sky.dto.OrdersPageQueryDTO;
import com.sky.result.PageResult;
import com.sky.result.Result;
import com.sky.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}

package com.sky.service.impl;

import com.sky.mapper.EmployeeMapper;
import com.sky.mapper.WorkSpaceMapper;
import com.sky.service.WorkSpace;
import com.sky.vo.BusinessDataVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @Title sky-take-out
 * @Author hzl
 * @Date 2024/12/1 14:36
 * @Description
 */
@Service
@Slf4j
public class WorkSpaceImpl implements WorkSpace {

    @Autowired
    private WorkSpaceMapper workSpaceMapper;

    @Autowired
    private EmployeeMapper employeeMapper;

    /**
     * 获取今日营业额数据
     * @return
     */
    @Override
    public BusinessDataVO getBusinessData() {
        // 1. 获取今日日期
        LocalDate today = LocalDate.now();
        log.info("今日日期：{}", today);
        // 2. 获取今日营业额 (根据state=5(已完成) and order_time(下单时间)=today)
        Double turnover = workSpaceMapper.getTurnover(today);
        // 3. 获取有效订单数 (根据state=5(已完成) and order_time(下单时间)=today)
        Integer num = workSpaceMapper.getOrderTotal();
        // 4. 计算订单完成率 (state=5(下单时间)=today的所有订单/order_time(下单时间)=today的所有订单)
        // order_time(下单时间)=today的所有订单
        Double totalNum = workSpaceMapper.getAllTotal();
        Double orderCompletionRate = num / totalNum;
        // 5. 计算平均客单价 (已完成的订单价总数/已完成的订单的订单数)
        Double unitPrice = turnover/num;
        // 6. 统计新增用户 (employee中create_time=today)
        Integer newUsers = employeeMapper.getNewUser();
        // 封装返回
        BusinessDataVO businessDataVO = BusinessDataVO.builder()
                .turnover(turnover)
                .validOrderCount(num)
                .orderCompletionRate(orderCompletionRate)
                .unitPrice(unitPrice)
                .newUsers(newUsers)
                .build();
        return businessDataVO;
    }
}

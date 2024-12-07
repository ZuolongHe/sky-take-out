package com.sky.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.time.LocalDate;
import java.util.List;

/**
 * @Title sky-take-out
 * @Author hzl
 * @Date 2024/12/1 14:40
 * @Description 工作台相关接口
 */
@Mapper
public interface WorkSpaceMapper {

    /**
     * 获取今日营业额
     * @return
     */
    Double getTurnover(LocalDate localDate);

    /**
     * 获取有效订单数
     * @return
     */
    Integer getOrderTotal();

    Integer getStateEnd();

    Double getAllTotal();
}

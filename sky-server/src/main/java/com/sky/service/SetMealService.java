package com.sky.service;

import com.sky.dto.SetmealPageQueryDTO;
import com.sky.result.PageResult;

/**
 * @Title sky-take-out
 * @Author hzl
 * @Date 2024/11/24 15:50
 * @Description
 */
public interface SetMealService {

    /**
     * 分页查询套餐
     */
    PageResult getAllMeal(SetmealPageQueryDTO setmealPageQueryDTO);
}

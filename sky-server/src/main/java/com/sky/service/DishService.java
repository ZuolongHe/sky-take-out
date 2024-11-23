package com.sky.service;

import com.sky.dto.DishPageQueryDTO;
import com.sky.result.PageResult;

/**
 * @Title sky-take-out
 * @Author hzl
 * @Date 2024/11/23 21:59
 * @Description
 */
public interface DishService {

    /**
     * 分页查询菜品
     */
    PageResult getAllDish(DishPageQueryDTO dishPageQueryDTO);
}

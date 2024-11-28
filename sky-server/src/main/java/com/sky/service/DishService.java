package com.sky.service;

import com.sky.dto.DishPageQueryDTO;
import com.sky.entity.Dish;
import com.sky.result.PageResult;

import java.util.List;

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

    /**
     * 根据分类id查询菜品
     * @return
     */
    List<Dish> getDishById(String categoryId);
}

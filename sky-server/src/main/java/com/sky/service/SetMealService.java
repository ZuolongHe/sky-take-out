package com.sky.service;

import com.sky.dto.SetmealDTO;
import com.sky.dto.SetmealPageQueryDTO;
import com.sky.result.PageResult;
import com.sky.vo.SetmealVO;

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

    /**
     * 新增套餐
     * @param setmealVO
     * @return
     */
    int addMeal(SetmealVO setmealVO);
}

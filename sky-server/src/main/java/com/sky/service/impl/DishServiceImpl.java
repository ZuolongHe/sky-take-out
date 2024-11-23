package com.sky.service.impl;

import com.sky.dto.DishPageQueryDTO;
import com.sky.result.PageResult;
import com.sky.service.DishService;
import org.springframework.stereotype.Service;

/**
 * @Title sky-take-out
 * @Author hzl
 * @Date 2024/11/23 22:00
 * @Description
 */
@Service
public class DishServiceImpl implements DishService {

    /**
     * 分页查询菜品
     * @param dishPageQueryDTO
     * @return
     */
    @Override
    public PageResult getAllDish(DishPageQueryDTO dishPageQueryDTO) {

        return null;
    }
}

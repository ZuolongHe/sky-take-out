package com.sky.service.impl;

import com.sky.dto.DishPageQueryDTO;
import com.sky.entity.Dish;
import com.sky.mapper.DishMapper;
import com.sky.result.PageResult;
import com.sky.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Title sky-take-out
 * @Author hzl
 * @Date 2024/11/23 22:00
 * @Description
 */
@Service
public class DishServiceImpl implements DishService {

    @Autowired
    private DishMapper dishMapper;

    /**
     * 分页查询菜品
     * @param dishPageQueryDTO
     * @return PageResult
     */
    @Override
    public PageResult getAllDish(DishPageQueryDTO dishPageQueryDTO) {
        // 进行分页操作
        int page = dishPageQueryDTO.getPage();
        int pageSize = dishPageQueryDTO.getPageSize();
        dishPageQueryDTO.setPage((page - 1) * pageSize);
        List<Dish> allDish = dishMapper.getAllDish(dishPageQueryDTO);
        int total = dishMapper.getTotal();
        return new PageResult(total, allDish);
    }

    /**
     * 根据分类id查询菜品
     * @return
     */
    @Override
    public List<Dish> getDishById(String categoryId) {
        List<Dish> dishes = dishMapper.getDishById(categoryId);
        return dishes;
    }
}

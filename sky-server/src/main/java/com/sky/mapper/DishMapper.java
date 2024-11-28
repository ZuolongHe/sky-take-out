package com.sky.mapper;

import com.sky.dto.DishPageQueryDTO;
import com.sky.entity.Dish;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Title sky-take-out
 * @Author hzl
 * @Date 2024/11/23 22:22
 * @Description
 */
@Mapper
public interface DishMapper {

    List<Dish> getAllDish(DishPageQueryDTO dishPageQueryDTO);

    int getTotal();

    List<Dish> getDishById(@Param("categoryId") String categoryId);
}

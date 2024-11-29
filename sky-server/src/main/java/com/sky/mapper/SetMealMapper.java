package com.sky.mapper;

import com.sky.dto.SetmealPageQueryDTO;
import com.sky.entity.Setmeal;
import com.sky.entity.SetmealDish;
import com.sky.vo.SetmealVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Title sky-take-out
 * @Author hzl
 * @Date 2024/11/24 15:58
 * @Description
 */
@Mapper
public interface SetMealMapper {

    /**
     * 分页查询所有套餐
     * @param setmealPageQueryDTO
     * @return
     */
    List<Setmeal> getAllMeal(SetmealPageQueryDTO setmealPageQueryDTO);

    /**
     * 查询总记录数
     * @return
     */
    int getTotal();

    /**
     * 套餐中菜品信息
     * @param setmealDish
     * @return
     */
    int addSetmealDishes(SetmealDish setmealDish);

    /**
     * 新增套餐
     * @param setmealVO
     * @return
     */
    int addMeal(SetmealVO setmealVO);
}

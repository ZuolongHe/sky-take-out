package com.sky.service.impl;

import com.sky.dto.SetmealDTO;
import com.sky.dto.SetmealPageQueryDTO;
import com.sky.entity.Setmeal;
import com.sky.entity.SetmealDish;
import com.sky.mapper.SetMealMapper;
import com.sky.result.PageResult;
import com.sky.service.SetMealService;
import com.sky.vo.SetmealVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Title sky-take-out
 * @Author hzl
 * @Date 2024/11/24 15:52
 * @Description
 */
@Slf4j
@Service
public class SetMealServiceImpl implements SetMealService {

    @Autowired
    private SetMealMapper setMealMapper;

    /**
     * 分页查询套餐
     * @param setmealPageQueryDTO
     * @return PageResult
     */
    @Override
    public PageResult getAllMeal(SetmealPageQueryDTO setmealPageQueryDTO) {
        int page = setmealPageQueryDTO.getPage();
        int pageSize = setmealPageQueryDTO.getPageSize();
        // 进行分页，计算索引
        setmealPageQueryDTO.setPage((page - 1) * pageSize);
        // 分页查询所有套餐
        List<Setmeal> allMeal = setMealMapper.getAllMeal(setmealPageQueryDTO);
        // 查询总记录数
        int total = setMealMapper.getTotal();
        // 返回pageResult结果
        return new PageResult(total, allMeal);
    }

    /**
     * 新增套餐
     * @param setmealVO
     * @return
     */
    @Override
    public int addMeal(SetmealVO setmealVO) {
        // 1. 套餐信息存到setmeal中
        int mealNum = setMealMapper.addMeal(setmealVO);
        // 2. 套餐中包含的菜品setmealDishes存到setmeal_dish表中,forEach遍历存入数据库
        List<SetmealDish> setmealDishes = setmealVO.getSetmealDishes();
        setmealDishes.forEach(setmealDish -> {
            int num = setMealMapper.addSetmealDishes(setmealDish);
            log.info("返回num{}", num);
        });
        return mealNum;
    }
}

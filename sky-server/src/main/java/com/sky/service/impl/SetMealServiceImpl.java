package com.sky.service.impl;

import com.sky.dto.SetmealPageQueryDTO;
import com.sky.entity.Setmeal;
import com.sky.mapper.SetMealMapper;
import com.sky.result.PageResult;
import com.sky.service.SetMealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Title sky-take-out
 * @Author hzl
 * @Date 2024/11/24 15:52
 * @Description
 */
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
}

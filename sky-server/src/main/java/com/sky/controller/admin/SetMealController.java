package com.sky.controller.admin;

import com.sky.dto.SetmealDTO;
import com.sky.dto.SetmealPageQueryDTO;
import com.sky.result.PageResult;
import com.sky.result.Result;
import com.sky.service.SetMealService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Title sky-take-out
 * @Author hzl
 * @Date 2024/11/24 15:30
 * @Description  套餐相关接口
 */
@RestController
@RequestMapping("/admin/setmeal")
@Slf4j
@Api(tags = "套餐相关接口")
public class SetMealController {

    @Autowired
    private SetMealService setMealService;

    /**
     * 分页查询所有套餐
     */
    @GetMapping("/page")
    public Result<PageResult> getAllMeal(SetmealPageQueryDTO setmealPageQueryDTO){
        PageResult pageResult = setMealService.getAllMeal(setmealPageQueryDTO);
        return Result.success(pageResult);
    }

    /**
     * 新增套餐
     * @param setmealDTO
     * @return
     */
    @PostMapping
    public Result addMeal(SetmealDTO setmealDTO){
        int num = setMealService.addMeal(setmealDTO);
        return Result.success();
    }
}

package com.sky.controller.admin;

import com.sky.dto.DishPageQueryDTO;
import com.sky.result.PageResult;
import com.sky.result.Result;
import com.sky.service.DishService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Title sky-take-out
 * @Author hzl
 * @Date 2024/11/23 21:44
 * @Description 菜品相关接口
 */
@RestController
@RequestMapping("/admin/dish")
@Slf4j
@Api(tags = "菜品相关接口")
public class DishController {

    @Autowired
    private DishService dishService;

    /**
     * 分页查询所有菜品
     */
    @GetMapping("/page")
    public Result<PageResult> getAllDish(DishPageQueryDTO dishPageQueryDTO){
        PageResult pageResult = dishService.getAllDish(dishPageQueryDTO);
        return Result.success(pageResult);
    }





}

package com.sky.controller.admin;

import com.sky.dto.DishPageQueryDTO;
import com.sky.entity.Dish;
import com.sky.result.PageResult;
import com.sky.result.Result;
import com.sky.service.DishService;
import com.sun.xml.internal.bind.v2.TODO;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
    // TODO Web端菜品分类不显示，分类id正常返回
    @GetMapping("/page")
    public Result<PageResult> getAllDish(DishPageQueryDTO dishPageQueryDTO){
        PageResult pageResult = dishService.getAllDish(dishPageQueryDTO);
        return Result.success(pageResult);
    }


    @GetMapping("/list")
    public Result<List<Dish>> getDishById(String categoryId){
        List<Dish> dishes = dishService.getDishById(categoryId);
        return Result.success(dishes);
    }





}

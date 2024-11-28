package com.sky.controller.admin;

import com.sky.dto.CategoryPageQueryDTO;
import com.sky.entity.Category;
import com.sky.result.PageResult;
import com.sky.result.Result;
import com.sky.service.CategoryService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Title sky-take-out
 * @Author hzl
 * @Date 2024/11/24 19:18
 * @Description
 */
@RestController
@RequestMapping("/admin/category")
@Slf4j
@Api(tags = "分类相关接口")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    /**
     * 分页查询分类数据
     */
    @GetMapping("/page")
    public Result<PageResult> getAllCategory(CategoryPageQueryDTO categoryPageQueryDTO){
        PageResult allCategory = categoryService.getAllCategory(categoryPageQueryDTO);
        return Result.success(allCategory);
    }

    /**
     * 根据类型查询分类
     * @param type
     * @return
     */
    @GetMapping("/list")
    public Result<List<Category>> getCategoryByType(@RequestParam String type){
        List<Category> category = categoryService.getCategoryByType(type);
        return Result.success(category);
    }


}

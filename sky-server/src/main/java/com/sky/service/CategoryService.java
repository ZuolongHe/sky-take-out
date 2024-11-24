package com.sky.service;

import com.sky.dto.CategoryPageQueryDTO;
import com.sky.result.PageResult;

/**
 * @Title sky-take-out
 * @Author hzl
 * @Date 2024/11/24 19:30
 * @Description
 */
public interface CategoryService {

    /**
     * 分页查询分类数据
     */
    PageResult getAllCategory(CategoryPageQueryDTO categoryPageQueryDTO);

}

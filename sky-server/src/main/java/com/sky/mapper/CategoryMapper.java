package com.sky.mapper;

import com.sky.dto.CategoryPageQueryDTO;
import com.sky.entity.Category;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Title sky-take-out
 * @Author hzl
 * @Date 2024/11/24 19:35
 * @Description
 */
@Mapper
public interface CategoryMapper {

    /**
     * 获取总记录数
     * @return int total
     */
    int getTotal();

    /**
     * 获分页查询分类数据
     * @return List<Category> list
     */
    List<Category> getAllCategory(CategoryPageQueryDTO categoryPageQueryDTO);
}

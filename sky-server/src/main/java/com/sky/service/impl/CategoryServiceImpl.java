package com.sky.service.impl;

import com.sky.dto.CategoryPageQueryDTO;
import com.sky.entity.Category;
import com.sky.mapper.CategoryMapper;
import com.sky.result.PageResult;
import com.sky.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Title sky-take-out
 * @Author hzl
 * @Date 2024/11/24 19:30
 * @Description
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    /**
     * 分页查询分类数据
     * @param categoryPageQueryDTO
     * @return PageResult
     */
    @Override
    public PageResult getAllCategory(CategoryPageQueryDTO categoryPageQueryDTO) {
        // 实现分页，找到索引
        int page = categoryPageQueryDTO.getPage();
        int pageSize = categoryPageQueryDTO.getPageSize();
        categoryPageQueryDTO.setPage((page - 1) * pageSize);
        // 获取分类数据集合
        List<Category> list = categoryMapper.getAllCategory(categoryPageQueryDTO);
        // 获取总记录数
        int total = categoryMapper.getTotal();
        // 封装PageResult
        return new PageResult(total, list);
    }

    /**
     * 根据了类型查询分类
     * @param type
     * @return
     */
    @Override
    public List<Category> getCategoryByType(String type) {
        List<Category> category = categoryMapper.getCategoryByType(type);
        return category;
    }
}

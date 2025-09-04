package com.sky.service;

import com.sky.dto.CategoryDTO;
import com.sky.dto.CategoryPageDTO;
import com.sky.entity.Category;
import com.sky.result.PageResult;


public interface CategoryService {

    PageResult<Category> pageQuery(CategoryPageDTO categoryPageDTO);

    void updateCategory(CategoryDTO categoryDTO);

    void updateStatus(Integer status, Long id);

    void saveCategory(CategoryDTO categoryDTO);

    void deleteCategoryById(Long id);
    
}

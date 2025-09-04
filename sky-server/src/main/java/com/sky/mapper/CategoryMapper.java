package com.sky.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.github.pagehelper.Page;
import com.sky.dto.CategoryPageDTO;
import com.sky.entity.Category;

@Mapper
public interface CategoryMapper {

    /**
     * 分页查询
     * @param categoryPageDTO
     * @return
     */
    Page<Category> pageQuery(CategoryPageDTO categoryPageDTO);

    /**
     * 修改分类
     * @param category
     */
    void updateCategory(Category category);

    /**
     * 新增分类
     * @param category
     */
    void saveCategory(Category category);

    /**
     * 根据id删除分类
     * @param id
     */
    void deleteCategoryById(Long id);
    
}

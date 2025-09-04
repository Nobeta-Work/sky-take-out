package com.sky.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sky.context.BaseContext;
import com.sky.dto.CategoryDTO;
import com.sky.dto.CategoryPageDTO;
import com.sky.entity.Category;
import com.sky.mapper.CategoryMapper;
import com.sky.result.PageResult;
import com.sky.service.CategoryService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private CategoryMapper categoryMapper;

    /**
     * 分页查询
     * @param categoryPageDTO
     * @return
     */
    @Override
    public PageResult<Category> pageQuery(CategoryPageDTO categoryPageDTO) {
        // 开启分页
        PageHelper.startPage(categoryPageDTO.getPage(), categoryPageDTO.getPageSize());
        // 执行查询
        Page<Category> pageResult = categoryMapper.pageQuery(categoryPageDTO);
        Long total = pageResult.getTotal();
        List<Category> records = pageResult.getResult();
        // 封装结果并返回
        return new PageResult<Category>(total, records);
    }

    /**
     * 修改分类
     * @param categoryDTO
     * @return
     */
    @Override
    public void updateCategory(CategoryDTO categoryDTO) {
        Category category = new Category();
        BeanUtils.copyProperties(categoryDTO, category);
        category.setUpdateUser(BaseContext.getCurrentId());
        category.setUpdateTime(LocalDateTime.now());
        categoryMapper.updateCategory(category);
    }

    /**
     * 启用禁用分类
     */
    @Override
    public void updateStatus(Integer status, Long id) {
        Integer newStatus = 1 - status; // 取反
        Category category = Category.builder()
                .id(id)
                .status(newStatus)
                .build();
        categoryMapper.updateCategory(category);
    }
    
    /**
     * 新增分类
     * @param categoryDTO
     * @return
     */
    public void saveCategory(CategoryDTO categoryDTO) {
        Category category = new Category();
        BeanUtils.copyProperties(categoryDTO, category);
        category.setCreateUser(BaseContext.getCurrentId());
        category.setCreateTime(LocalDateTime.now());
        category.setStatus(0);
        category.setUpdateUser(BaseContext.getCurrentId());
        category.setUpdateTime(LocalDateTime.now());
        categoryMapper.saveCategory(category);
    }

    /**
     * 删除分类
     * @param id
     * @return
     */
    @Override
    public void deleteCategoryById(Long id) {
        categoryMapper.deleteCategoryById(id);
    }
}

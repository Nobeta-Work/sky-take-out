package com.sky.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sky.dto.CategoryDTO;
import com.sky.dto.CategoryPageDTO;
import com.sky.entity.Category;
import com.sky.result.PageResult;
import com.sky.result.Result;
import com.sky.service.CategoryService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/admin/category")
@Slf4j
@Schema(description = "分类管理")
public class CategoryController {
    
    @Autowired
    private CategoryService categoryService;


    /**
     * 分页管理
     * @param categoryPageQueryDTO
     * @return
     */
    @GetMapping("/page")
    @Operation(summary = "分类分页查询")
    public Result<PageResult<Category>> page(CategoryPageDTO categoryPageDTO) {
        log.info("分类分页查询");
        PageResult<Category> pageResult = categoryService.pageQuery(categoryPageDTO);
        return Result.success(pageResult);
    }

    /**
     * 修改分类
     * @param categoryDTO
     * @return
     */
    @PutMapping
    @Operation(summary = "修改分类")
    public Result updateCategory(@Valid @RequestBody CategoryDTO categoryDTO) {
        log.info("修改分类:{}", categoryDTO);
        categoryService.updateCategory(categoryDTO);
        return Result.success();
    }

    /**
     * 启用禁用分类
     * @param status
     * @param id
     * @return
     */
    @Schema(description = "启用禁用分类")
    @PostMapping("/status/{status}")
    public Result<Void> updateStatus(@PathVariable Integer status, Long id) {
        log.info("启用禁用分类:{}", id);
        categoryService.updateStatus(status, id);
        return Result.success();
    }

    /**
     * 新增分类
     * @param categoryDTO
     * @return
     */
    @Schema(description = "新增分类")
    @PostMapping
    public Result<Void> saveCategory(@Valid @RequestBody CategoryDTO categoryDTO) {
        log.info("新增分类:{}", categoryDTO);
        categoryService.saveCategory(categoryDTO);
        return Result.success();
    }

    /**
     * 删除分类
     * @param id
     * @return
     */
    @Schema(description = "删除分类")
    @DeleteMapping
    public Result<Void> deleteCategoryById(Long id) {
        log.info("删除分类:{}", id);
        categoryService.deleteCategoryById(id);
        return Result.success();
    }
}

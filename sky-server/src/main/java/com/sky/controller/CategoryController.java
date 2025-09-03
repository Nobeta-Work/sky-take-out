package com.sky.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/admin/category")
@Slf4j
@Schema(description = "分类管理")
public class CategoryController {
    
}

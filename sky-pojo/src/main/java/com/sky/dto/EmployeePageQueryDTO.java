package com.sky.dto;

import lombok.Data;

@Data
public class EmployeePageQueryDTO {
    private String name;
    private Integer page;
    private Integer pageSize;
}

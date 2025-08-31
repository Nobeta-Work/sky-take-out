package com.sky.dto;

import lombok.Data;

@Data
public class EmployeePageQueryDTO {
    private String name;    //  查询姓名
    private Integer page;   //  当前页码
    private Integer pageSize;   //  每页显示记录数
}

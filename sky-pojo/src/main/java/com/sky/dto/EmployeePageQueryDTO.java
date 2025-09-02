package com.sky.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import lombok.Data;

@Data
@Schema(description = "员工管理分页查询请求类")
public class EmployeePageQueryDTO {
    @Schema(description = "查询的员工姓名", example = "张三", requiredMode = RequiredMode.REQUIRED)
    private String name;    //  查询姓名
    @Schema(description = "当前页码", example = "1", requiredMode = RequiredMode.REQUIRED)
    private Integer page;   //  当前页码
    @Schema(description = "每页展示的最大页数", example = "10", requiredMode = RequiredMode.REQUIRED)
    private Integer pageSize;   //  每页显示记录数
}

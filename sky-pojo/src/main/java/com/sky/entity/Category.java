package com.sky.entity;

import java.time.LocalDateTime;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
@Builder
@Schema(description = "分类实体类")
public class Category {
    @Schema(description = "主键", requiredMode = RequiredMode.NOT_REQUIRED)
    private Long id;
    @Schema(description = "类型", example = "1", requiredMode = RequiredMode.REQUIRED)
    private Integer type;
    @Schema(description = "名称", example = "川菜", requiredMode = RequiredMode.REQUIRED)
    private String name;
    @Schema(description = "排序", example = "1", requiredMode = RequiredMode.REQUIRED)
    private Integer sort;
    @Schema(description = "状态", example = "1", requiredMode = RequiredMode.REQUIRED)
    private Integer status;
    @Schema(description = "创建时间", example = "2023-04-25 10:00:00", requiredMode = RequiredMode.REQUIRED)
    private LocalDateTime createTime;
    @Schema(description = "更新时间", example = "2023-04-25 10:00:00", requiredMode = RequiredMode.REQUIRED)
    private LocalDateTime updateTime;
    @Schema(description = "创建人", example = "1", requiredMode = RequiredMode.REQUIRED)
    private Long createUser;
    @Schema(description = "修改人", example = "1", requiredMode = RequiredMode.REQUIRED)
    private Long updateUser;
}

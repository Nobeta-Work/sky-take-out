package com.sky.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Schema(description = "分类查询条件类")
public class CategoryDTO {
    @Schema(description = "主键", example = "1", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    private Long id;
    @Schema(description = "名称", example = "川菜", requiredMode = Schema.RequiredMode.REQUIRED)
    private String name;
    @Schema(description = "排序", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
    private Integer sort;
    @Schema(description = "状态", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
    private Integer type;
}

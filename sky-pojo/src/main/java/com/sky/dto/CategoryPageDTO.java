package com.sky.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Schema(description = "分类管理分页查询请求类")
public class CategoryPageDTO {
    @Schema(description = "分类名称", example = "川菜", requiredMode = Schema.RequiredMode.NOT_REQUIRED )
    private String name;
    @Schema(description = "分类状态", example = "1", requiredMode = Schema.RequiredMode.REQUIRED )
    private Integer page;
    @Schema(description = "分类状态", example = "10", requiredMode = Schema.RequiredMode.REQUIRED )
    private Integer pageSize;
    @Schema(description = "分类状态", example = "1", requiredMode = Schema.RequiredMode.NOT_REQUIRED )
    private Integer type;
}

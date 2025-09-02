package com.sky.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "员工登录响应实体类")
public class EmployeeLoginVO {
    @Schema(description = "员工id", example = "1", requiredMode = Schema.RequiredMode.NOT_REQUIRED, format = "int64")
    private Long id;
    @Schema(description = "用户名", example = "admin", requiredMode = Schema.RequiredMode.REQUIRED)
    private String userName;
    @Schema(description = "员工姓名", example = "伊蕾娜", requiredMode = Schema.RequiredMode.REQUIRED)
    private String name;
    @Schema(description = "token", requiredMode = Schema.RequiredMode.REQUIRED)
    private String token;
}

package com.sky.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "员工登录请求实体类")
public class EmployeeLoginDTO {
    @Schema(
        description = "用户名",
        example = "admin",
        requiredMode = Schema.RequiredMode.REQUIRED
    )
    private String username;
    @Schema(description = "密码", example = "123456", requiredMode = Schema.RequiredMode.REQUIRED)
    private String password;
}

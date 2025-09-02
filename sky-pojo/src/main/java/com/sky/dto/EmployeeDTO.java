package com.sky.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import lombok.Data;

@Data
@Schema(description = "员工请求实体类")
public class EmployeeDTO {
    @Schema(description = "员工id", example = "1", requiredMode = Schema.RequiredMode.NOT_REQUIRED, format = "int64")
    private Long id;
    @Schema(description = "用户名", example = "admin", requiredMode = Schema.RequiredMode.REQUIRED)
    private String username;
    @Schema(description = "员工姓名", example = "伊蕾娜", requiredMode = RequiredMode.REQUIRED)
    private String name;
    @Schema(description = "手机号", example = "13960034059", requiredMode = RequiredMode.REQUIRED)
    private String phone;
    @Schema(description = "性别", example = "1", requiredMode = RequiredMode.REQUIRED, allowableValues = {"0:女, 1:男"})
    private String sex;
    @Schema(description = "身份证号码", example = "35042520060307????", requiredMode = RequiredMode.REQUIRED)
    private String idNumber;
}

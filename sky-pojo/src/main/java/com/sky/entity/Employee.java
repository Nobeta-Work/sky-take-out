package com.sky.entity;

import java.time.LocalDateTime;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(description = "员工实体类")
public class Employee {
    @Schema(description = "主键", example = "1", requiredMode = Schema.RequiredMode.NOT_REQUIRED, format = "int64")
    private Long id;
    @Schema(description = "用户名", example = "admin", requiredMode = Schema.RequiredMode.REQUIRED)
    private String username;
    @Schema(description = "姓名", example = "伊蕾娜", requiredMode = Schema.RequiredMode.REQUIRED)
    private String name;
    @Schema(description = "密码", example = "123456", requiredMode = Schema.RequiredMode.REQUIRED)
    private String password;
    @Schema(description = "手机号", example = "13960034059", requiredMode = Schema.RequiredMode.REQUIRED)
    private String phone;
    @Schema(description = "性别", example = "1", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = {"0:女, 1:男"})
    private String sex;
    @Schema(description = "身份证号码", example = "35042520060307????", requiredMode = Schema.RequiredMode.REQUIRED)
    private String idNumber;
    @Schema(description = "状态", example = "1", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = {"0:禁用, 1:正常"})
    private Integer status;
    @Schema(description = "创建时间", example = "2023-04-25 10:00:00", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;
    @Schema(description = "更新时间", example = "2023-04-25 10:00:00", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime updateTime;
    @Schema(description = "创建人", example = "1", requiredMode = Schema.RequiredMode.REQUIRED, format = "int64")
    private Long createUser;
    @Schema(description = "修改人", example = "1", requiredMode = Schema.RequiredMode.REQUIRED, format = "int64")
    private Long updateUser;
}

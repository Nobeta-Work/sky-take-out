package com.sky.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sky.constant.JwtClaimsConstant;
import com.sky.dto.EmployeeDTO;
import com.sky.dto.EmployeeLoginDTO;
import com.sky.dto.EmployeePageQueryDTO;
import com.sky.entity.Employee;
import com.sky.properties.JwtProperties;
import com.sky.result.PageResult;
import com.sky.result.Result;
import com.sky.service.EmployeeService;
import com.sky.utils.JwtUtils;
import com.sky.vo.EmployeeLoginVO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping
@Slf4j  // 日志
@Tag(
    name = "EmployeeControllerAPI",
    description = "员工管理接口"
)
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private JwtProperties jwtProperties;

    /**
     * 登录
     * 
     * @param employeeLoginDTO
     * @return
     */
    @Operation(summary = "员工登录", description = "根据登录账户返回登录结果")
    @PostMapping("/login")
    public Result<EmployeeLoginVO> login(@RequestBody EmployeeLoginDTO employeeLoginDTO) {
        log.info("员工登录：{}", employeeLoginDTO);

        Employee employee = employeeService.login(employeeLoginDTO);

        // 登录成功，生成jwt令牌
        Map<String, Object> claims = new HashMap<>();
        claims.put(JwtClaimsConstant.EMP_ID, employee.getId());
        String token = JwtUtils.createJwt(
                jwtProperties.getAdminSecretKey(),
                jwtProperties.getAdminTtl(),
                claims);

        EmployeeLoginVO employeeLoginVO = EmployeeLoginVO.builder()
                .id(employee.getId())
                .userName(employee.getUsername())
                .name(employee.getName())
                .token(token)
                .build();
        return Result.success(employeeLoginVO);
    }

    /**
     * 分页查询
     */
    @Operation(
        summary = "分页查询",
        description = "根据查询条件分页查询员工信息"
    )
    @GetMapping("/admin/employee/page")
    public Result<PageResult<Employee>> page(EmployeePageQueryDTO employeePageQueryDTO) {
        log.info("分页查询：{}", employeePageQueryDTO);
        PageResult<Employee> pageResult = employeeService.pageQuery(employeePageQueryDTO);
        return Result.success(pageResult);
    }

    /**
     * 添加员工
     */
    @Operation(
        summary = "添加员工",
        description = "添加员工信息"
    )
    @PostMapping("/admin/employee")
    public Result<Employee> addEmployee(@RequestBody EmployeeDTO employeeDTO ) {
        log.info("添加员工：{}", employeeDTO);
        employeeService.addEmployee(employeeDTO);
        return Result.success();
    }

    /**
     * 启用禁用员工账号
     * @param status
     * @param id
     * @return
     */
    @Operation(
        summary = "启用禁用员工账号",
        description = "根据id启用禁用员工账号"
    )
    @PostMapping("/admin/employee/status/{status}")
    public Result<Void> updateStatus(@PathVariable Integer status, Long id) {
        log.info("启用禁用员工账号:{},{}", status, id);
        employeeService.updateStatus(status, id);
        return Result.success();
    }

    /**
     * 根据id查询员工信息
     * @param id
     * @return
     */
    @GetMapping("/admin/employee/{id}")
    @Operation(
        summary = "根据id查询员工信息",
        description = "根据id查询员工信息"
    )
    public Result<Employee> getById(@PathVariable Long id) {
        log.info("根据id查询员工信息：{}", id);
        Employee employee = employeeService.getById(id);
        return Result.success(employee);
    }

    /**
     * 编辑员工信息
     * @param employeeDTO
     * @return
     */
    @PutMapping("/admin/employee")
    @Operation(
        summary = "编辑员工信息",
        description = "编辑员工信息"
    )
    public Result<Void> updateById(@RequestBody EmployeeDTO employeeDTO) {
        log.info("编辑员工信息：{}", employeeDTO);
        employeeService.updateById(employeeDTO);
        return Result.success();
    }
}

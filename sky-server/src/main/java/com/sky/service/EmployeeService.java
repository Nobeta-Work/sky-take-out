package com.sky.service;



import com.sky.dto.EmployeeDTO;
import com.sky.dto.EmployeeLoginDTO;
import com.sky.dto.EmployeePageQueryDTO;
import com.sky.entity.Employee;
import com.sky.result.PageResult;


public interface EmployeeService {

    Employee login(EmployeeLoginDTO employeeLoginDTO);

    PageResult<Employee> pageQuery(EmployeePageQueryDTO employeePageQueryDTO);

    void addEmployee(EmployeeDTO employeeDTO);

    void updateStatus(Integer status, Long id);
    
}

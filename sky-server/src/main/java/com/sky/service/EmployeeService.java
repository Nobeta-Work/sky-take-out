package com.sky.service;

import org.springframework.stereotype.Service;

import com.sky.dto.EmployeeLoginDTO;
import com.sky.entity.Employee;

@Service
public interface EmployeeService {

    Employee login(EmployeeLoginDTO employeeLoginDTO);
    
}

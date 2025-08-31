package com.sky.service.impl;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import com.sky.constant.MessageConstant;
import com.sky.constant.StatusConstant;
import com.sky.dto.EmployeeLoginDTO;
import com.sky.entity.Employee;
import com.sky.exception.PasswordErrorException;
import com.sky.mapper.EmployeeMapper;
import com.sky.service.EmployeeService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeMapper employeeMapper;

    /**
     * 员工登录
     * 
     * @param employeeLoginDTO
     * @return
     */
    @Override
    public Employee login(EmployeeLoginDTO employeeLoginDTO) {
        String username = employeeLoginDTO.getUsername();
        String password = employeeLoginDTO.getPassword();

        // 1.根据用户名查询数据库中的数据
        Employee employee = employeeMapper.getByUsername(username);
        // 2.异常处理
        if (employee == null) {
            // 账号不存在
            throw new com.sky.exception.AccountNotFoundException(MessageConstant.ACCOUNT_NOT_FOUND);
        }
        // md5密码加密
        password = DigestUtils.md5DigestAsHex(password.getBytes());
        if (!password.equals(employee.getPassword())) {
            log.info("密码错误");
            // 密码错误
            throw new PasswordErrorException(MessageConstant.PASSWORD_ERROR);
        }

        if (employee.getStatus() == StatusConstant.DISABLE) {
            // 账号锁定
            throw new com.sky.exception.AccountLockedException(MessageConstant.ACCOUNT_LOCKED);
        }

        // 3.返回实体对象
        return employee;
    }
    
}

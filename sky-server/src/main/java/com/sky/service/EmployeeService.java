package com.sky.service;

import com.sky.dto.EmployeeDTO;
import com.sky.dto.EmployeeLoginDTO;
import com.sky.dto.EmployeePageQueryDTO;
import com.sky.dto.EmployeeUpdatePasswordDTO;
import com.sky.entity.Employee;
import com.sky.result.PageResult;

public interface EmployeeService {

    /**
     * 员工登录
     * @param employeeLoginDTO
     * @return
     */
    Employee login(EmployeeLoginDTO employeeLoginDTO);

    /**
     *
     * @param employeePageQueryDTO
     * @return
     */
    PageResult getEmployee(EmployeePageQueryDTO employeePageQueryDTO);

    int addEmployee(EmployeeDTO employeeDTO);

    int updatePassword(EmployeeUpdatePasswordDTO employeeUpdatePasswordDTO);

    /**
     * 根据id查询员工
     * @param id
     * @return
     */
    Employee getEmployeeById(Integer id);

    /**
     * 根据id修改用户
     * @param employee
     * @return
     */
    Integer editEmployeeById(Employee employee);
}

package com.sky.mapper;

import com.sky.dto.EmployeeDTO;
import com.sky.dto.EmployeeUpdatePasswordDTO;
import com.sky.entity.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface EmployeeMapper {

    /**
     * 根据用户名查询员工
     * @param username
     * @return
     */
    @Select("select * from employee where username = #{username}")
    Employee getByUsername(String username);

    int getTotal();

    List<Employee> getEmployee(@Param("name") String name, @Param("page") int page, @Param("pageSize") int pageSize);

    int addEmployee(EmployeeDTO employeeDTO);

    String getPassword(@Param("id") Long id);

    int updatePassword(EmployeeUpdatePasswordDTO employeeUpdatePasswordDTO);
}

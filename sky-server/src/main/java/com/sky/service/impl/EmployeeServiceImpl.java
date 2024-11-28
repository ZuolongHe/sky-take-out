package com.sky.service.impl;

import com.sky.constant.MessageConstant;
import com.sky.constant.StatusConstant;
import com.sky.dto.EmployeeDTO;
import com.sky.dto.EmployeeLoginDTO;
import com.sky.dto.EmployeePageQueryDTO;
import com.sky.dto.EmployeeUpdatePasswordDTO;
import com.sky.entity.Employee;
import com.sky.exception.AccountLockedException;
import com.sky.exception.AccountNotFoundException;
import com.sky.exception.PasswordErrorException;
import com.sky.mapper.EmployeeMapper;
import com.sky.result.PageResult;
import com.sky.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    /**
     * 员工登录
     *
     * @param employeeLoginDTO
     * @return
     */
    public Employee login(EmployeeLoginDTO employeeLoginDTO) {
        String username = employeeLoginDTO.getUsername();
        String password = employeeLoginDTO.getPassword();

        //1、根据用户名查询数据库中的数据
        Employee employee = employeeMapper.getByUsername(username);

        //2、处理各种异常情况（用户名不存在、密码不对、账号被锁定）
        if (employee == null) {
            //账号不存在
            throw new AccountNotFoundException(MessageConstant.ACCOUNT_NOT_FOUND);
        }

        //密码比对
        // TODO 后期需要进行md5加密，然后再进行比对
        password = DigestUtils.md5DigestAsHex(password.getBytes());
        if (!password.equals(employee.getPassword())) {
            //密码错误
            throw new PasswordErrorException(MessageConstant.PASSWORD_ERROR);
        }

        if (employee.getStatus() == StatusConstant.DISABLE) {
            //账号被锁定
            throw new AccountLockedException(MessageConstant.ACCOUNT_LOCKED);
        }

        //3、返回实体对象
        return employee;
    }

    /**
     * 分页查询员工数据
     * @param employeePageQueryDTO
     * @return
     */
    @Override
    public PageResult getEmployee(EmployeePageQueryDTO employeePageQueryDTO) {
        String name = employeePageQueryDTO.getName();
        int pageSize = employeePageQueryDTO.getPageSize();
        int page = (employeePageQueryDTO.getPage() - 1) * pageSize;
        int total = employeeMapper.getTotal();
        List<Employee> employees = employeeMapper.getEmployee(name, page, pageSize);
        PageResult pageResult = new PageResult(total, employees);
        return pageResult;
    }

    /**
     * 添加新员工信息
     * @param employeeDTO
     * @return
     */
    @Override
    public int addEmployee(EmployeeDTO employeeDTO) {
        int num = employeeMapper.addEmployee(employeeDTO);
        return num;
    }


    /**
     * 修改员工密码
     * @param employeeUpdatePasswordDTO
     * @return
     */
    @Override
    public int updatePassword(EmployeeUpdatePasswordDTO employeeUpdatePasswordDTO) {
        // 1. 对oldPassword与源密码进行md5加密
        String oldPassword = employeeUpdatePasswordDTO.getOldPassword();
        employeeUpdatePasswordDTO.setOldPassword(DigestUtils.md5DigestAsHex(oldPassword.getBytes()));
        String newPassword = employeeUpdatePasswordDTO.getNewPassword();
        employeeUpdatePasswordDTO.setNewPassword(DigestUtils.md5DigestAsHex(newPassword.getBytes()));
        // 2. 根据当前用户id查询用户密码
        Long id = employeeUpdatePasswordDTO.getId();
        String password = employeeMapper.getPassword(id);
        // 3. 校验旧密码是否与输入oldPassword一致
        if (password.equals(employeeUpdatePasswordDTO.getOldPassword())){
            // 一致，执行密码修改
            int num = employeeMapper.updatePassword(employeeUpdatePasswordDTO);
            return num;
        }else {
            // 不一致，密码错误抛出异常
            throw new PasswordErrorException(MessageConstant.PASSWORD_ERROR);
        }

    }

}

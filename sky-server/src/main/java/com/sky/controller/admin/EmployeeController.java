package com.sky.controller.admin;

import com.sky.constant.JwtClaimsConstant;
import com.sky.dto.EmployeeDTO;
import com.sky.dto.EmployeeLoginDTO;
import com.sky.dto.EmployeePageQueryDTO;
import com.sky.dto.EmployeeUpdatePasswordDTO;
import com.sky.entity.Employee;
import com.sky.properties.JwtProperties;
import com.sky.result.PageResult;
import com.sky.result.Result;
import com.sky.service.EmployeeService;
import com.sky.utils.JwtUtil;
import com.sky.vo.EmployeeLoginVO;
import io.jsonwebtoken.Claims;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 员工管理
 */
@RestController
@RequestMapping("/admin/employee")
@Slf4j
@Api(tags = "员工相关接口")
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
    @PostMapping("/login")
    @ApiOperation(value = "登录方法")
    public Result<EmployeeLoginVO> login(@RequestBody EmployeeLoginDTO employeeLoginDTO) {
        log.info("员工登录：{}", employeeLoginDTO);

        Employee employee = employeeService.login(employeeLoginDTO);

        //登录成功后，生成jwt令牌
        Map<String, Object> claims = new HashMap<>();
        claims.put(JwtClaimsConstant.EMP_ID, employee.getId());
        String token = JwtUtil.createJWT(
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
     * 分页查询所有员工数据
     */
    @GetMapping("/page")
    @ApiOperation("分页查询员工数据")
    public Result<PageResult> getEmployee(EmployeePageQueryDTO employeePageQueryDTO){
        PageResult pageResult = employeeService.getEmployee(employeePageQueryDTO);
        return Result.success(pageResult);
    }

    /**
     * 增加新员工数据
     * @return
     */
    @PostMapping
    public Result addEmployee(@RequestBody EmployeeDTO employeeDTO){
        log.info("EmployeeDTO{}", employeeDTO.toString());
        int num = employeeService.addEmployee(employeeDTO);
        log.info("插入数据{}", num);
        return Result.success();
    }

    /**
     * 修改员工密码
     * @return Result
     */
    @PutMapping("/editPassword")
    public Result updatePassword(@RequestBody EmployeeUpdatePasswordDTO employeeUpdatePasswordDTO, HttpServletRequest request){
        // 获取请求中的 token
        String token = request.getHeader("token");
        log.info("获取token:{}",token);
        // 解析token
        Claims claims = JwtUtil.parseJWT(jwtProperties.getAdminSecretKey(), token);
        Long empId = Long.valueOf(claims.get(JwtClaimsConstant.EMP_ID).toString());
        log.info("解析后的员工id：{}",empId);
        employeeUpdatePasswordDTO.setId(empId);
        log.info("修改密码传输数据模型：{}", employeeUpdatePasswordDTO);
        int num = employeeService.updatePassword(employeeUpdatePasswordDTO);
        log.info("更改数据：{}", num);
        return Result.success();
    }


    /**
     * 退出
     *
     * @return
     */
    @PostMapping("/logout")
    @ApiOperation(value = "退出方法")
    public Result<String> logout() {
        return Result.success();
    }

}

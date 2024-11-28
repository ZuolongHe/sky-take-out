package com.sky.dto;

import lombok.Data;

/**
 * @Title sky-take-out
 * @Author hzl
 * @Date 2024/11/27 21:52
 * @Description
 */
@Data
public class EmployeeUpdatePasswordDTO {

    private Long id;
    private String newPassword;
    private String oldPassword;
}

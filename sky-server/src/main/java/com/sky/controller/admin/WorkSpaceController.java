package com.sky.controller.admin;

import com.sky.result.Result;
import com.sky.service.WorkSpace;
import com.sky.vo.BusinessDataVO;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Title sky-take-out
 * @Author hzl
 * @Date 2024/12/1 14:28
 * @Description 工作台接口
 */
@RestController
@Slf4j
@RequestMapping("/admin/workspace")
@Api(tags = "工作台接口")
public class WorkSpaceController {

    @Autowired
    private WorkSpace workSpace;

    /**
     * 获取今营业额数据
     * @return
     */
    @GetMapping("/businessData")
    public Result<BusinessDataVO> getBusinessData(){
        BusinessDataVO businessData = workSpace.getBusinessData();
        return Result.success(businessData);
    }
}

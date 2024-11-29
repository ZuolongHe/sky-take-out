package com.sky.controller.admin;

import com.sky.exception.BaseException;
import com.sky.result.Result;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @Title sky-take-out
 * @Author hzl
 * @Date 2024/11/29 11:51
 * @Description
 */
@RestController
@RequestMapping("/admin/common")
@Slf4j
@Api("公共接口")
public class CommonController {

    /**
     * 文件上传
     * @param file
     * @return
     */
    @PostMapping("/upload")
    public Result<String> uploadFile(MultipartFile file) throws IOException {
        if (file.isEmpty()){
            throw new BaseException("文件为空！");
        }
        String originalFilename = file.getOriginalFilename();
        // 给文件命名
        String newFileName = UUID.randomUUID().toString() + originalFilename.substring(originalFilename.lastIndexOf("."));
        // 文件暂存磁盘
        file.transferTo(new File("C:\\Users\\drago\\Desktop\\localImage\\test\\" + newFileName));
        log.info("file:{}", newFileName);
        return Result.success(newFileName);
    }
}

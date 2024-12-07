package com.sky.service;

import com.sky.vo.BusinessDataVO;

/**
 * @Title sky-take-out
 * @Author hzl
 * @Date 2024/12/1 14:36
 * @Description
 */
public interface WorkSpace {

    /**
     * 获取今日营业额数据
     * @return
     */
    BusinessDataVO getBusinessData();
}

package com.xiu.followdouban.commonwebapi.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.xiu.followdouban.commonrpc.service.DubboDemoService;
import org.springframework.stereotype.Component;

/**
 * author   xieqx
 * createTime  2018/12/25
 * desc 一句话描述该功能
 */
@Component
@Service(version = "1.0.0",interfaceClass = DubboDemoService.class)
public class DemoService  implements DubboDemoService{


    @Override
    public String dubboTest(String keyword) {
        return "dubbo demo";
    }
}

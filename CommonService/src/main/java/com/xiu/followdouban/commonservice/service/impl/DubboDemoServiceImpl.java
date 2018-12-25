package com.xiu.followdouban.commonservice.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.xiu.followdouban.commonrpc.service.DubboDemoService;
import org.springframework.stereotype.Component;

@Service
@Component
public class DubboDemoServiceImpl implements DubboDemoService {
    @Override
    public String dubboTest(String keyword) {
        return "this is dubbo demo test, recivce info "+keyword;
    }
}
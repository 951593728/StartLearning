package com.prectise.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.precties.service.TestService;

@Service
public class TestServiceImpl implements TestService {
    @Override
    public String getData() {
        return "提供服务";
    }
}

package com.prectise.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.precties.service.TestService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Reference
    private TestService testService;

    @RequestMapping("/getData")
    public String getData(){
        return testService.getData();
    }

}

package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient//服务发现，非重点，就是可以查看服务信息
@EnableCircuitBreaker//开启熔断hystrics
public class DeptProvider8001_Hystrix_App
{
    public static void main( String[] args )
    {
        SpringApplication.run(DeptProvider8001_Hystrix_App.class,args);
    }
}

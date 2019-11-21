package com.atguigu.springcloud.cfgbeans;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RetryRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration//写这个注解相当于这个类就是spring的配置文件application.xml
public class ConfigBean {


    @Bean
    @LoadBalanced//开启负载均衡
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    //更换负载均衡算法，默认为轮循，现在改为其他的算法
    @Bean
    public IRule myrule(){
        return new RandomRule();//随机
        //return new RoundRobinRule();//轮循
       // return new RetryRule();//先轮循，遇到挂掉的服务就不再去调用它
    }
}

//@Bean
//public UserServcie getUserServcie()
//{
//	return new UserServcieImpl();
//}

//和上边的效果一样
// applicationContext.xml == ConfigBean(@Configuration)
//<bean id="userServcie" class="com.atguigu.tmall.UserServiceImpl">
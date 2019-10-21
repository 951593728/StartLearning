package com.example.springboot_rabbitmq.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Lisetner {

    @RabbitListener(queues = "atguigu.news")
    void service(String message){
        System.out.println(message);
    }

}

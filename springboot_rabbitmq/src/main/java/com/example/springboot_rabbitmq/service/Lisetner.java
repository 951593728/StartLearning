package com.example.springboot_rabbitmq.service;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Lisetner {

    @RabbitListener(queues = "atguigu.news")
    void service(String message){
        System.out.println(message);
    }
    //可以拿到消息头和消息内容
    @RabbitListener(queues = "atguigu.news")
    void service1(Message message){


        System.out.println(message.getBody());
        System.out.println(message.getMessageProperties());
    }

}

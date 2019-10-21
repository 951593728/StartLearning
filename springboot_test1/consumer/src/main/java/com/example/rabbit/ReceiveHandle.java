package com.example.rabbit;

import com.example.config.RabbitMqConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import sun.plugin2.message.Message;

import java.nio.channels.Channel;

@Component
public class ReceiveHandle {


    @RabbitListener(queues = {RabbitMqConfig.QUEEN_INFORM_EMAIL})
    public void receive_email(String msg, Message message, Channel channel){
        System.out.println("拿到的消息是："+msg);


    }

}

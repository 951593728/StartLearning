package com.example.springboot_rabbitmq;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Arrays;
import java.util.HashMap;

@SpringBootTest
class SpringbootRabbitmqApplicationTests {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Test
    void contextLoads() {
        //自定义消息内容和消息头
        //String msg="";
        //rabbitTemplate.send("exchange.direct","atguigu",msg);

        //只需要传入要发送的对象，自动序列话
        //直接对话，必须完全匹配路邮件
        HashMap<String, Object> map = new HashMap<>();
        map.put("西游记", "吴承恩");
        map.put("msg", Arrays.asList("hello", "list"));
        rabbitTemplate.convertAndSend("exchange.direct", "atguigu", map);
    }

    @Test
    void contextLoads1() {

        //只需要传入要发送的对象，自动序列话
        rabbitTemplate.convertAndSend("exchange.fanout", "", "messag fanout");
    }


    @Test
    void receive() {
        //要接收的使queue名字为atguigu的队列的消息
        Object o = rabbitTemplate.receiveAndConvert("atguigu");
        System.out.println(o.getClass());
        System.out.println(o);

    }

    @Autowired
    AmqpAdmin amqpAdmin;

    @Test
    public void creatExchange() {
//        amqpAdmin.declareExchange(new DirectExchange("amqpAdmin.Exchange"));
//
        amqpAdmin.declareQueue(new Queue("amqp.queue",true));

        amqpAdmin.declareBinding(new Binding("amqp.queue",Binding.DestinationType.QUEUE,
                "amqpAdmin.Exchange","amqp.news",null));

    }
}

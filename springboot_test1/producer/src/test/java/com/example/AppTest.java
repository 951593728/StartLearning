package com.example;

import com.example.config.RabbitMqConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Unit test for simple App.
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class AppTest 
    {
        @Autowired
        RabbitTemplate rabbitTemplate;

        @Test
        public void testSendEmail(){
            String meg="send email to user";
            //参数名称：
            //exchange
            //routingkey
            //消息
            rabbitTemplate.convertAndSend(RabbitMqConfig.EXCHANGE_TOPICS_INFORM,"routingkey_email",meg);
        }

    }

package com.example.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {

    public static final String QUEEN_INFORM_EMAIL="queen_inform_email";
    public static final String QUEEN_INFORM_SMS="queen_inform_sms";
    public static final String EXCHANGE_TOPICS_INFORM="exchange_topics_inform";
    public static final String ROUTINGKEY_EMAIL="routingkey_email";
    public static final String ROUTINGKEY_SMS="routingkey_sms";

    //声明交换机
    @Bean(EXCHANGE_TOPICS_INFORM)
    public Exchange EXCHANGE_TOPICS_INFORM(){
        return ExchangeBuilder.topicExchange(EXCHANGE_TOPICS_INFORM).durable(true).build();
    }

    //声明队列
    @Bean(QUEEN_INFORM_EMAIL)
    public Queue QUEEN_INFORM_EMAIL(){
        return new Queue(QUEEN_INFORM_EMAIL);
    }

    @Bean(QUEEN_INFORM_SMS)
    public Queue QUEEN_INFORM_SMS(){
        return new Queue(QUEEN_INFORM_SMS);
    }


    //队列绑定交换机
    @Bean
    public Binding BINDING_QUEEN_INFORM_SMS(@Qualifier(QUEEN_INFORM_SMS) Queue queue,
                                            @Qualifier(EXCHANGE_TOPICS_INFORM) Exchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with(ROUTINGKEY_SMS).noargs();
    }

    //队列绑定交换机
    @Bean
    public Binding BINDING_QUEEN_INFORM_EMAIL(@Qualifier(QUEEN_INFORM_EMAIL) Queue queue,
                                            @Qualifier(EXCHANGE_TOPICS_INFORM) Exchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with(ROUTINGKEY_EMAIL).noargs();
    }



}

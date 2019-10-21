package com.example;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * Hello world!
 *
 */
@EnableRabbit
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class AppConsumer
{
    public static void main( String[] args )
    {
        SpringApplication.run(AppConsumer.class,args);
    }
}

package com.example.artistsservice.configuration;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitMQSender {
    @Value("${queue.artist.name}")
    private String artistQueue;

    @Bean
    public Queue queue() {
        return new Queue(this.artistQueue, false);
    }
}

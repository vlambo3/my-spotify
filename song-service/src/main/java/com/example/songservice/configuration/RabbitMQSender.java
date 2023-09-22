package com.example.songservice.configuration;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQSender {
    @Value("${queue.song.name}")
    private String songQueue;

    @Bean
    public Queue queue() {
        return new Queue(songQueue);
    }
}

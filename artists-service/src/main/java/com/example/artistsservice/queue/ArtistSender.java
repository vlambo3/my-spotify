package com.example.artistsservice.queue;

import com.example.artistsservice.model.Artist;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ArtistSender {
    private final RabbitTemplate rabbitTemplate;
    private final Queue artistQueue;

    public void send(Artist artist) {
        this.rabbitTemplate.convertAndSend(this.artistQueue.getName(), artist);
    }
}

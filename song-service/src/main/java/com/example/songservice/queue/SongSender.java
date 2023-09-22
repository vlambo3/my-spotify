package com.example.songservice.queue;

import com.example.songservice.domain.model.Song;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SongSender {
    private final RabbitTemplate rabbitTemplate;
    private final Queue songQueue;

    public void send(Song song) {
        rabbitTemplate.convertAndSend(songQueue.getName(), song);
    }

}

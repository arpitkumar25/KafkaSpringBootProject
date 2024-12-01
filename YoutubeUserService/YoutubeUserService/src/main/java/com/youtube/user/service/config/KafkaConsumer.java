package com.youtube.user.service.config;

import com.youtube.user.service.entities.YoutubeChannel;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {

    @KafkaListener(topics = Topic.TopicName,
            groupId = "group_1",
            containerFactory = "YoutubeChannelListener")
    public void consume(YoutubeChannel youtubeChannel)
    {
        // Print statement
        System.out.println("message = " + youtubeChannel.getChannelId()+":"+youtubeChannel.getVideoName());
    }
}

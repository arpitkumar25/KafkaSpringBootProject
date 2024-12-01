package com.youtube.channel.service.service;

import com.youtube.channel.service.config.Topics;
import com.youtube.channel.service.entities.Youtubechannel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaService {

    @Autowired
    KafkaTemplate<String,Youtubechannel> kafkaTemplate;

    //To produce the message
    public boolean sendYouTubeChannelMessage(Youtubechannel youtubechannel)
    {
        kafkaTemplate.send(Topics.topicname,youtubechannel);
        return true;
    }

}

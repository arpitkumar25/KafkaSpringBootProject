package com.youtube.channel.service.controllers;

import com.youtube.channel.service.YoutubeChannelServiceApplication;
import com.youtube.channel.service.entities.Youtubechannel;
import com.youtube.channel.service.service.KafkaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/youtubechannelvideos")
public class YoutubeChannelController {

    @Autowired
    public KafkaService kafkaService;

    @PostMapping("/update")
    public ResponseEntity<Youtubechannel> updateYoutubeChannel(@RequestBody Youtubechannel youtubechannel)
    {
        kafkaService.sendYouTubeChannelMessage(youtubechannel);
        return  ResponseEntity.ok(youtubechannel);
    }
}

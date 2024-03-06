package com.mqtt.broker.api.controller;


import com.mqtt.broker.api.service.MsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/message")
public class MsgController {


    @Autowired
    private MsgService messageService;

    @GetMapping
    public ResponseEntity<String> sendMessage(
            @RequestParam String message) {
        messageService.publish(message);
        return ResponseEntity.ok("Message sent to MQTT broker: " + message);
    }
}

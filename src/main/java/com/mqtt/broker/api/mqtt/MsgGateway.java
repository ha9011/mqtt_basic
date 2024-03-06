package com.mqtt.broker.api.mqtt;

import org.springframework.integration.annotation.MessagingGateway;

@MessagingGateway(defaultRequestChannel = "mqttOutboundChannel")
public interface MsgGateway {
    void sendToMqtt(String message);
}

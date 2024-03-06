package com.mqtt.broker.api.mqtt;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.mqtt.outbound.MqttPahoMessageHandler;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHandler;

// Spring Integration 구성
@Configuration
@EnableIntegration
public class IntegrationConfig {
/*
    @Value("${mqtt.brokerUrl}")
    private String brokerUrl;

    @Bean
    public MessageChannel mqttOutboundChannel() {
        return new DirectChannel();
    }

    @Bean
    @ServiceActivator(inputChannel = "mqttOutboundChannel")
    public MessageHandler mqttOutbound() {
        MqttPahoMessageHandler messageHandler = new MqttPahoMessageHandler("clientId", new DefaultMqttClientFactory());
        messageHandler.setAsync(true);
        messageHandler.setDefaultTopic("yourTopic");
        messageHandler.setUrl(brokerUrl);
        return messageHandler;
    }*/
}
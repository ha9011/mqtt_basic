package com.mqtt.broker.api.service;

import com.mqtt.broker.api.mqtt.MsgGateway;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.paho.client.mqttv3.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class MsgService implements MqttCallback {
    // application.properties 파일에서 mqtt.broker.host 항목의 값
    private String host = "localhost";

    // application.properties 파일에서 mqtt.broker.port 항목의 값
    private int port = 1883;

    private MqttClient client;

    @PostConstruct
    public void connect(){
        String serverURI = getURI();
        String uuid = UUID.randomUUID().toString();

        System.out.println("MQTT Broker Server : "+serverURI);
        System.out.println("UUID : "+uuid);

        MqttConnectOptions option = new MqttConnectOptions();
        option.setCleanSession(true);

        try {
            client = new MqttClient(serverURI, uuid);
            client.setCallback(this);
            client.connect(option);
        } catch(MqttException e){
            System.out.println("MQTT connection error");
        }
    }

    public String getURI(){
        return "tcp://"+host+":"+String.valueOf(port);
    }

    public String publish(String msg){
        System.out.println("Message is " + msg);

        MqttMessage message = new MqttMessage();
        try {
            message.setPayload(msg.getBytes("UTF-8"));
            client.publish("/test", message);
        } catch(Exception e){
            System.out.println(e.getMessage());
        }

        return msg;
    }

    @Override
    public void connectionLost(Throwable cause) {
    }

    @Override
    public void messageArrived(String s, MqttMessage mqttMessage) throws Exception {

    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {

    }

}
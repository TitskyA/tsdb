package com.example.demo.mqtt;

import org.eclipse.paho.client.mqttv3.IMqttToken;
import org.eclipse.paho.client.mqttv3.MqttAsyncClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;

import java.util.UUID;

public class MqttClass {
    static String broker = "tcp://127.0.0.1:1883";
    public static void getConnect(String topic) throws MqttException {

        MqttAsyncClient client = new MqttAsyncClient(broker, UUID.randomUUID().toString());
        MqttConnectOptions mqOptions = new MqttConnectOptions();
        SimpleMqttCallBack callBack = new SimpleMqttCallBack();
        client.setCallback(callBack);

        IMqttToken token = client.connect(mqOptions);
        token.waitForCompletion();
        client.subscribe(topic, 0);

    }
}

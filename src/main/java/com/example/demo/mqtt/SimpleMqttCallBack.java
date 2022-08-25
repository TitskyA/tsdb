package com.example.demo.mqtt;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class SimpleMqttCallBack implements MqttCallback {
    static String stringMes;
    static BigDecimal[] mms = new BigDecimal[4];

    public void connectionLost(Throwable throwable) {
        System.out.println("ConnectionLost");
    }

    public void messageArrived(String topic, MqttMessage message) throws Exception {
        stringMes = new String(message.getPayload());
        stringMes = stringMes.replaceAll("[^0-9.,]", "");
        String[] meas = stringMes.split(",");
        for (int i=0; i<mms.length; i++){
            mms[i] = new BigDecimal(meas[i]);
            mms[i] = mms[i].setScale(3, RoundingMode.DOWN);
        }
    }

    public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {
        // not used in this example
    }

    public static BigDecimal[] getMms() {
        return mms;
    }
}

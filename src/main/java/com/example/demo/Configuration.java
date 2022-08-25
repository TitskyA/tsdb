package com.example.demo;

import com.example.demo.mqtt.SimpleMqttCallBack;
import com.influxdb.client.InfluxDBClient;
import com.influxdb.client.InfluxDBClientFactory;
import com.influxdb.client.QueryApi;
import com.influxdb.client.WriteApiBlocking;
import org.eclipse.paho.client.mqttv3.IMqttToken;
import org.eclipse.paho.client.mqttv3.MqttAsyncClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.util.UUID;

@SpringBootConfiguration
@ComponentScan(basePackages = "com.example.demo")
public class Configuration {

    final String databaseUrl = "http://localhost:8086";
    final String token = "_ifO-4UUrNqRxSI1uH22jLXmOZQNjSW9mFWX5dSgDHEwNJgXBQUXhDeeRrxs056fNYQ6HvNiU0ZTOlxJ28EDkw==";
    final String bucket = "tsdb";
    final String org = "Test1";
    final String databaseUser = "root";
    final String databasePassword = "rootroot";

    final String broker = "tcp://127.0.0.1:1883";

    @Bean
    public WriteApiBlocking writeApiBlocking() {
        InfluxDBClient client = InfluxDBClientFactory.create(databaseUrl, token.toCharArray());
        WriteApiBlocking writeApi = client.getWriteApiBlocking();
        return writeApi;
    }

    @Bean
    public QueryApi queryApi() {
        QueryApi queryApi = InfluxDBClientFactory.create(databaseUrl, token.toCharArray()).getQueryApi();
        return queryApi;
    }

}

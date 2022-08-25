package com.example.demo.controller;

import com.example.demo.model.Assessment;
import com.example.demo.mqtt.MqttClass;
import com.example.demo.mqtt.SimpleMqttCallBack;
import com.example.demo.service.AssessmentService;
import com.example.demo.service.AssessmentServiceImpl;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

@RestController
public class AssessmentController {

    private final AssessmentService assessmentService;

    public AssessmentController(AssessmentServiceImpl assessmentService) {
        this.assessmentService = assessmentService;
    }

    /**
     * Контроллер, который снимает показания с матлаба,
     * записывает их и базу и возвращает только что снятое показание указанного топика
     */

    @GetMapping("/{topic}")
    public Assessment takeStatementAndShow(@PathVariable("topic") String topic) throws MqttException {
        MqttClass.getConnect(topic);
        BigDecimal[] mes = SimpleMqttCallBack.getMms();
        Assessment assessment = new Assessment(topic, mes[0], mes[1], mes[2], Instant.now());
        assessmentService.save(assessment);
        return assessment;
    }


}

package com.example.demo.service;

import com.example.demo.model.Assessment;
import com.example.demo.repository.AssessmentRepository;
import com.example.demo.repository.AssessmentRepositoryImpl;
import com.influxdb.client.domain.WritePrecision;
import com.influxdb.client.write.Point;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AssessmentServiceImpl implements AssessmentService{

    private long count;

    final AssessmentRepository assessmentRepository;

    public AssessmentServiceImpl(AssessmentRepositoryImpl assessmentRepository) {
        this.assessmentRepository = assessmentRepository;
    }


    @Override
    public void save(Assessment assessment) {
        Point point = Point
                .measurement("измерение-" + assessment.getTopic())
                .addTag("topic", assessment.getTopic())
                .addField("frequency", assessment.getFrequency())
                .addField("power", assessment.getPower())
                .addField("electricity", assessment.getElectricity())
                .time(assessment.getTime(), WritePrecision.NS);

        assessmentRepository.save(point);
        count++;
    }

    @Override
    public void saveAll(List<Assessment> assessments) {
        List<Point> points = new ArrayList<>();

        for (Assessment assessment: assessments) {
            points.add(Point
                    .measurement("измерение-" + assessment.getTopic())
                    .addTag("topic", assessment.getTopic())
                    .addField("frequency", assessment.getFrequency())
                    .addField("power", assessment.getPower())
                    .addField("electricity", assessment.getElectricity())
                    .time(assessment.getTime(), WritePrecision.NS));
        }

        assessmentRepository.saveAll(points);
    }
}

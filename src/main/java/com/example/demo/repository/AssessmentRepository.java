package com.example.demo.repository;

import com.example.demo.model.Assessment;
import com.influxdb.client.write.Point;

import java.util.List;

public interface AssessmentRepository {

    void save(Point point);

    void saveAll(List<Point> points);

}

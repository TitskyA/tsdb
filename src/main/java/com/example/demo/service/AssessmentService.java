package com.example.demo.service;

import com.example.demo.model.Assessment;

import java.util.List;

public interface AssessmentService {

    void save(Assessment assessment);

    void saveAll(List<Assessment> assessments);
}

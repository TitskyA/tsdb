package com.example.demo;

import com.example.demo.model.Assessment;
import com.example.demo.repository.AssessmentRepositoryImpl;
import com.example.demo.service.AssessmentServiceImpl;
import com.influxdb.client.domain.WritePrecision;
import com.influxdb.client.write.Point;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@ContextConfiguration(classes = Configuration.class)
class DemoApplicationTests {

	@Autowired
	AssessmentServiceImpl assessmentService;

	@Autowired
	AssessmentRepositoryImpl assessmentRepository;

	@Test
	public void saveTest() throws InterruptedException {
		Assessment assessment1 = new Assessment("Topic-1", 50D, 150D, 150D, Instant.now());
		Assessment assessment2 = new Assessment("Topic-2", 50D, 160D, 150D, Instant.now().plusMillis(10000));
		Assessment assessment3 = new Assessment("Topic-3", 50D, 170D, 150D, Instant.now().plusMillis(20000));

		List<Assessment> assessments = new ArrayList<>();
		assessments.add(assessment1);
		assessments.add(assessment2);
		assessments.add(assessment3);

		assessmentService.saveAll(assessments);
	}

}

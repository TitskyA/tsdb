package com.example.demo.repository;

import com.example.demo.model.Assessment;
import com.influxdb.client.QueryApi;
import com.influxdb.client.WriteApiBlocking;
import com.influxdb.client.domain.WritePrecision;
import com.influxdb.client.write.Point;
import com.influxdb.query.FluxTable;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public class AssessmentRepositoryImpl implements AssessmentRepository {

    final WriteApiBlocking writeApiBlocking;
    private final QueryApi queryApi;

    public AssessmentRepositoryImpl(WriteApiBlocking writeApiBlocking, QueryApi queryApi) {
        this.writeApiBlocking = writeApiBlocking;
        this.queryApi = queryApi;
    }


    @Override
    public void save(Point point) {
        writeApiBlocking.writePoint("tsdb", "Test1", point);
    }

    @Override
    public void saveAll(List<Point> points) {
        writeApiBlocking.writePoints("tsdb", "Test1", points);
    }
}

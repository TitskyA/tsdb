package com.example.demo.model;


import com.influxdb.annotations.Column;
import com.influxdb.annotations.Measurement;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.Instant;
@AllArgsConstructor
@ToString
@Getter
@Measurement(name="assessment")
public class Assessment {

    @Column(tag = true)
    private String topic;

    @Column
    private BigDecimal frequency;

    @Column
    private BigDecimal power;

    @Column
    private BigDecimal electricity;

    @Column
    private Instant time;

}




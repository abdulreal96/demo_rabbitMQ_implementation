package com.abdulreal.messaging.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.context.annotation.Bean;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Asset {

    private String id;
    private String coinName;
    private String symbol;
    private double dailyPerformance;
    private double marketCap;
    private double dailyVolume;
}

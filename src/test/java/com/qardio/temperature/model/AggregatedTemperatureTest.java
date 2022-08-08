package com.qardio.temperature.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class AggregatedTemperatureTest implements AggregatedTemperature{
    private BigDecimal min;
    private BigDecimal max;
    private BigDecimal avg;
    private String timeInterval;
}

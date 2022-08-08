package com.qardio.temperature.model;

import java.math.BigDecimal;

/**
 * Class for aggregated temperature information
 */
public interface AggregatedTemperature {
    BigDecimal getMin();
    BigDecimal getMax();
    BigDecimal getAvg();
    String getTimeInterval();
    void setMin(BigDecimal minValue);
    void setMax(BigDecimal minValue);
    void setAvg(BigDecimal minValue);
    void setTimeInterval(String timeInterval);
}

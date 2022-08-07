package com.qardio.temperature.service;

import com.qardio.temperature.model.AggregatedTemperature;
import com.qardio.temperature.model.FrequencyType;
import com.qardio.temperature.model.TemperatureRecord;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Service interface for temperature operation
 */
public interface TemperatureService {


    /**
     * Get aggregatedTemperature/s by given parameters
     * @param startDateTime start date criteria
     * @param endDateTime end date criteria
     * @param frequencyType daily or hourly
     * @return list of AggregatedTemperature
     */
    List<AggregatedTemperature> getAggregatedTemperatureByCriteria(LocalDateTime startDateTime, LocalDateTime endDateTime, FrequencyType frequencyType);


    /**
     * Save temperatureRecord by the object parameter
     * @param temperatureRecordList list of TemperatureRecord to save
     * @return list of TemperatureRecord
     */
    List<TemperatureRecord> saveTemperatureRecord(List<TemperatureRecord> temperatureRecordList);


}

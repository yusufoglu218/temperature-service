package com.qardio.temperature.service;

import com.qardio.temperature.model.AggregatedTemperature;
import com.qardio.temperature.model.FrequencyType;
import com.qardio.temperature.model.TemperatureRecord;
import com.qardio.temperature.repository.TemperatureRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
public class TemperatureServiceImpl implements TemperatureService{

    private TemperatureRepository temperatureRepository;

    public TemperatureServiceImpl(TemperatureRepository temperatureRepository) {
        this.temperatureRepository = temperatureRepository;
    }

    @Override
    public List<AggregatedTemperature> getAggregatedTemperatureByCriteria(LocalDateTime startDateTime, LocalDateTime endDateTime, FrequencyType frequencyType) {
        if(frequencyType == FrequencyType.H) {
            return temperatureRepository.findAggregatedTemperatureHourly(startDateTime, endDateTime);
        }else if (frequencyType == FrequencyType.D){
            return temperatureRepository.findAggregatedTemperatureDaily(startDateTime, endDateTime);
        }
        return null;
    }

    @Override
    public List<TemperatureRecord> saveTemperatureRecord(List<TemperatureRecord> temperatureRecordList) {
        return temperatureRepository.saveAll(temperatureRecordList);
    }
}



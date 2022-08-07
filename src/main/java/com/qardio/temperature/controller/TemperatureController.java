package com.qardio.temperature.controller;


import com.qardio.temperature.model.AggregatedTemperature;
import com.qardio.temperature.model.FrequencyType;
import com.qardio.temperature.model.TemperatureRecord;
import com.qardio.temperature.service.TemperatureService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Controller class for temperature rest api
 */
@Tag(name = "Temperature-Controller", description = "Temperature Rest API")
@Slf4j
@RestController
@RequestMapping("/api/v1/temperature")
public class TemperatureController {

    private TemperatureService temperatureService;

    public TemperatureController(TemperatureService temperatureService) {
        this.temperatureService = temperatureService;
    }

    @PostMapping
    public List<TemperatureRecord> saveTemperatureRecord(@RequestBody List<TemperatureRecord> temperatureRecordList) {
        return temperatureService.saveTemperatureRecord(temperatureRecordList);
    }

    @GetMapping
    public List<AggregatedTemperature> getAggregatedTemperature(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startDateTime,
                                                                @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endDateTime,
                                                                @RequestParam FrequencyType frequencyType) {
        return temperatureService.getAggregatedTemperatureByCriteria(startDateTime, endDateTime, frequencyType);
    }

}

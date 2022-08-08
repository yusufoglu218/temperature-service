package com.qardio.temperature.service;

import com.qardio.temperature.constant.TestConstants;
import com.qardio.temperature.model.AggregatedTemperature;
import com.qardio.temperature.model.FrequencyType;
import com.qardio.temperature.model.TemperatureRecord;
import com.qardio.temperature.repository.TemperatureRepository;
import com.qardio.temperature.util.TestUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.when;

/**
 * Tests for TemperatureService
 */
@ExtendWith(MockitoExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TemperatureServiceTest {

    @Mock
    TemperatureRepository temperatureRepository;

    @InjectMocks
    TemperatureServiceImpl temperatureService;

    @Test
    public void createTemperatureRecord_OK() {
        List<TemperatureRecord> mockTemperatureRecordListForRequest = TestUtil.createMockTemperatureRecordForRequest();
        List<TemperatureRecord> mockTemperatureRecordListForResponse = TestUtil.createMockTemperatureRecordForResponse();
        when(temperatureRepository.saveAll(Mockito.any())).thenReturn(mockTemperatureRecordListForResponse);
        List<TemperatureRecord> temperatureRecordListFromService = temperatureService.saveTemperatureRecord(mockTemperatureRecordListForRequest);

        Assertions.assertEquals(mockTemperatureRecordListForResponse, temperatureRecordListFromService);
    }

    @Test
    public void getAggregatedTemperatureByCriteriaHourly_OK() {
        List<AggregatedTemperature> mockAggregatedTemperatureList = TestUtil.createMockAggregatedHourly();
        when(temperatureRepository.findAggregatedTemperatureHourly(Mockito.any(), Mockito.any(), Mockito.any())).thenReturn(mockAggregatedTemperatureList);
        List<AggregatedTemperature> aggregatedTemperatureListFromService = temperatureService.getAggregatedTemperatureByCriteria(TestConstants.TEMPERATURE_RECORD1_DATE, TestConstants.TEMPERATURE_RECORD2_DATE, FrequencyType.H, TestConstants.TEMPERATURE_RECORD1_SENSOR_ID);

        Assertions.assertEquals(mockAggregatedTemperatureList, aggregatedTemperatureListFromService);
    }

    @Test
    public void getAggregatedTemperatureByCriteriaDaily_OK() {
        List<AggregatedTemperature> mockAggregatedTemperatureList = TestUtil.createMockAggregatedDaily();
        when(temperatureRepository.findAggregatedTemperatureDaily(Mockito.any(), Mockito.any(), Mockito.any())).thenReturn(mockAggregatedTemperatureList);
        List<AggregatedTemperature> aggregatedTemperatureListFromService = temperatureService.getAggregatedTemperatureByCriteria(TestConstants.TEMPERATURE_RECORD1_DATE, TestConstants.TEMPERATURE_RECORD2_DATE, FrequencyType.D, TestConstants.TEMPERATURE_RECORD1_SENSOR_ID);

        Assertions.assertEquals(mockAggregatedTemperatureList, aggregatedTemperatureListFromService);
    }

}

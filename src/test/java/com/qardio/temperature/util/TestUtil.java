package com.qardio.temperature.util;

import com.qardio.temperature.constant.TestConstants;
import com.qardio.temperature.model.AggregatedTemperature;
import com.qardio.temperature.model.AggregatedTemperatureTest;
import com.qardio.temperature.model.TemperatureRecord;

import java.util.List;

public class TestUtil {


    public static List<TemperatureRecord> createMockTemperatureRecordForRequest(){
        TemperatureRecord temperatureRecord1 = TemperatureRecord.builder()
                .temperature(TestConstants.TEMPERATURE_RECORD1_TEMP)
                .localDateTime(TestConstants.TEMPERATURE_RECORD1_DATE)
                .sensorId(TestConstants.TEMPERATURE_RECORD1_SENSOR_ID)
                .build();

        TemperatureRecord temperatureRecord2 = TemperatureRecord.builder()
                .temperature(TestConstants.TEMPERATURE_RECORD2_TEMP)
                .localDateTime(TestConstants.TEMPERATURE_RECORD2_DATE)
                .sensorId(TestConstants.TEMPERATURE_RECORD2_SENSOR_ID)
                .build();

        return List.of(temperatureRecord1, temperatureRecord2);

    }

    public static List<TemperatureRecord> createMockTemperatureRecordMissingParameter(){
        TemperatureRecord temperatureRecord1 = TemperatureRecord.builder()
                .localDateTime(TestConstants.TEMPERATURE_RECORD1_DATE)
                .sensorId(TestConstants.TEMPERATURE_RECORD1_SENSOR_ID)
                .build();

        TemperatureRecord temperatureRecord2 = TemperatureRecord.builder()
                .temperature(TestConstants.TEMPERATURE_RECORD2_TEMP)
                .localDateTime(TestConstants.TEMPERATURE_RECORD2_DATE)
                .sensorId(TestConstants.TEMPERATURE_RECORD2_SENSOR_ID)
                .build();

        return List.of(temperatureRecord1, temperatureRecord2);

    }

    public static List<TemperatureRecord> createMockTemperatureRecordForResponse(){
        TemperatureRecord temperatureRecord1 = TemperatureRecord.builder()
                .id(TestConstants.TEMPERATURE_RECORD1_ID)
                .temperature(TestConstants.TEMPERATURE_RECORD1_TEMP)
                .localDateTime(TestConstants.TEMPERATURE_RECORD1_DATE)
                .sensorId(TestConstants.TEMPERATURE_RECORD1_SENSOR_ID)
                .build();

        TemperatureRecord temperatureRecord2 = TemperatureRecord.builder()
                .id(TestConstants.TEMPERATURE_RECORD2_ID)
                .temperature(TestConstants.TEMPERATURE_RECORD2_TEMP)
                .localDateTime(TestConstants.TEMPERATURE_RECORD2_DATE)
                .sensorId(TestConstants.TEMPERATURE_RECORD2_SENSOR_ID)
                .build();

        return List.of(temperatureRecord1, temperatureRecord2);

    }

    public static List<AggregatedTemperature> createMockAggregatedHourly() {
        AggregatedTemperatureTest aggregatedTemperatureTestHourly1 = new AggregatedTemperatureTest();
        aggregatedTemperatureTestHourly1.setAvg(TestConstants.AGG_TEMP_HOURYL1_AVG);
        aggregatedTemperatureTestHourly1.setMin(TestConstants.AGG_TEMP_HOURYL1_MIN);
        aggregatedTemperatureTestHourly1.setMax(TestConstants.AGG_TEMP_HOURYL1_MAX);
        aggregatedTemperatureTestHourly1.setTimeInterval(TestConstants.AGG_TEMP_HOURLY1_TIME);

        AggregatedTemperatureTest aggregatedTemperatureTestHourly2 = new AggregatedTemperatureTest();
        aggregatedTemperatureTestHourly2.setAvg(TestConstants.AGG_TEMP_HOURYL2_AVG);
        aggregatedTemperatureTestHourly2.setMin(TestConstants.AGG_TEMP_HOURYL2_MIN);
        aggregatedTemperatureTestHourly2.setMax(TestConstants.AGG_TEMP_HOURYL2_MAX);
        aggregatedTemperatureTestHourly2.setTimeInterval(TestConstants.AGG_TEMP_HOURYL2_TIME);

        return List.of(aggregatedTemperatureTestHourly1, aggregatedTemperatureTestHourly2);
    }

    public static List<AggregatedTemperature> createMockAggregatedDaily() {
        AggregatedTemperatureTest aggregatedTemperatureTestDaily1 = new AggregatedTemperatureTest();
        aggregatedTemperatureTestDaily1.setAvg(TestConstants.AGG_TEMP_DAILY1_AVG);
        aggregatedTemperatureTestDaily1.setMin(TestConstants.AGG_TEMP_DAILY1_MIN);
        aggregatedTemperatureTestDaily1.setMax(TestConstants.AGG_TEMP_DAILY1_MAX);
        aggregatedTemperatureTestDaily1.setTimeInterval(TestConstants.AGG_TEMP_DAILY1_TIME);

        AggregatedTemperatureTest aggregatedTemperatureTestDaily2 = new AggregatedTemperatureTest();
        aggregatedTemperatureTestDaily2.setAvg(TestConstants.AGG_TEMP_DAILY2_AVG);
        aggregatedTemperatureTestDaily2.setMin(TestConstants.AGG_TEMP_DAILY2_MIN);
        aggregatedTemperatureTestDaily2.setMax(TestConstants.AGG_TEMP_DAILY2_MAX);
        aggregatedTemperatureTestDaily2.setTimeInterval(TestConstants.AGG_TEMP_DAILY2_TIME);

        return List.of(aggregatedTemperatureTestDaily1, aggregatedTemperatureTestDaily2);
    }
}

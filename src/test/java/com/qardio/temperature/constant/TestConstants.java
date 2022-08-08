package com.qardio.temperature.constant;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TestConstants {

    private TestConstants() {
    }

    public static final Long TEMPERATURE_RECORD1_ID = Long.valueOf(123);
    public static final LocalDateTime TEMPERATURE_RECORD1_DATE = LocalDateTime.of(2022,07,06,01,10);
    public static final BigDecimal TEMPERATURE_RECORD1_TEMP = new BigDecimal(5);
    public static final String TEMPERATURE_RECORD1_SENSOR_ID = "Sens123";


    public static final Long TEMPERATURE_RECORD2_ID = Long.valueOf(124);
    public static final LocalDateTime TEMPERATURE_RECORD2_DATE = LocalDateTime.of(2022,07,06,01,10);
    public static final BigDecimal TEMPERATURE_RECORD2_TEMP = new BigDecimal(15);
    public static final String TEMPERATURE_RECORD2_SENSOR_ID = "Sens1234";


    public static final BigDecimal AGG_TEMP_HOURYL1_MIN= new BigDecimal(3);
    public static final BigDecimal AGG_TEMP_HOURYL1_MAX= new BigDecimal(15);
    public static final BigDecimal AGG_TEMP_HOURYL1_AVG= new BigDecimal(6);
    public static final String AGG_TEMP_HOURLY1_TIME = "2022-08-05 12:10:00";

    public static final BigDecimal AGG_TEMP_HOURYL2_MIN= new BigDecimal(3);
    public static final BigDecimal AGG_TEMP_HOURYL2_MAX= new BigDecimal(15);
    public static final BigDecimal AGG_TEMP_HOURYL2_AVG= new BigDecimal(6);
    public static final String AGG_TEMP_HOURYL2_TIME= "2022-08-05 11:00";

    public static final BigDecimal AGG_TEMP_DAILY1_MIN= new BigDecimal(3);
    public static final BigDecimal AGG_TEMP_DAILY1_MAX= new BigDecimal(15);
    public static final BigDecimal AGG_TEMP_DAILY1_AVG= new BigDecimal(6);
    public static final String AGG_TEMP_DAILY1_TIME= "2022-08-05";

    public static final BigDecimal AGG_TEMP_DAILY2_MIN= new BigDecimal(3);
    public static final BigDecimal AGG_TEMP_DAILY2_MAX= new BigDecimal(15);
    public static final BigDecimal AGG_TEMP_DAILY2_AVG= new BigDecimal(6);
    public static final String AGG_TEMP_DAILY2_TIME= "2022-08-06";



}

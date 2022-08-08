package com.qardio.temperature.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qardio.temperature.constant.TestConstants;
import com.qardio.temperature.model.AggregatedTemperature;
import com.qardio.temperature.model.FrequencyType;
import com.qardio.temperature.model.TemperatureRecord;
import com.qardio.temperature.service.TemperatureServiceImpl;
import com.qardio.temperature.util.TestUtil;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = TemperatureController.class)
public class TemperatureControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private TemperatureServiceImpl temperatureService;


    @Test
    public void createTemperature_thenReturnSavedTemperature() throws Exception {
        List<TemperatureRecord> mockTemperatureRecordListForRequest = TestUtil.createMockTemperatureRecordForRequest();
        List<TemperatureRecord> mockTemperatureRecordListForResponse = TestUtil.createMockTemperatureRecordForResponse();

        when(temperatureService.saveTemperatureRecord(Mockito.any())).thenReturn(mockTemperatureRecordListForResponse);

        ResultActions response = mockMvc.perform(post("/api/v1/temperature")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(mockTemperatureRecordListForRequest)));

        response.andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.size()",
                        is(mockTemperatureRecordListForRequest.size())));
    }

    @Test
    public void createTemperature_missingParameter() throws Exception {
        List<TemperatureRecord> mockTemperatureRecordListForRequest = TestUtil.createMockTemperatureRecordMissingParameter();
        ResultActions response = mockMvc.perform(post("/api/v1/temperature")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(mockTemperatureRecordListForRequest)));

        response.andExpect(status().isBadRequest());
    }

    @Test
    public void getAggregatedTemperature_thenReturnTemperature() throws Exception {
        List<AggregatedTemperature> mockAggregatedTemperatureList = TestUtil.createMockAggregatedHourly();
        when(temperatureService.getAggregatedTemperatureByCriteria(Mockito.any(), Mockito.any(), Mockito.any(), Mockito.any())).thenReturn(mockAggregatedTemperatureList);

        ResultActions response = mockMvc.perform(get("/api/v1/temperature")
                .param("startDateTime", TestConstants.TEMPERATURE_RECORD1_DATE.toString())
                .param("endDateTime", TestConstants.TEMPERATURE_RECORD1_DATE.toString())
                .param("frequencyType", FrequencyType.D.toString())
                .param("sensorId", TestConstants.TEMPERATURE_RECORD1_SENSOR_ID));

        response.andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.size()",
                        is(mockAggregatedTemperatureList.size())));
    }


    @Test
    public void getAggregatedTemperature_whenMissingParameter() throws Exception {
        List<AggregatedTemperature> mockAggregatedTemperatureList = TestUtil.createMockAggregatedHourly();
        when(temperatureService.getAggregatedTemperatureByCriteria(Mockito.any(), Mockito.any(), Mockito.any(), Mockito.any())).thenReturn(mockAggregatedTemperatureList);

        ResultActions response = mockMvc.perform(get("/api/v1/temperature")
                .param("startDateTime", TestConstants.TEMPERATURE_RECORD1_DATE.toString())
                .param("frequencyType", FrequencyType.D.toString())
                .param("sensorId", TestConstants.TEMPERATURE_RECORD1_SENSOR_ID));

        response.andExpect(status().isBadRequest());
    }

}

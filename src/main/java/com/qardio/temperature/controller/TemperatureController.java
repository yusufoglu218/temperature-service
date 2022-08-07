package com.qardio.temperature.controller;


import com.qardio.temperature.model.AggregatedTemperature;
import com.qardio.temperature.model.FrequencyType;
import com.qardio.temperature.model.TemperatureRecord;
import com.qardio.temperature.service.TemperatureService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Controller class for temperature rest api
 */
@Tag(name = "Temperature-Controller", description = "Temperature Rest API")
@Slf4j
@Validated
@RestController
@RequestMapping("/api/v1/temperature")
public class TemperatureController {

    private TemperatureService temperatureService;

    public TemperatureController(TemperatureService temperatureService) {
        this.temperatureService = temperatureService;
    }

    @Operation(summary = "Save the TemperatureRecord by request body")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful response", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = TemperatureRecord.class))}),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Exception.class))}),
            @ApiResponse(responseCode = "500", description = "Internal Error", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Exception.class))})
    })
    @PostMapping
    public List<TemperatureRecord> saveTemperatureRecord(@RequestBody @NotEmpty(message = "Input temperatureRecord list cannot be empty.") List<@Valid TemperatureRecord> temperatureRecordList) {
        return temperatureService.saveTemperatureRecord(temperatureRecordList);
    }

    @Operation(summary = "Get aggregated temperature by criteria")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful response", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = AggregatedTemperature.class))}),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Exception.class))}),
            @ApiResponse(responseCode = "500", description = "Internal Error", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Exception.class))})
    })
    @GetMapping
    public List<AggregatedTemperature> getAggregatedTemperature(@Parameter(description = "Start date of aggregated temperature") @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startDateTime,
                                                                @Parameter(description = "End date of aggregated temperature") @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endDateTime,
                                                                @Parameter(description = "Frequency type of aggregated temperature. D:Daily, H:Hourly") @RequestParam FrequencyType frequencyType) {
        return temperatureService.getAggregatedTemperatureByCriteria(startDateTime, endDateTime, frequencyType);
    }

}

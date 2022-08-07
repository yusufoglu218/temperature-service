package com.qardio.temperature.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Entity class for temperature record
 */
@Entity
@Data
public class TemperatureRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "temperature is mandatory")
    private BigDecimal temperature;

    @NotNull(message = "localDateTime is mandatory")
    private LocalDateTime localDateTime;

}

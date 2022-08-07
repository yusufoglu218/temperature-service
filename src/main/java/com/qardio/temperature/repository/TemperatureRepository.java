package com.qardio.temperature.repository;

import com.qardio.temperature.model.AggregatedTemperature;
import com.qardio.temperature.model.TemperatureRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;


@Repository
public interface TemperatureRepository extends JpaRepository<TemperatureRecord, Long> {

    @Query(value = "SELECT \n" +
            "    MIN(temperature) AS min,\n" +
            "    MAX(temperature) AS max,\n" +
            "    AVG(temperature) AS avg,\n" +
            "    DATE_FORMAT(local_date_time, '%Y-%m-%d %H:00') AS timeInterval\n" +
            "FROM\n" +
            "    temperaturedb.temperature_record\n" +
            "WHERE\n" +
            "   local_date_time BETWEEN :startDateTime and :endDateTime\n" +
            "GROUP BY DATE_FORMAT(local_date_time, '%Y-%m-%d-%H')\n" +
            "ORDER BY DATE_FORMAT(local_date_time, '%Y-%m-%d-%H') ASC",
            nativeQuery = true)
    List<AggregatedTemperature> findAggregatedTemperatureHourly(@Param("startDateTime") LocalDateTime startDateTime, @Param("endDateTime") LocalDateTime endDateTime);

    @Query(value = "SELECT \n" +
            "    MIN(temperature) AS min,\n" +
            "    MAX(temperature) AS max,\n" +
            "    AVG(temperature) AS avg,\n" +
            "    DATE_FORMAT(local_date_time, '%Y-%m-%d') AS timeInterval\n" +
            "FROM\n" +
            "    temperaturedb.temperature_record\n" +
            "WHERE\n" +
            "   local_date_time BETWEEN :startDateTime and :endDateTime\n" +
            "GROUP BY DATE_FORMAT(local_date_time, '%Y-%m-%d')\n" +
            "ORDER BY DATE_FORMAT(local_date_time, '%Y-%m-%d') ASC",
            nativeQuery = true)
    List<AggregatedTemperature> findAggregatedTemperatureDaily(@Param("startDateTime") LocalDateTime startDateTime, @Param("endDateTime") LocalDateTime endDateTime);

}

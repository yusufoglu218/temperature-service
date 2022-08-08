# Temperature Rest Api

Temperature rest api that includes save and getByMultipleCriteria operations using spring boot and mySql db.

## Prerequisites
- Java 11
- [Maven](https://maven.apache.org/guides/index.html)
- [MySql](https://dev.mysql.com/doc/) : MySql db must be installed by creating database schema that is specified in the properties file


###  Build and Run application
_GOTO >_ **~/absolute-path-to-directory/temperature-service**  
and try below command in terminal
> **```mvn spring-boot:run```** it will run application as spring boot application

or
> **```mvn clean install```** it will build application and create **jar** file under target directory

Run jar file from below path with given command
> **```java -jar ~/path-to-temperature-service/target/temperature-service-0.0.1-SNAPSHOT.jar```**

### Model class
Below are the model classes which we will store in MySql and perform database operations.

   ```
public class TemperatureRecord {
    private Long id;
    private String sensorId;
    private BigDecimal temperature;
    private LocalDateTime localDateTime;
}

public interface AggregatedTemperature {
    BigDecimal getMin();
    BigDecimal getMax();
    BigDecimal getAvg();
    String getTimeInterval();
    void setMin(BigDecimal minValue);
    void setMax(BigDecimal minValue);
    void setAvg(BigDecimal minValue);
    void setTimeInterval(String timeInterval);
}
   ```

### Endpoints

#### HTML

|HTTP Method|URL|Description|
|---|---|---|
|`GET`|http://localhost:8080/ | Root page |
|`GET`|http://localhost:8080/swagger-ui/index.html | Swagger UI page |
|`GET`|http://localhost:8080/actuator/* | Spring actuator page for monitoring the application |

#### Recipe Service

|HTTP Method|URL|Description|
|---|---|---|
|`POST`|http://localhost:8080/api/v1/temperature | Create new temperature |
|`GET`|http://localhost:8080/api/v1/temperature?startDateTime={startDateTime}&endDateTime={endDateTime}&frequencyType={frequencyType}&sensorId={sensorId}| Get aggregated temperature by criteria|

Postman collection can be found under resources/postman

#### Request Body sample for save operation
    ```
    [
        {
        "sensorId":"sens12345",
        "temperature": "0",
        "localDateTime": "2022-07-08T13:31:55.698"
        },
        {
        "sensorId":"sens12346",
        "temperature": "27",
        "localDateTime": "2022-07-08T13:30:55.698"
        },
        {
        "sensorId":"sens12347",
        "temperature": "12",
        "localDateTime": "2022-07-08T14:30:55.698"
        }
    ]
    ``` 


#### Response sample for get aggregated temperature hourly operation
    ```
    [
        {
        "max": 27.00,
        "min": 0.00,
        "avg": 13.500000,
        "timeInterval": "2022-07-08 13:00"
        },
        {
        "max": 12.00,
        "min": 12.00,
        "avg": 12.000000,
        "timeInterval": "2022-07-08 14:00"
        },
        {
        "max": 27.00,
        "min": 0.00,
        "avg": 12.750000,
        "timeInterval": "2022-07-08 15:00"
        }
    ]
```

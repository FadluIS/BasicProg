package ch8Generics.tempMeasurement;

import ch8Generics.measurementData.Measurement;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class TemperatureMeasurementSeriesTest {

    @Test
    void testCelsiusToFahrenheit() {
        double expected = 77;
        double result = TemperatureMeasurementSeries.celsiusToFahrenheit(25);

        Assertions.assertThat(result).isEqualTo(expected);
    }

    @Test
    void testPrint() {
        TemperatureMeasurementSeries testSeries = new TemperatureMeasurementSeries(3, "C");

        testSeries.addMeasuredValue(new Measurement<Double>(32.1, LocalDateTime.now()));
        testSeries.addMeasuredValue(new Measurement<Double>(12.5, LocalDateTime.now()));
        testSeries.addMeasuredValue(new Measurement<Double>(9.5, LocalDateTime.now()));

        testSeries.print();
    }
}
package ch8Generics.measurementData;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class MeasurementSeriesTest {
    @Test
    void testConstructor() {
        MeasurementSeries<?> test = new MeasurementSeries<>(4);
        Measurement<Float> floatMeasurement = new Measurement<>(12.5f, LocalDateTime.now());
        Measurement<Integer> integerMeasurement = new Measurement<>(12, LocalDateTime.now());

        test.addMeasuredValue(floatMeasurement);
        test.addMeasuredValue(integerMeasurement);

        test.print();
    }
}
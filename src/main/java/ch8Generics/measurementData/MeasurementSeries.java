package ch8Generics.measurementData;

import java.time.LocalDateTime;

public class MeasurementSeries<T> {
    protected Measurement<?>[] measurements;
    protected int numMeasurements = 0;

    public MeasurementSeries (int amountOfMeasurements) {
        measurements = new Measurement[amountOfMeasurements];
    }

    public void addMeasuredValue (Measurement<?> m) {
        measurements[numMeasurements++] = m;
    }

    public Object getMeasurement(LocalDateTime date) {
        for (int i = 0; i < Measurement.numMeasuredValues; i++) {
            if (date.equals(measurements[i].getDate())) {
                return measurements[i].getValue();
            }
        }

        return null;
    }

    public void print() {
        for (int i = 0; i < Measurement.numMeasuredValues; i++) {
            System.out.println(measurements[i].getValue());
        }
    }
}

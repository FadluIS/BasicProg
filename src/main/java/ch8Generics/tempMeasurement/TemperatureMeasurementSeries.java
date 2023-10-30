package ch8Generics.tempMeasurement;

import ch8Generics.measurementData.MeasurementSeries;

public class TemperatureMeasurementSeries extends MeasurementSeries<Double> {
    private String tempUnit;
    public TemperatureMeasurementSeries(int amountOfMeasurements, String tempUnit) {
        super(amountOfMeasurements);
        this.tempUnit = tempUnit;
    }

    public void print() {
        System.out.println("Temps recorded in " + tempUnit);
        super.print();
    }

    public static double celsiusToFahrenheit(double celsiusTemp) {
        return (celsiusTemp * 9 / 5) + 32;
    }
}

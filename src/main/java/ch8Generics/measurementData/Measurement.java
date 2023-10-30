package ch8Generics.measurementData;

import java.time.LocalDateTime;

public class Measurement<T> {
    protected static int numMeasuredValues = 0;
    private int id;
    private T data;
    private LocalDateTime date;

    public Measurement(T measurementData, LocalDateTime measurementDate) {
        this.id = ++numMeasuredValues;
        this.data = measurementData;
        this.date = measurementDate;
    }

    T getValue() {
        return data;
    }

    LocalDateTime getDate() {
        return date;
    }

    int getId() {
        return id;
    }
}

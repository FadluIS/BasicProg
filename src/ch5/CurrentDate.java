package ch5;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Return current date in format EEEE. dd.mm.yyyy
 *
 * Ex: Saturday. 02.02.2002
 */
public class CurrentDate {
    public static void main(String[] args) {
        System.out.println(new CurrentDate());
    }

    @Override
    public String toString() {
        var dateForm = DateTimeFormatter.ofPattern("EEEE. dd.MM.YYYY");
        var current = LocalDate.now();
        return current.format(dateForm);
    }
}

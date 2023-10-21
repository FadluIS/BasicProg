package ch5;

import java.text.SimpleDateFormat;
import java.util.Date;

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
        SimpleDateFormat dateForm = new SimpleDateFormat("EEEE. dd.MM.YYYY");
        Date current = new Date(); //ToDo: use more modern API's like LocalDateTime or LocalDate
        return dateForm.format(current);
    }
}

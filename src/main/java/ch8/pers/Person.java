package ch8.pers;

import java.util.*;
public class Person {
    private String surname;
    private String forename;
    public Person() {
        Scanner input = new Scanner(System.in);
        System.out.print("Type in the surname: ");
        surname = input.next();
        System.out.print("Type in the forename: ");
        forename = input.next();
    }
    public void print() {
        System.out.println("surname: " + surname);
        System.out.println("forename: " + forename);
    }
}

package ch8.studi;

import ch8.pers.Person;

import java.util.*;
public class Student extends Person {
    private String matriculationNumber;

    public Student() {
        super();
        Scanner input = new Scanner(System.in);
        System.out.print ("Type in matriculationNumber: ");
        matriculationNumber = input.next();
        System.out.println();
    }

    public void print() {
        super.print();
        System.out.println("matriculationNumber: " + matriculationNumber);
    }
}

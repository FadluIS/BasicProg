package ch8.pers.prof;

import java.util.*;
import ch8.pers.Person;
import ch8.studi.Student;

public class Professor extends Person {
    private String scienceField;
    private Student stud;

    public Professor() {
        super();
        Scanner input = new Scanner(System.in);
        System.out.print("Type in the science field: ");
        scienceField = input.next();
        System.out.println();
        System.out.println("Professor erstellt Student");
        stud = new Student();
    }

    public void print() {
        // output of the inherited instance variables
        super.print();

        System.out.println("science field: " + scienceField);
        System.out.println("professor's student:");
        this.stud.print();
    }
}

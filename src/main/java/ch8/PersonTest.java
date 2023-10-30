package ch8;

import ch8.pers.Person;
import ch8.pers.prof.Professor;
import ch8.studi.Student;

/*
Which directories do you need to set up?
- pers and studi, inside the "working directory" ch8.

What are the file names of your programmes in the directories?
- Person.java, Student.java

 */

public class PersonTest {

    public static void main(String[] args) {
        System.out.println ("Start of the program");
        System.out.println();

        System.out.println ("create person");
        Person testPerson = new Person();
        System.out.println();

        System.out.println ("create student");
        Student testStudent = new Student();
        System.out.println();

        System.out.println ("create professor");
        Professor testProf = new Professor();
        System.out.println();

        System.out.println ("output Person");
        testPerson.print();
        System.out.println();

        System.out.println ("output Student");
        testStudent.print();
        System.out.println();

        System.out.println ("output Professor");
        testProf.print();
        System.out.println();
    }
}

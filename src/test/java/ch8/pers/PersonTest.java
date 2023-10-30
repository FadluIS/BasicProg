package ch8.pers;

import ch8.pers.prof.Professor;
import ch8.studi.Student;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

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

    @Test()
    void testGetName() {
        System.out.println("Testing testGetName");
        Person testPerson = new Person();
        testPerson.setSurname("Surname");
        testPerson.setForename("Forename");
        String resultName = testPerson.getName();

        Assertions.assertThat(resultName).isEqualTo("Forename Surname");
    }

    @Test
    void testGetNameScanner() {
        Person testPerson = new Person();

        Scanner input = new Scanner(System.in);
        input.useDelimiter(" ");

        System.out.print("Type in the surname: ");
        String surname = input.nextLine();
        testPerson.setSurname(surname);

        System.out.print("Type in the forename: ");
        String forename = input.nextLine();
        testPerson.setForename(forename);

        Assertions.assertThat(testPerson.getName()).isEqualTo(String.format("%s %s", forename, surname));
    }
}

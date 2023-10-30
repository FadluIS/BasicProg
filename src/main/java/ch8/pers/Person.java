package ch8.pers;

import java.util.*;
public class Person {
    private String surname;
    private String forename;
    public Person() {

    }

    public Person(String surname, String forename) {
        this.surname = surname;
        this.forename = forename;
    }


    public String getName() {
        return String.format("%s %s", forename, surname);
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setForename(String forename) {
        this.forename = forename;
    }

    public String getSurname() {
        return surname;
    }

    public String getForename() {
        return forename;
    }

    public void print() {
        System.out.println(getName());
    }
}

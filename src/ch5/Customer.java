package ch5;

import java.util.Arrays;

public class Customer implements Comparable {
    String name;
    String email;

    public static void main(String[] args) {
        Customer[] customers = {new Customer("aaa", "email"), new Customer("baa", "email"), new Customer("aba", "email")};
        System.out.println("Original: " + Arrays.toString(customers));

        String[] expected = {"aaa: email", "aba: email", "baa: email"};
        Arrays.sort(customers);

        System.out.println("Expected: " + Arrays.toString(expected));
        System.out.println("Result: " + Arrays.toString(customers));
    }

    public Customer(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return name + ": " + email;
    }

    @Override
    public int compareTo(Object o) {
        Customer toCompare = (Customer) o;

        return this.name.compareTo(toCompare.getName());
    }
}

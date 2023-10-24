package ch8;

public abstract class Employee {
    protected String lastName;
    protected String firstName;
    protected double salary;

    public double getSalary() {
        return salary;
    }

    public Employee(String lastName, String firstName, double salary){
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
    }

    public void increaseSalary(double amount) {
        // Ensure amount is positive
        if (amount < 0) {
            throw new IllegalArgumentException("Amount should be positive.");
        }

        this.salary += amount;
    }

    public void showData() {
        System.out.format("Last Name, First Name: %s, %s \nSalary: %.2f\n", lastName, firstName, salary);
    }

    public abstract void addSalary(double amount) throws Exception;
}

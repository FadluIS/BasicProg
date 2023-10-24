package ch8;

public class Staff extends Employee {
    private static final int MAX_LEVEL = 5;
    private int level;

    public int getLevel() {
        return level;
    }

    public Staff(String lastName, String firstName, double salary) {
        super(lastName, firstName, salary);
    }

    public void promote() {
        level++;
    }

    @Override
    public void showData() {
        super.showData();
        System.out.format("Level: %d\n", this.level);
    }

    @Override
    public void addSalary(double amount) throws Exception {
        if (level < 1) {
            throw new Exception("Salary not changed: Staff has to be over level 2");
        }

        if (amount < 0) {
            throw new IllegalArgumentException("Amount to add onto salary has to be positive");
        }

        this.salary += amount;
    }
}

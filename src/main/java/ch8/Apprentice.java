package ch8;

public class Apprentice extends Employee {
    private int examsTaken;
    public Apprentice(String lastName, String firstName, double salary) {
        super(lastName, firstName, salary);
    }

    public void setExamsTaken(int examsTaken) {
        // Ensure exams are positive
        if (examsTaken < 0) {
            throw new IllegalArgumentException("Exams taken cannot be negative.");
        }

        this.examsTaken = examsTaken;
    }

    @Override
    public void addSalary(double amount) throws Exception {
        if (examsTaken <= 3) {
            throw new Exception("Salary not changed: Apprentice has to have at least 3 exams taken");
        }

        if (amount < 0) {
            throw new IllegalArgumentException("Amount to add onto salary has to be positive");
        }

        salary += amount;
    }

    @Override
    public void showData() {
        super.showData();
        System.out.format("Exams Taken: %d\n", examsTaken);
    }

    public int getExamsTaken() {
        return examsTaken;
    }
}

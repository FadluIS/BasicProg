package ch8;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class ApprenticeTest {
    Apprentice testApprentice;

    @BeforeEach
    void setUp() {
        testApprentice = new Apprentice("Abdelrehim", "Fadlurahman", 0.15);
    }

    @Test
    void setExamsTaken() {
        var newExams = 3;
        testApprentice.setExamsTaken(newExams);
        int resultExamsTaken = testApprentice.getExamsTaken();

        Assertions.assertThat(resultExamsTaken).isEqualTo(newExams);
    }

    @Test
    void setExamsTakenNegative() {
        Assertions.assertThatThrownBy(() -> testApprentice.setExamsTaken(-3)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void addSalary() throws Exception {
        testApprentice.setExamsTaken(10);
        double oldSalary = testApprentice.getSalary();
        double amountToAdd = 12.03;
        testApprentice.addSalary(amountToAdd);
        double newSalary = testApprentice.getSalary();

        Assertions.assertThat(newSalary).isEqualTo(oldSalary + amountToAdd);
    }

    @Test
    void addSalaryNegative() {
        testApprentice.setExamsTaken(10);
        Assertions.assertThatThrownBy(() -> testApprentice.addSalary(-3)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void addSalaryNoExams() {
        Assertions.assertThatThrownBy(() -> testApprentice.addSalary(3)).isInstanceOf(Exception.class);
    }
}
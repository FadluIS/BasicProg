package ch8;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StaffTest {
    Staff testStaff;

    @BeforeEach
    void setUp() {
        testStaff = new Staff("Mustermann", "Lea", 23.43);
    }

    @Test
    void promote() {
        int expectedLevel = testStaff.getLevel() + 1;
        testStaff.promote();
        int resultLevel = testStaff.getLevel();

        Assertions.assertThat(resultLevel).isEqualTo(expectedLevel);
    }

    @Test
    void addSalary() throws Exception {
        testStaff.promote();
        testStaff.promote();
        double oldSalary = testStaff.getSalary();
        double amountToAdd = 12.03;
        testStaff.addSalary(amountToAdd);
        double newSalary = testStaff.getSalary();

        Assertions.assertThat(newSalary).isEqualTo(oldSalary + amountToAdd);
    }

    @Test
    void addSalaryNegative() {
        testStaff.promote();
        testStaff.promote();
        Assertions.assertThatThrownBy(() -> testStaff.addSalary(-3)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void addSalaryLowLevel() {
        Assertions.assertThatThrownBy(() -> testStaff.addSalary(3)).isInstanceOf(Exception.class);

    }
}
package ch5;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntegerStackTest {

    @Test
    public void testIntegerStackHappyPath() throws Exception {
        final int size = 5;
//        System.out.println(String.format("Initializing Stack with size %d ", size));
        IntegerStack stack = new IntegerStack(size);

        String expectedStack = "[ ";
        int expectedLastMember = 0;
        for (int i = 0; i < size; i++) {
            int member = (int) Math.floor(Math.random() * 100 + 1);
//            System.out.println("Pushing " + member);
            stack.push(member);

            expectedStack += ((i == 0) ? "":", ") + member;

            if (i == size - 1) expectedLastMember = member;
        }
        expectedStack += " ]";

        Assertions.assertThat(expectedStack).isEqualTo(stack.toString());
    }

    @Test
    public void testIntegerStackPopFull() throws Exception {
        final int size = 2;
        var stack = new IntegerStack(size);
        String expectedStack = "[ 1 ]";

        stack.push(1);
        stack.push(2);

        final int poppedValue = stack.pop();
        final int expectedValue = 2;

        Assertions.assertThat(expectedValue).isEqualTo(poppedValue);
        Assertions.assertThat(expectedStack).isEqualTo(stack.toString());
    }
}
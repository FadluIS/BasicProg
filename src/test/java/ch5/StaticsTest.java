package ch5;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Vector;

import static org.junit.jupiter.api.Assertions.*;

class StaticsTest {

    @Test
    void delimitedString() {
        String input = "dowabdsjal";
        char start = 'o';
        char end = 'a';
        String expectedResult = "owabdsja";

        Assertions.assertThat(Statics.delimitedString(input, start, end)).isEqualTo(expectedResult);
    }

    @Test
    void encode() {
        String input = "äzXyä";
        String expectedResult = "1526242515";

        Assertions.assertThat(Statics.encode(input)).isEqualTo(expectedResult);
    }

    @Test
    void testExtractCharDelimiter() {
        String delimiter = "|";
        String original = "Hi! We'll be <br> using| pipes| as <br> our| delimiter.";
        String[] expected = {"Hi! We'll be <br> using", " pipes", " as <br> our", " delimiter."};
        String[] result = Statics.extract(original, delimiter);

        Assertions.assertThat(Arrays.toString(result)).isEqualTo(Arrays.toString(expected));
    }

    @Test
    void testExtractStringDelimiter() {
        String delimiterLong = "<br>";
        String originalLong = "Hi! We'll be<br><br> <br> using| breaks| as <br> our| delimiter.<br><br>";
        String[] expectedLong = {"Hi! We'll be", " ", " using| breaks| as ", " our| delimiter."};
        String[] resultLong = Statics.extract(originalLong, delimiterLong);

        Assertions.assertThat(Arrays.toString(resultLong)).isEqualTo(Arrays.toString(expectedLong));
    }

    @Test
    void extractVariant() {
        String delimiterLongVar = "<br>";
        String originalLongVar = "Hi!Hi!<br>    Hi!<br>   Hi!<br> We'll be    <br><br> <br> <br>We'll be";

        var expectedVector = new Vector<String>();
        expectedVector.add("Hi!Hi!: 1");
        expectedVector.add("Hi!: 2");
        expectedVector.add("We'll be: 2");

        String[] resultLongVar = Statics.extractVariant(originalLongVar, delimiterLongVar);

        boolean flag = true;
        for (int i = 0; i < resultLongVar.length; i++) {
            if (!expectedVector.contains(resultLongVar[i])) {
                flag = false;
                break;
            }
        }
        if (expectedVector.size() != resultLongVar.length) flag = false;

        Assertions.assertThat(flag).isTrue();
    }
}
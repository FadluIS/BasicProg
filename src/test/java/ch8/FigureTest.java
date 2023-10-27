package ch8;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Vector;

import static org.junit.jupiter.api.Assertions.*;

class FigureTest {
    Rectangle testRectangle;
    double testRectangleWidth;
    double testRectangleLength;
    Circle testCircle;
    double testCircleRadius;

    @BeforeEach
    void setUp() {
        testCircleRadius = 3;
        testRectangleLength = 4;
        testRectangleWidth = 5;

        testRectangle = new Rectangle(testRectangleLength, testRectangleWidth);
        testCircle = new Circle(testCircleRadius);
    }

    @Test
    void figureArray() {
        Vector<Figure> testArray = new Vector<>();

        testArray.add(testCircle);
        testArray.add(testRectangle);

        Assertions.assertThat(testArray.size()).isEqualTo(2);
    }

    @Test
    void noAbstractInstance() {
        // No need to test, does not compile
//        Assertions.assertThatThrownBy(() => new Figure())
    }

    @Test
    void areaCircle() {
        double calculatedArea = testCircle.getArea();
        double expectedArea = 2 * Math.PI * Math.pow(testCircleRadius, 2);

        Assertions.assertThat(calculatedArea).isEqualTo(expectedArea);
    }

    @Test
    void areaRectangle() {
        double calculatedArea = testRectangle.getArea();
        double expectedArea = testRectangleWidth * testRectangleLength;

        Assertions.assertThat(calculatedArea).isEqualTo(expectedArea);
    }
}
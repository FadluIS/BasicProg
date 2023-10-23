package ch5;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShoppingCartTest {

    @Test
    void orderValue() {
        var testingCart = new ShoppingCart();

        testingCart.add(new Article(1, 15, 2));
        testingCart.add(new Article(2, 2.1, 10));
        testingCart.add(new Article(4, 2, 2));
        testingCart.add(new Article(2, 2.1, 10));

        double expectedValue = 15 * 2 + 2.1 * 10 + 2 * 2 + 2.1 * 10;
        Assertions.assertThat(testingCart.orderValue()).isEqualTo(expectedValue);
    }
}
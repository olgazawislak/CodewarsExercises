import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ReversePolishNotationTest {

    @Test
    void evaluateTest() {
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(new ReversePolishNotation().evaluate("")).isEqualTo(0);
        softly.assertThat(new ReversePolishNotation().evaluate("2 4 +")).isEqualTo(6);
        softly.assertThat(new ReversePolishNotation().evaluate("5 1 2 + 4 * + 3 -")).isEqualTo(14);
        softly.assertThat(new ReversePolishNotation().evaluate("5 1 + 2 /")).isEqualTo(3);
        softly.assertThat(new ReversePolishNotation().evaluate("5 2 /")).isEqualTo(2.5);
        softly.assertAll();
    }
}
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class MinNbDivTest {

    @Test
    public void findMinNumTest() {
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(new MinNbDiv().findMinNumBruteForceVersion(1)).isEqualTo(1);
        softly.assertThat(new MinNbDiv().findMinNumBruteForceVersion(10)).isEqualTo(48);
        softly.assertThat(new MinNbDiv().findMinNumBruteForceVersion(12)).isEqualTo(60);
        softly.assertAll();
    }

    @Test
    public void countDivisorsTest() {
        assertThat(new MinNbDiv().countDivisors(48)).isEqualTo(10);
    }
}
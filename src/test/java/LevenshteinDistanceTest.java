import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LevenshteinDistanceTest {

    @Test
    void calculateTest() {
        assertThat(new LevenshteinDistance().calculate("kitten", "sitting")).isEqualTo(3);
    }
}
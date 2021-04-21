import java.util.Arrays;
import java.util.Collections;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class JosephusTest {

    @Test
    void josephusPermutationTest() {
        assertThat(new Josephus().josephusPermutation(Collections.EMPTY_LIST, 5)).isEqualTo(Collections.EMPTY_LIST);
        assertThat(new Josephus().josephusPermutation(Arrays.asList(1, 2, 3, 4, 5), 1)).isEqualTo(Arrays.asList(1, 2, 3, 4, 5));
        assertThat(new Josephus().josephusPermutation(Arrays.asList(1, 2, 3, 4, 5), 2)).isEqualTo(Arrays.asList(2, 4, 1, 5, 3));
        assertThat(new Josephus().josephusPermutation(Arrays.asList(1, 2, 3, 4, 5, 6, 7), 3)).isEqualTo(Arrays.asList(3, 6, 2, 7, 5, 1, 4));
    }
}
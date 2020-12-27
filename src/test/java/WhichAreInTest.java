import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class WhichAreInTest {

    @Test
    public void test1() {
        String[] a = new String[]{ "arp", "live", "strong" };
        String[] b = new String[] { "lively", "alive", "harp", "sharp", "armstrong" };
        String[] expected = new String[] { "arp", "live", "strong" };
        assertArrayEquals(expected, new WhichAreIn().inArray(a, b));
    }
}

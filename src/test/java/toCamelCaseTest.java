import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class toCamelCaseTest {

    @Test
    public void shouldReturnCamelCaseStringTest(){
        assertEquals("IAmSoExcited", Solution.toCamelCase("I_am_so_Excited"));
        assertEquals("iAmSoRelaxed", Solution.toCamelCase("i-am-so-relaxed"));
        assertEquals("IAmSoExcitedAndICannotHideIt", Solution.toCamelCase("I_am-so_Excited-and_i-cannot-hide_it"));
        assertEquals("iAmSad", Solution.toCamelCase("i__am--sad"));
    }
}

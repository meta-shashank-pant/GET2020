import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class LongestWordTest {
	private String fInput;
    private String fExpected;

    public LongestWordTest(String input, String expected) {
        this.fInput = input;
        this.fExpected = expected;
    }

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
        		{"my name is harry.", "harry."},
        		{"qwertyuiop asdfghjkl zxcvbnm", "qwertyuiop"},
        		{"a", "a"},
        		{"", ""},
        		{"asdfgh zxcvbn", "zxcvbn"},
        		{"a b c d", "d"},
        		{"QAZ VFRTGB MJUIKLOP", "MJUIKLOP"}});
    }
    
    @Test
    public void test() {
    	Strings string = new Strings();
        assertEquals(fExpected, string.largest_word(fInput));
    }

}

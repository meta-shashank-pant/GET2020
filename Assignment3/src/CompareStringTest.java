import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class CompareStringTest {
	private String fInput1;
	private String fInput2;
    private String fExpected;

    public CompareStringTest(String input1, String input2, String expected) {
        this.fInput1 = input1;
        this.fInput2 = input2;
        this.fExpected = expected;
    }

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
        		{"8AB", "B78", "Strings are not equal."},
        		{"adf", "fda", "Strings are not equal."},
        		{"1234", "5678", "Strings are not equal."},
        		{"fabcdef", "fedcba", "Strings are not equal."},
        		{"fa00", "b00", "Strings are not equal."},
        		{"a1000", "2000", "Strings are not equal."},
        		{"dfe", "dfe", "EQUAL!!!"}});
    }
    
    @Test
    public void test() {
    	Strings string = new Strings();
        assertEquals(fExpected, string.compare_string(fInput1, fInput2));
    }

}

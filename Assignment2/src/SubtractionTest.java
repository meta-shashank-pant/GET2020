import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class SubtractionTest {
	private String fInput1;
	private String fInput2;
    private String fExpected;

    public SubtractionTest(String input1, String input2, String expected) {
        this.fInput1 = input1;
        this.fInput2 = input2;
        this.fExpected = expected;
    }

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
        		{"8AB", "B78", "-2cd"},
        		{"adf", "fda", "-4fb"},
        		{"1234", "5678", "-4444"},
        		{"fabcdef", "fedcba", "eacf135"},
        		{"fa00", "b00", "ef00"},
        		{"a1000", "2000", "9f000"},
        		{"0", "0", "0"}});
    }
    
    @Test
    public void test() {
    	HexCalc cal = new HexCalc();
        assertEquals(fExpected, cal.subtraction(fInput1, fInput2));
    }

}

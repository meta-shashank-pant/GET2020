import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class HexToDecTest {
	private String fInput;
	private int fExpected;
    public HexToDecTest(String input, int expected) {
        this.fInput = input;
        this.fExpected = expected;
    }

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
        		{"8AB", 2219},
        		{"adf", 2783},
        		{"1234", 4660},
        		{"fabcdef", 262917615},
        		{"fa00", 64000},
        		{"a1000", 659456}});
    }
    
    @Test
    public void test() {
    	HexCalc cal = new HexCalc();
        assertEquals(fExpected, cal.hexadecimalToDecimal(fInput));
    }

}

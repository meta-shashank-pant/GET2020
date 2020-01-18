import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class DecToHexTest {
	private int fInput;
	private String fExpected;
    public DecToHexTest(int input, String expected) {
        this.fInput = input;
        this.fExpected = expected;
    }

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
        		{ 2219, "8AB"},
        		{ 2783, "ADF"},
        		{ 4660, "1234"},
        		{ 262917615, "FABCDEF"},
        		{ 64000, "FA00"},
        		{ 659456, "A1000"}});
    }
    
    @Test
    public void test() {
    	HexCalc cal = new HexCalc();
        assertEquals(fExpected, cal.decToHexa(fInput));
    }

}

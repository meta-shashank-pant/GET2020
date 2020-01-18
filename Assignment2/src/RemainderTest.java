import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class RemainderTest {
	private String fInput1;
	private String fInput2;
    private String fExpected;

    public RemainderTest(String input1, String input2, String expected) {
        this.fInput1 = input1;
        this.fInput2 = input2;
        this.fExpected = expected;
    }

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
        		{"8AB", "B78", "8ab"},
        		{"adf", "fda", "adf"},
        		{"1234", "5678", "1234"},
        		{"fabcdef", "fedcba", "bcdf09"},
        		{"fa00", "b00", "800"},
        		{"a1000", "2000", "1000"}});
    }
    
    @Test
    public void test() {
    	HexCalc cal = new HexCalc();
        assertEquals(fExpected, cal.remainder(fInput1, fInput2));
    }

}

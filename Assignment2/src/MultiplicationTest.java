import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class MultiplicationTest {
	private String fInput1;
	private String fInput2;
    private String fExpected;

    public MultiplicationTest(String input1, String input2, String expected) {
        this.fInput1 = input1;
        this.fInput2 = input2;
        this.fExpected = expected;
    }

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
        		{"8AB", "B78", "636928"},
        		{"adf", "fda", "ac52e6"},
        		{"1234", "5678", "6260060"},
        		{"fabc", "fedc", "f99e0190"},
        		{"fa00", "b00", "abe0000"},
        		{"a100", "2000", "14200000"},
        		{"0", "0", "0"}});
    }
    
    @Test
    public void test() {
    	HexCalc cal = new HexCalc();
        assertEquals(fExpected, cal.multiplication(fInput1, fInput2));
    }

}

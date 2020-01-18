import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class CompareTest {
	private String fInput1;
	private String fInput2;
    private String fExpected;

    public CompareTest(String input1, String input2, String expected) {
        this.fInput1 = input1;
        this.fInput2 = input2;
        this.fExpected = expected;
    }

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
        		{"8AB", "B78", "B78"},
        		{"adf", "fda", "fda"},
        		{"1234", "5678", "5678"},
        		{"fabcdef", "fedcba", "fabcdef"},
        		{"fa00", "b00", "fa00"},
        		{"a1000", "2000", "a1000"},
        		{"dfe", "dfe", "Both numbers are equal."}});
    }
    
    @Test
    public void test() {
    	HexCalc cal = new HexCalc();
        assertEquals(fExpected, cal.compare(fInput1, fInput2));
    }

}

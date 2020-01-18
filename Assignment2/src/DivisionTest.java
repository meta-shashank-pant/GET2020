import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class DivisionTest {
	private String fInput1;
	private String fInput2;
    private String fExpected;

    public DivisionTest(String input1, String input2, String expected) {
        this.fInput1 = input1;
        this.fInput2 = input2;
        this.fExpected = expected;
    }

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
        		{"8AB", "B78", "0"},
        		{"adf", "fda", "0"},
        		{"1234", "5678", "0"},
        		{"fabcdef", "fedcba", "f"},
        		{"fa00", "b00", "16"},
        		{"a1000", "2000", "50"}});
    }
    
    @Test
    public void test() {
    	HexCalc cal = new HexCalc();
        assertEquals(fExpected, cal.division(fInput1, fInput2));
    }

}

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class AdditionTest {
	private String fInput1;
	private String fInput2;
    private String fExpected;

    public AdditionTest(String input1, String input2, String expected) {
        this.fInput1 = input1;
        this.fInput2 = input2;
        this.fExpected = expected;
    }

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
        		{"8AB", "B78", "1423"},
        		{"adf", "fda", "1ab9"},
        		{"1234", "5678", "68ac"},
        		{"abcdef", "fedcba", "1aaaaa9"},
        		{"a00", "b00", "1500"},
        		{"1000", "2000", "3000"}});
    }
    
    @Test
    public void test() {
    	HexCalc cal = new HexCalc();
        assertEquals(fExpected, cal.addition(fInput1, fInput2));
    }

}

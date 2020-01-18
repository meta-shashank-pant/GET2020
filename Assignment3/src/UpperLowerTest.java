import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class UpperLowerTest {
	private String fInput;
    private String fExpected;

    public UpperLowerTest(String input, String expected) {
        this.fInput = input;
        this.fExpected = expected;
    }

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
        		{"Shashank", "sHASHANK"},
        		{"AbCdEf", "aBcDeF"},
        		{"a", "A"},
        		{"", ""},
        		{"qwerty", "QWERTY"},
        		{"HJKLPOIUYT", "hjklpoiuyt"},
        		{"EDCvfrTGBnhyUJMkiOLp", "edcVFRtgbNHYujmKIolP"}});
    }
    
    @Test
    public void test() {
    	Strings string = new Strings();
        assertEquals(fExpected, string.replace_lowercase_uppercase(fInput));
    }

}

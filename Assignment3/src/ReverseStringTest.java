import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class ReverseStringTest {
	private String fInput;
    private String fExpected;

    public ReverseStringTest(String input, String expected) {
        this.fInput = input;
        this.fExpected = expected;
    }

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
        		{"Shashank", "knahsahS"},
        		{"qwertyuiop", "poiuytrewq"},
        		{"a", "a"},
        		{"", ""},
        		{"asdfghjkl", "lkjhgfdsa"},
        		{"ZXCVBNM", "MNBVCXZ"},
        		{"qazxswedcvfrtgbnhyujmkiolp", "ploikmjuyhnbgtrfvcdewsxzaq"}});
    }
    
    @Test
    public void test() {
    	Strings string = new Strings();
        assertEquals(fExpected, string.reverse(fInput));
    }

}

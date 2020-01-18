import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)

public class SquareTest {
	private double fInput;
    private double fExpected;

    public SquareTest(double input, double expected) {
        this.fInput = input;
        this.fExpected = expected;
    }

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
        		{8.0, 64.0},
        		{1.0, 1.0},
        		{0.0, 0.0},
        		{7.0, 49.0},
        		{9.0, 81.0},
        		{25.0, 625.0}});
    }
    
	@Test
    public void test() {
    	Area area = new Area();
        assertEquals(fExpected, area.square(fInput), 0.1);
    }

}

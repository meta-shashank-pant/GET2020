import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)

public class CircleTest {
	private double fInput;
    private double fExpected;

    public CircleTest(double input, double expected) {
        this.fInput = input;
        this.fExpected = expected;
    }

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
        		{8.0, 200.96},
        		{1.0, 3.14},
        		{0.0, 0.0},
        		{7.0, 153.86},
        		{9.0, 254.34},
        		{25.0, 1962.5}});
    }
    
	@Test
    public void test() {
    	Area area = new Area();
        assertEquals(fExpected, area.circle(fInput), 0.1);
    }

}

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)

public class TriangleTest {
	private double fInput1;
	private double fInput2;
    private double fExpected;

    public TriangleTest(double input1, double input2, double expected) {
        this.fInput1 = input1;
        this.fInput2 = input2;
        this.fExpected = expected;
    }

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
        		{8.0, 8.0, 32.0},
        		{1.0, 0.0, 0.0},
        		{0.0, 1.0, 0.0},
        		{0.0, 0.0, 0.0},
        		{12.0, 10.0, 60.0},
        		{100.0, 134.0, 6700.0}});
    }
    
    @Test
    public void test() {
    	Area area = new Area();
        assertEquals(fExpected, area.triangle(fInput1, fInput2), 0.1);
    }
}

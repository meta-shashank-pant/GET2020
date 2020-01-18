import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)

public class RectangleTest {
	private double fInput1;
	private double fInput2;
    private double fExpected;

    public RectangleTest(double input1, double input2, double expected) {
        this.fInput1 = input1;
        this.fInput2 = input2;
        this.fExpected = expected;
    }

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
        		{8.0, 8.0, 64.0},
        		{1.0, 0.0, 0.0},
        		{0.0, 1.0, 0.0},
        		{0.0, 0.0, 0.0},
        		{12.0, 10.0, 120.0},
        		{100.0, 134.0, 13400.0}});
    }
    
    @Test
    public void test() {
    	Area area = new Area();
        assertEquals(fExpected, area.rectangle(fInput1, fInput2), 0.1);
    }
}

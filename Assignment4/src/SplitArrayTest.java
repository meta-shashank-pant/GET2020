import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class SplitArrayTest {
	private int fInput[];
    private int fExpected;

    public SplitArrayTest(int input[], int expected) {
        this.fInput = input;
        this.fExpected = expected;
    }

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { new int[] { 1, 1, 1, 2, 1 }, 3 },
                { new int[] { 2, 1, 1, 2, 1 }, -1 },
                { new int[] { 10, 10 }, 1 },
                { new int[] { 20, 5, 5, 5, 5}, 1},
                { new int[] { 1 , 1, 11, 1, 1, 11, 1, 11, 1, 1, 1, 1, 1, 1, 1, 11, 1, 1, 1, 1, 1, 1, 1, 11, 1, 11, 1, 1, 1, 1}, 15},
                { new int[] { 1, 2, 3, 4, 10}, 4},
                { new int[] { 2,3,45,6,2,3235,454,656,545,334,2343,5,6564,34334,3,1}, -1},
                { new int[] { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 
                		1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, 27}});
    }

    @Test
    public void test() {
        ArrOperation arr_operation = new ArrOperation();
        assertEquals(fExpected, arr_operation.splitArray(fInput));
    }
}

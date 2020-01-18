import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class FixXY_Test {
	private int fInput[];
    private int fExpected[];

    public FixXY_Test(int finput[], int expected[]) {
        this.fInput = finput;
        this.fExpected = expected;
    }

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { new int[] { 5, 4, 9, 4, 9, 5 }, new int[] { 9, 4, 5, 4, 5, 9 } },
                { new int[] { 1, 4, 1, 5 }, new int[] { 1, 4, 5, 1 } },
                { new int[] { 1, 4, 1, 5, 5, 4, 1 }, new int[] { 1, 4, 5, 1, 1, 4, 5 } },
                { new int[] { 4, 5, 4, 5 }, new int[] { 4, 5, 4, 5 }},
                { new int[] {1}, new int[] {1}}});
    }

    @Test
    public void test() {
    	ArrOperation arr_operation = new ArrOperation();
        assertArrayEquals(fExpected, arr_operation.fixXY(fInput));
    }}

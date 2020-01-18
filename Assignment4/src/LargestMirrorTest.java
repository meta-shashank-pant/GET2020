
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class LargestMirrorTest {

    private int fInput[];
    private int fExpected;

    public LargestMirrorTest(int input[], int expected) {
        this.fInput = input;
        this.fExpected = expected;
    }

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { new int[] { 1, 2, 3, 8, 9, 3, 2, 1 }, 3 },
                { new int[] { 7, 1, 4, 9, 7, 4, 1 }, 2 },
                { new int[] { 1, 2, 1, 4 }, 3 },
                { new int[] { 1, 4, 5, 3, 5, 4, 1 }, 7 },
                { new int[] {1,2,1,3,4,5,6,3,4,3,4,7,8,4,1,2,4,5,6,7,8,9,7,6,5,4,1,8,9,5,3} , 4},
                { new int[] {1}, 1},
                { new int[] {}, 0}});
    }
    
    @Test(expected = AssertionError.class)
    public void testForException(){
    	ArrOperation arr_operation = new ArrOperation();
    	arr_operation.maxMirror(new int[0]);
    }
    
    @Test
    public void test() {
    	ArrOperation arr_operation = new ArrOperation();
        assertEquals(fExpected, arr_operation.maxMirror(fInput));
    }

}

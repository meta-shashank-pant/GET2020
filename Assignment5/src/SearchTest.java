import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;


@RunWith(Parameterized.class)
public class SearchTest {

    private int firstInput[];
    private int startIndex;
    private int endIndex;
    private int find_val;
    private int fExpected;

    public SearchTest(int firstinput[], int secondinput, int thirdinput, int fourthinput, int expected) {
        this.firstInput = firstinput;
        this.startIndex = secondinput;
        this.endIndex = thirdinput;
        this.find_val = fourthinput;
        this.fExpected = expected;
    }

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { new int[]{ 1, 2, 3, 4, 5, 6, 7 }, 0, 6 , 2, 1},
                { new int[]{ 1, 4, 5, 7, 9, 16, 17 }, 0, 6 , 7, 3},
                { new int[]{ 1, 4, 6, 17, 29, 33, 55 }, 0, 6 , 33, 5},
                { new int[]{ 1, 14, 22, 37, 49, 53, 65 }, 0, 6, 65, 6} });
    }

    @Test
    public void testBinarySearch() {
        Search binarySearch = new Search();
        assertEquals(fExpected, binarySearch.binarySearch(firstInput, startIndex, endIndex, find_val));
    }
    
    @Test
    public void testLinearSearch() {
        Search linearSearch = new Search();
        assertEquals(fExpected, linearSearch.linearSearch(firstInput, find_val, startIndex));
    }

}
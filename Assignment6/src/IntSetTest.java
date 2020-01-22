import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class IntSetTest {

    private IntSet fInput;
    private IntSet sInput;
    private int fExpected[];
    private boolean isTrue;
    private int size;
    private int mem;
    private boolean isMem;
    private int[] complement;

    public IntSetTest(IntSet finput, IntSet sinput, int expected[], boolean isTrue, int size, int mem, boolean isMem, int[] complement) {
        this.fInput = finput;
        this.sInput = sinput;
        this.fExpected = expected;
        this.isTrue = isTrue;
        this.size = size;
        this.mem = mem;
        this.isMem = isMem;
        this.complement = complement;
    }

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { new IntSet(new int[]{ 1, 3, 6, 2}, 4), new IntSet(new int[]{8, 9, 11, 13}, 4), new int[]{1, 2, 3, 6, 8, 9, 11, 13}, 
                	false, 4, 6, true, new int[]{0,4,5,7,8,9,10}},
                { new IntSet(new int[]{ 1, 6, 2, 9}, 4),  new IntSet(new int[]{ 11, 13, 16, 12}, 4), new int[]{1, 2, 6, 9, 11, 12, 13, 16}, 
                	false, 4, 5, false, new int[]{0,3,4,5,7,8,10}},
                { new IntSet(new int[]{3, 1, 2, 6}, 4), new IntSet(new int[]{ 1, 3, 6, 2}, 4), new int[]{1,2,3,6}, 
                	true, 4, 1, true, new int[]{0,4,5,7,8,9,10} },
                { new IntSet(new int[]{1}, 1), new IntSet(new int[]{3, 6, 2}, 3), new int[]{1,2,3,6}, 
                	false, 1, 2, false, new int[]{0,2,3,4,5,6,7,8,9,10}} });
    }
    
    @Test
    public void testSize() {
    	int result = fInput.getSize();
        assertEquals(result, size);
    }

    @Test
    public void testUnion() {
    	int result[] = IntSet.union(fInput, sInput);
        assertArrayEquals(fExpected, result);
        
    }
 
    @Test
    public void testComplement() {
    	int result[] = fInput.getComplement();
        assertArrayEquals(complement, result);
        
    }
    
    @Test
    public void testSubSet() {
    	boolean result = IntSet.isSubset(fInput, sInput);
    	int exp_true = 0;
    	int act_true = 0;
    	if(isTrue)
    		act_true = 1;
    	if(result)
    		exp_true = 1;
        assertEquals(act_true, exp_true);
    }
    
    @Test
    public void testIsMem() {
    	boolean result = fInput.isMember(mem);
    	int exp_true = 0;
    	int act_true = 0;
    	if(isMem)
    		act_true = 1;
    	if(result)
    		exp_true = 1;
        assertEquals(act_true, exp_true);
    }

}
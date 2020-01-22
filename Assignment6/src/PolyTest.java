import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class PolyTest {

    private Poly fInput;
    private Poly sInput;
    private String fExpected;
    private double eval_in;
    private double exp_eval;
    private String expectedAdd;
    private int exp_degree;
    
    public PolyTest(Poly finput,Poly sinput,String expected, String expectedAdd, int exp_degree){
            this.fInput=finput;
            this.sInput=sinput;
            this.fExpected=expected;
            this.expectedAdd = expectedAdd;
            this.exp_degree = exp_degree;
    }
    
    @Parameters
    public static Collection<Object[]> data(){
            return Arrays.asList(new Object[][] {
                    {new Poly(new int[] {1, 1, 1},new int[] {0, 1, 3}, 3),new Poly(new int[]{1, 1, 1},new int[]{0, 1, 2},3),
                    	"1x^5 + 1x^4 + 2x^3 + 2x^2 + 2x^1 + 1x^0", "1x^3 + 1x^2 + 2x^1 + 2x^0", 3},
                    {new Poly(new int[] {1, 1, 1},new int[] {1, 2, 3}, 3),new Poly(new int[]{1, 1, 1},new int[]{1, 2, 4}, 3),
                    		"1x^7 + 1x^6 + 2x^5 + 2x^4 + 2x^3 + 1x^2", "1x^4 + 1x^3 + 2x^2 + 2x^1",3}
                    });
    }
    
    @Test
    public void testDegree(){
    	int result = fInput.getMaxDegree();
        assertEquals(exp_degree,result);
    }

    @Test
    public void testMultiply() {
            String result = Poly.multiplyPoly(fInput,sInput);
            assertEquals(fExpected,result);
    }
    
    @Test
    public void testAdd() {
            String result = Poly.addPoly(fInput,sInput);
            assertEquals(expectedAdd,result);
    }
    
    @Test
    public void testEvaluate1() {
    	int arr1[] = {1,1,1};
    	int arr2[] = {3,1,0};
    	exp_eval = 11.0;
    	eval_in = 2.0;
    	Poly p = new Poly(arr1,arr2,3);
    	assertEquals(exp_eval, p.evaluate(eval_in),0.1);
    }
    
    @Test
    public void testEvaluate2() {
    	int arr1[] = {1,1,1};
    	int arr2[] = {1,2,3};
    	exp_eval = 14.0;
    	eval_in = 2.0;
    	Poly p = new Poly(arr1,arr2,3);
    	assertEquals(exp_eval, p.evaluate(eval_in),0.1);
    }

}
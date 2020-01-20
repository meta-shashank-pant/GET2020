import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;


@RunWith(Parameterized.class)
public class MathProblemTest {

    private int fInput;
    private int sInput;
    private int fExpectedHCF;
    private int fExpectedLCM;

    public MathProblemTest(int finput, int sinput,int expectedHCF, int expectedLCM) {
        this.fInput = finput;
        this.sInput = sinput;
        this.fExpectedHCF = expectedHCF;
        this.fExpectedLCM = expectedLCM;
    }

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { 12, 18, 6, 36 },
                { 126, 183, 3, 7686 },
                { 213, 101, 1, 21513 },
                { 106, 130, 2, 6890 } });
    }

    @Test
    public void testHCF() {
        MathProblem math = new MathProblem();
        assertEquals(fExpectedHCF, math.hcf(fInput, sInput));
    }
    
    @Test
    public void testLCM() {
        MathProblem math = new MathProblem();
        assertEquals(fExpectedLCM, math.lcm(fInput, sInput));
    }

}
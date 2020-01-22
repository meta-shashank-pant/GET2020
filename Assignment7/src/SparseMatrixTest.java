import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;


@RunWith(Parameterized.class)
public class SparseMatrixTest {

    private int fInput[][];
    private int sInput;
    private int tInput;
    private int fExpected[][];
    private boolean isSymm;
    private int secondInp[][];
    private int secondrow, secondcol;
    private int add_result[][];

    public SparseMatrixTest(int finput[][], int sinput, int tinput, int expected[][], boolean isSymm, int secondInp[][], int srow, int scol, int add_res[][]) {
        this.fInput = finput;
        this.sInput = sinput;
        this.tInput = tinput;
        this.fExpected = expected;
        this.isSymm = isSymm;
        this.secondInp = secondInp;
        this.secondrow = srow;
        this.secondcol = scol;
        this.add_result = add_res;
    }

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { new int[][]{{ 2, 0, 0},
                              { 0, 1, 3}
                              }, 2,3, new int[][]{{ 2, 0},
                                                  { 0, 1},
                                                  { 0, 3}}, false, new int[][]{{0,1,0},{1,0,0}},2,3, new int[][]{{2,1,0},{1,1,3}}},
                { new int[][]{{ 10, 0 }, 
                              { 0, 5 }, 
                              { 2, 0 }},3, 2, new int[][]{{ 10, 0, 2 }, 
                                                           { 0, 5, 0 }}, false, new int[][]{{0,1},{1,0},{0,0}},3,2, new int[][]{{10,1},{1,5},{2,0}}},
                { new int[][]{{ 2, 0, 0},
                           	{ 0, 1, 3},
                           	{ 0, 3, 2}}, 3 , 3, new int[][]{{2, 0, 0},
                											{0, 1, 3},
                											{0, 3, 2}}, true, new int[][]{{0,1,0},{1,0,0},{0,0,0}},3,3, new int[][]{{2,1,0},{1,1,3},{0,3,2}} },
                { new int[][]{{ 5, 0, 0 }, 
                          	{ 0, 6, 2 }, 
                          	{ 0, 2, 5 }}, 3, 3, new int[][]{{5, 0, 0},
                											{0, 6, 2},
                											{0, 2, 5}}, true, new int[][]{{0,1,0},{1,0,0},{0,0,0}},3,3, new int[][]{{5,1,0},{1,6,2},{0,2,5}} }});
    }
    
    @Test
    public void testAdditon() {
        SparseMatrix sm = new SparseMatrix(fInput,sInput,tInput);
        SparseMatrix sm2 = new SparseMatrix(secondInp,secondrow,secondcol);
        assertArrayEquals(add_result, sm2.add(sm));
    }

    @Test
    public void testSymmetry() {
        SparseMatrix sm = new SparseMatrix(fInput,sInput,tInput);
        int act = 0, exp = 0;
        if(sm.symmetric())
        	act = 1;
        if(isSymm)
        	exp = 1;
        assertEquals(exp, act);
    }
    
    @Test
    public void testTranspose() {
        SparseMatrix tra = new SparseMatrix(fInput,sInput,tInput);
        assertArrayEquals(fExpected, tra.transpose());
    }

}

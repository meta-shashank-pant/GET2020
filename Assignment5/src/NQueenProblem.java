public class NQueenProblem {
    /**
     * Verify that queen can be place horizontal, vertical,and diagonal on the board
     *
     * @param board the first to verification the queen place
     *        board array contain number of Integer  
     * @param nQueenArray the second to verification the queen place
     *        nQueenArray array contain number of Integer which define the Queen place        
     * @param row the third  to verification the queen place  
     * @param column the fourth to verification the queen place       
     * @param dimention the fifth to verification the queen place        
     * 
     * @return boolean value 
     */
    public boolean checkNQueen(int board[][], int nQueenArray[], int row, int coloumn, int dimension) {

        //check the queen in row and column
        for (int i = 0; i < dimension; i++)
            if (board[row][i] == 1 || board[i][coloumn] == 1)
                return false;

        //check the queen in left upper diagonal
        for (int i = row, j = coloumn; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 1 || board[i][j] == 1)
                return false;

      //check the queen in right upper diagonal
        for (int i = row, j = coloumn; i >= 0 && j < dimension; i--, j++)
            if (board[i][j] == 1 || board[i][j] == 1)
                return false;

        return true;
    }

    /**
     * Place the queen on the board
     *
     * @param board the first to Place the queen on the board
     *        board array contain number of Integer  
     * @param nQueenArray the second to Place the queen on the board
     *        nQueenArray array contain number of Integer which define the Queen place        
     * @param row the third to Place the queen on the board      
     * @param dimention the fourth to Place the queen on the board        
     * 
     * @return boolean value 
     */
    public boolean nQueenPlace(int board[][], int nQueenArray[], int row, int dimension) {
        if (row == dimension) 
            return true;
        
        for (int i = 0; i < dimension; i++) {
            if (checkNQueen(board, nQueenArray, row, i, dimension)) {

                //place the queen on board
                board[row][i] = 1;
                //Queen position store in array
                nQueenArray[row] = i;

                if (nQueenPlace(board, nQueenArray, row + 1, dimension))
                    return true;

                board[row][i] = 0;
            }
        }
        return false;
    }

    /**
     * Initialize the board with zero element 
     *    
     * @param dimention the first to Initialize the board        
     * 
     * @return Integer array  
     */
    public int[] setNQueenBoard(int dimension) {
        int board[][] = new int[dimension][dimension];
        int nQueenArray[] = new int[dimension];

        for (int i = 0; i < dimension; i++)
            for (int j = 0; j < dimension; j++)
                board[i][j] = 0;

        if (nQueenPlace(board, nQueenArray, 0, dimension) == false) 
            return new int[] { -1 };

        return nQueenArray;
    }
}
package nQueens;

public class Main
{
	public static int n = 10;

	static boolean isAbleToPlace(String board[][], int row, int col) 
	{
		int i, j;
		
		// Check row on left side
		for (i = 0; i < col; i++) 
		{
			if (board[row][i].equals("Q")) 
            {
                return false;
            }
		}
		
		// Check upper diagonal on left side
		for (i = row, j = col; i >= 0 && j >= 0; i--, j--) 
		{
			if (board[i][j].equals("Q")) 
			{
				return false;
			}
		}
		
		// Check lower diagonal
		for (i = row, j = col; j >= 0 && i < n; i++, j--) 
		{
			if (board[i][j].equals("Q")) 
			{
				return false;
			}
		} 
         
		return true;
	}
	
	static boolean solveUtil(String board[][], int col) 
	{
		if (col >= n) 
		{
			return true;
		}
		
		for (int i = 0; i < n; i++) 
		{
			if (isAbleToPlace(board, i, col)) 
			{
				board[i][col] = "Q";
				
				if (solveUtil(board, col + 1)) 
				{
					return true;
				}
				
				board[i][col] = "E";
			}
		}
		
		return false;
	}
	
	static boolean solve() 
	{
		String[][] board = new String[n][n];
		
		// Initialize the board to all E for empty
		for (int i = 0; i < n; i++) 
		{
			for (int j = 0; j < n; j++) 
			{
				board[i][j] = "E";
			}
		}
		
		if (solveUtil(board, 0) == false) 
		{
			System.out.println("ERROR: solution does not exist");
			return false;
		}
		
		printSolution(board);
		
		return true;
	}
	
    static void printSolution(String board[][]) 
    { 
        for (int i = 0; i < n; i++) { 
            for (int j = 0; j < n; j++) 
                System.out.print(" " + board[i][j] 
                                 + " "); 
            System.out.println(); 
        } 
    } 
	
	public static void main(String[] args)
	{
		solve();
	}

}

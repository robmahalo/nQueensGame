package nqueens;

/**
 * @author Robby
 * @version 3.0 (19 June 2019)
 
 */

public class NQueensModel {
	
	private int myNumQueens;
	private boolean[][] myBoard;
	private int myNumSolutions;
	private boolean secondPass; //Variable that will be helpful when finding either a particular solution or all solutions
	
	/**Initializes the board, int values and the boolean that represents the second pass
	 */
	public NQueensModel(int nQueens)
	{
		myNumQueens = nQueens;
		myNumSolutions = 0;
		myBoard = new boolean[nQueens][nQueens]; //This initializes all the positions as false (as needed)
		secondPass = false; //Initializes as false, means we're not looking for a particular solution yet, but all
	}
	
	/**
	 * Method that solves the puzzle. It calls to the recursive method solvePuzzle(int col) to solve it
	 */
	public boolean solvePuzzle()
	{
		//Call solvePuzzle for the first column and that's the method that checks all the other columns for number of solutions
		solvePuzzle(0);
		
		//Call to look for an actual solution
		secondPass = true;
		boolean ans = solvePuzzle(0);
		secondPass = false;
		return ans;
		
	}
	
	/**
	 * Method that tries to check all possibilities until it finds a solution
	 */
	private boolean solvePuzzle(int col)
	{
		//As we need to the total number of solutions, and also we need one of the solutions to show
		//(saved inside myBoard), we need to make two passes for this same method. One to look for all possible
		//solutions without setting returns to stop it, and a second one to actually save the first solution
		
		//First, if the column being checked is beyond the last one, we found one solution for the puzzle
		//That means, we increase myNumSolutions in 1 and we return true.
		if(col == myNumQueens)
		{
			if(!secondPass) //If we're on the 2nd pass, we don't add a new solution, we just look for it and save it
				myNumSolutions++;
			return true;
		}
		for(int i = 0; i < myNumQueens; i++)
		{
			if(isSafeMove(i, col))
			{
				placeQueen(i, col);
				//Now, if we can solve the puzzle using this move and we're on the 2nd pass (looking for the actual solution)
				//we return true (normal method). If not, we just keep looping for another solution, so we skip the return
				//no matter if the solvePuzze(col+1) is correct, we're looking for the amount of all solutions
				if(solvePuzzle(col+1) && secondPass)
					return true;
				removeQueen(i, col);
			}
		}
	
		return false;
	}
	
	/**
	 * Method to check for a valid move
	 */
	private boolean isSafeMove(int row, int col)
	{
		//This method just calls all the checks (diagonals and left of the row), if they're true, then true
		if(checkLeft(row, col) && checkLowerDiag(row, col) && checkUpperDiag(row, col))
		{
			return true;
		}
		else
			return false;
	}
	
	/**
	 * Method that checks if a move is valid given the upper diagonal.
	 */
	private boolean checkUpperDiag(int row, int col)
	{
		//We check the upper left diagonal by knowing both indices of the diagonal are decreasing by 1
		int i = row-1;
		int j = col-1;
		while(i >= 0 && j >= 0)
		{
			if(myBoard[i][j]) //If this position is true (has a queen), directly return false
				return false;
			i--;
			j--;
		}
		
		return true;
	}
	
	/**
	 * Method that checks if a move is valid given the lower diagonal. No queens should be on it
	 */
	private boolean checkLowerDiag(int row, int col)
	{
		//We check the lower left diagonal, knowing the rows are increasing and the columns are decreasing by 1
		int i = row+1;
		int j = col-1;
		while(i < myNumQueens && j >= 0)
		{
			if(myBoard[i][j]) //If this position is true (has a queen), directly return false
				return false;
			i++;
			j--;
		}
		
		//If we get to this position, means the diagonal is clear of queens, then true
		return true;
	}
	
	/**
	 * Method that checks if the left of a row is valid for a move. No queens should be on it
	 */
	private boolean checkLeft(int row, int col)
	{
		//Here, to check all the left of the row, we do a simple loop decreasing the columns by 1
		int j = col-1;
		while(j >= 0) 
		{
			if(myBoard[row][j]) //If this position is true (has a queen), directly return false
				return false;
			j--;
		}
		
		return true;
	}
	
	/**
	 * Method that places a queen on a certain location
	 */
	private boolean placeQueen(int row, int col)
	{
		//If the position already has a queen (is true), we return false
		if(myBoard[row][col])
			return false;
		else
		{
			myBoard[row][col] = true;
			return true;
		}
	}
	
	/**
	 * Method that removes a queen of a certain location
	 */
	private boolean removeQueen(int row, int col)
	{
		//If there's a queen on the row and col, we remove it and return true
		if(myBoard[row][col])
		{
			myBoard[row][col] = false;
			return true;
		}
		else 
			return false;
	}
	
	/**
	 * Method that returns the num of solutions found
	 */
	//Method that returns the amount of solutions found
	public int getNumOfSolutions()
	{
		return myNumSolutions;
	}
	
	/**
	 * Method that returns the board for the puzzle
	 */
	public boolean[][] getBoard()
	{
		return myBoard;
	}
}

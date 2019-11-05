package testcases;

import nqueens.NQueensModel;

/**
 * Class to run few tests on the NQueensModel using known and expected results
 */
public class TestCases {
	
	/**
	 * Main method to run the tests using just comparisons
	 */
	public static void main(String[] args)
	{
		//Here, we're making some tests, using asserts, of the queens model we developed.
		//We can loop from 1 to 12 in terms of the size board and test the outputs of it
		
		//First, we do an array of the expected solutions
		int[] expected = new int[]{1,0,0,2,10,4,40,92,352,724,2680,14200};
		for(int i = 1; i <= 12; i++)
		{
			NQueensModel queens = new NQueensModel(i);
			queens.solvePuzzle();
			boolean testPassed = queens.getNumOfSolutions() == expected[i-1];
			System.out.println("For a board of N="+i+" we expect "+expected[i-1]+" solutions. "
					+ "Found: "+queens.getNumOfSolutions()+". Test passed: "+testPassed);
		}
	}

}

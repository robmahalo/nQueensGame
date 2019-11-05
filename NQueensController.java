package nqueens;

import javax.swing.JOptionPane;

public class NQueensController {

	/**
     * Initializes the main controller to ask the user for the input.
     */
	public NQueensController()
	{
		while(true)
		{
			String input = JOptionPane.showInputDialog(null,"Enter the N value for the N-Queens puzzle [1-12] or 'Q' to quit: ");
			try
			{
				if(input == null || input.equalsIgnoreCase("Q"))
					break;
				int N = Integer.parseInt(input);
				if( N < 1 || N > 12) //If input is not between 1 and 12, throw an Exception to go to the catch as well
					throw new NumberFormatException();
				//Now, if the input was correct (N value), we create a puzzle with that N and we show the results
				NQueensModel queens = new NQueensModel(N);
				queens.solvePuzzle(); //We try to solve it
				//If no solutions, we show a simple OptionPane saying no solutions
				if(queens.getNumOfSolutions() == 0)
					JOptionPane.showMessageDialog(null,"For a Queens puzzle of N="+N+" there are no solutions","RESULTS - N="+N,JOptionPane.INFORMATION_MESSAGE);
				else //Else, means we have solutions
					new NQueensView(queens.getBoard(),queens.getNumOfSolutions());
				break; //Once we show it, we break it to stop the program

			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null,"Not valid input. It must be an integer between 1 or 12","Error",JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	/**
	 * Main method
	 */
	public static void main(String[] args)
	{
		new NQueensController();
	}
}

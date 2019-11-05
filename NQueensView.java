package nqueens;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class NQueensView extends JFrame {

	/**
	 * Creates the frame, the board as a 2D-array of buttons and shows the solution
	 */
	public NQueensView(boolean[][] myBoard, int numOfSolutions)
	{
		setTitle("RESULTS - N="+myBoard.length);
		setSize(700,700);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		//We can use a label and a panel to show all results. Label for the num of total solutions, and the
		//table for the buttons that will show the actual board
		JLabel label = new JLabel("The total number of solutions for N="+myBoard.length+" is: "+numOfSolutions
				+ ". One solution is shown below.");
		label.setHorizontalAlignment(JLabel.CENTER);
		add(label,BorderLayout.NORTH);
		
	
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(myBoard.length,myBoard.length)); 
		JButton[][] board = new JButton[myBoard.length][myBoard.length];
		//Initialize all the boards with the letter Q if they have a queen, or empty if they don't
		for(int i = 0; i < board.length; i++)
		{
			for(int j = 0; j < board.length; j++)
			{
				if(myBoard[i][j]) //If true, it has a queen
					board[i][j] = new JButton("Q");
				else 
					board[i][j] = new JButton("--");
				board[i][j].setEnabled(false); 
				panel.add(board[i][j]); 
			}
		}

		add(panel,BorderLayout.CENTER);
		setVisible(true);
	}

}

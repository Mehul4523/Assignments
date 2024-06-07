package algorithms;

public class NQueenProblem {

	private static final int N = 8;
	
	// Function to solve the N Queens problem
	public static boolean SolveNQueen(int[][] board, int col) {
	 
		// Base case: If all queens are placed, return true
		if (col >= N) {
				return true;
		}
	
		// Try placing a queen in each row of the current column
		for (int i = 0; i < N; i++) {
				if (isSafe(board, i, col)) {
						// Place the queen and recursively solve for the next column
						board[i][col] = 1;
						if (SolveNQueen(board, col + 1)) {
								return true; // If a solution is found, return true
						} else {
								board[i][col] = 0; // Backtrack: Remove the queen if no solution is found
						}
				}
		}
		return false; // If no queen can be placed in this column, return false
	}
	
	// Function to check if it's safe to place a queen at board[row][col]
	private static boolean isSafe(int[][] board, int row, int col) {
			int i, j;
			
			// Check if there is a queen in the same row
			for (i = 0; i < col; i++) {
					if (board[row][i] == 1) {
							return false;
					}
			}
	
			// Check if there is a queen in the upper left diagonal
			for (i = row, j = col; i >= 0 && j >= 0; i--, j--) {
					if (board[i][j] == 1) {
							return false;
					}
			}
	
			// Check if there is a queen in the lower left diagonal
			for (i = row, j = col; j >= 0 && i < N; i++, j--) {
					if (board[i][j] == 1) {
							return false;
					}
			}
			return true; // If no conflicts, it's safe to place a queen at board[row][col]
		}
	
	// Function to print the board (0 for empty square, 1 for queen)
	private static void printSolution(int board[][]) {
			for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
							if (board[i][j] == 1)
									System.out.print("Q ");
							else
									System.out.print(". ");
					}
					System.out.println();
			}
	}
	
	public static void main(String[] args) {
			int[][] board = new int[N][N];
			
			// Initialize the board with zeros (no queens placed)
			for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
							board[i][j] = 0;
					}
			}
			System.out.println("Standard Board Size: " + N + " X " + N);
	
			// Solve the N Queens problem starting from the first column
			if (SolveNQueen(board, 0)) {
					System.out.println("Solution:");
					printSolution(board); // Print the solution if it exists
			} else {
					System.out.println("No solution exists");
			}
	}
}

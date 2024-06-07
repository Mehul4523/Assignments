package algorithms;

public class KnightsTourProblem {

		static final int N = 8; // Chessboard size (8x8)
	
		public static boolean isSafe(int board[][], int row, int col) {
				return (row >= 0 && row < N && col >= 0 && col < N && board[row][col] ==
0);
		}
		
		public static boolean solveKTUtil(int board[][], int moveX, int moveY, int
moveCount, int[] xMove, int[] yMove) {
				if (moveCount == N * N) {
						return true; // All squares visited
				}
	
				// Try all possible moves
				for (int i = 0; i < 8; i++) {
						int nextX = moveX + xMove[i];
						int nextY = moveY + yMove[i];
	
						if (isSafe(board, nextX, nextY)) {
								board[moveX][moveY] = moveCount + 1; // Mark current square visited
								if (solveKTUtil(board, nextX, nextY, moveCount + 1, xMove,
yMove)) {
										return true;
								} else {
										board[moveX][moveY] = 0; // Backtrack: Unmark if path doesn't lead to solution
								}
						}
				}
				
				return false; // No valid move found
		}
	
		public static void solveKT() {
				int board[][] = new int[N][N];
				
				// Possible knight moves (8 possible directions)
				int[] xMove = { 2, 1, -1, -2, -2, -1, 1, 2 };
				int[] yMove = { 1, 2, 2, 1, -1, -2, -2, -1 };
	
				// Start from any corner square
				board[0][0] = 1; // Mark starting position
	
				if (solveKTUtil(board, 0, 0, 1, xMove, yMove)) {
						System.out.println("Solution exists:");
						printBoard(board);
				} else {
						System.out.println("Solution does not exist");
				}
		}
	
		public static void printBoard(int board[][]) {
				for (int i = 0; i < N; i++) {
						for (int j = 0; j < N; j++) {
								System.out.print(board[i][j] + " ");
						}
						System.out.println();
				}
		}
	
		public static void main(String[] args) {
				solveKT();
		}
}

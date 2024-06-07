package algorithms;

import java.util.Arrays;

public class RatInMaze {

	private static final int N = 6;
	
	public static boolean SolveMaze(int[][] maze) {
			int[][] sol = new int[N][N];
	
			if (solveMazeUtil(maze, 0, 0, sol) == false) {
					System.out.println("Solution doesn't exist");
					return false;
			}
	
			System.out.println("Solution:");
			printSolution(sol);
			return true;
		}
	
		private static boolean solveMazeUtil(int[][] maze, int x, int y, int[][] sol)
{
				if (x == N - 1 && y == N - 1 && maze[x][y] == 1) {
						sol[x][y] = 1;
						return true;
				}
	
				if (isSafe(maze, x, y)) {
						sol[x][y] = 1;
	
						if (solveMazeUtil(maze, x + 1, y, sol))
								return true;
	
						if (solveMazeUtil(maze, x, y + 1, sol))
								return true;
					
						sol[x][y] = 0;
						return false;
				}
				return false;
		}
	
		private static boolean isSafe(int[][] maze, int x, int y) {
				return (x >= 0 && x < N && y >= 0 && y < N && maze[x][y] == 1);
		}
	
		private static void printSolution(int[][] sol) {
			for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
							if (sol[i][j] == 1) {
									System.out.print("R "); // R for right move
							}
							else {
									System.out.print("- ");
							}
					}
					System.out.println();
				}
		}
	
		public static void main(String[] args) {
				int[][] maze = { { 1, 1, 0, 0, 0, 0 }, { 1, 1, 0, 1, 0, 0 },
{ 0, 1, 1,1, 0, 0 }, { 0, 0, 0, 1, 1, 0 },
									{ 0, 0, 0, 1, 1, 1 }, { 0, 0, 0, 0, 1, 1 } };
				System.out.println("Given Maze:");
	
				for (int i = 0; i < maze.length; i++) {
						System.out.println(Arrays.toString(maze[i]));
				}
	
				SolveMaze(maze);
		}
}

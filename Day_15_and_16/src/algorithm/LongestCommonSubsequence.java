package algorithm;

public class LongestCommonSubsequence {

	public static int lcs(String text1, String text2) {
			int m = text1.length();
			int n = text2.length();
			int[][] dp = new int[m + 1][n + 1];
		
			// Initialize first row and column for base cases
			for (int i = 0; i <= m; i++) {
					dp[i][0] = 0; // Empty first string, LCS is 0
			}
			for (int j = 0; j <= n; j++) {
					dp[0][j] = 0; // Empty second string, LCS is 0
			}
		
			// Build DP table
			for (int i = 1; i <= m; i++) {
					for (int j = 1; j <= n; j++) {
							if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
								// Characters match, consider the previous match + 1
								dp[i][j] = dp[i - 1][j - 1] + 1;
							} else {
									// Characters don't match, take the max LCS from excluding either character
									dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
							}
					}
			}
			return dp[m][n];
		}
		
	public static void main(String[] args) {
		String text1 = "AGGTAB";
		String text2 = "GXTXAYBA";
		
		System.out.println("String 1: "+text1+", String 2: "+text2);
		int lcsLength = lcs(text1, text2);
		
		System.out.println("Length of Longest Common Subsequence: " +
lcsLength);
		}
}

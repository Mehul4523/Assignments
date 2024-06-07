package algorithms;

public class Boyre_MooreAlgorithm {

	public static int lastOccurrence(String text, String pattern) {
		
		int[] badChar = new int[256];
		badCharHeuristic(pattern, badChar);
		
		int m = pattern.length();
		int n = text.length();
		int shift = 0;
		int lastOccurrenceIndex = -1;
		
		while (shift <= (n - m)) {
			int j = m - 1;
			while (j >= 0 && pattern.charAt(j) == text.charAt(shift + j)) {
					j--;
			}
		
			if (j < 0) {
					lastOccurrenceIndex = shift;
					shift += (shift + m < n) ? m - badChar[text.charAt(shift +
m)] : 1;
			} else {
					shift += Math.max(1, j - badChar[text.charAt(shift + j)]);
			}
		}
		return lastOccurrenceIndex;
	}
		
	private static void badCharHeuristic(String str, int[] badChar) {
		for (int i = 0; i < 256; i++) {
				badChar[i] = -1;
		}
		
		for (int i = 0; i < str.length(); i++) {
				badChar[str.charAt(i)] = i;
		}
	}
		
	public static void main(String[] args) {
		String text = "ABCAABBCCABCABCD";
		String pattern = "ABC";
		
		System.out.println("Given String: " + text);
		System.out.println("Pattern: " + pattern);
		
		int index = lastOccurrence(text, pattern);
		System.out.println("Last occurrence of the pattern is at index: " +
index);
		}
}

package algorithms;

public class KMPSearchAlgorithm {

	public static void KMPSearch(String pattern, String text) {
		int patternLength = pattern.length();
		int textLength = text.length();
		
		int[] lps = new int[patternLength];
		computeLPSArray(pattern, patternLength, lps);
		
		int i = 0;
		int j = 0;
		while (i < textLength) {
				if (pattern.charAt(j) == text.charAt(i)) {
						i++;
						j++;
				}
				if (j == patternLength) {
					System.out.println("Pattern found at index " + (i - j));
					j = lps[j - 1];
				}else if (i < textLength && pattern.charAt(j) != text.charAt(i)){
						if (j != 0) {
								j = lps[j - 1];
						} else {
								i++;
						}
				}
			}
		}
		
	private static void computeLPSArray(String pattern, int length, int[] lps) {
		int len = 0;
		int i = 1;
		lps[0] = 0;
	
		while (i < length) {
			if (pattern.charAt(i) == pattern.charAt(len)) {
					len++;
					lps[i] = len; i++;
			} else {
					if (len != 0) {
						len = lps[len - 1];
					} else {
							lps[i] = 0;
							i++;
					}
				}
			}
		}

	public static void main(String[] args) {
		String text = "ABABDABACDABABCABAB";
		String pattern = "ABABCABAB";

		System.out.println("Given String: " + text);
		System.out.println("Pattern: " + pattern);
	
		KMPSearch(pattern, text);
	}
}

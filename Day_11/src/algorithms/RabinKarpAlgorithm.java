package algorithms;

public class RabinKarpAlgorithm {

	private final int d = 256; // Number of characters in the input alphabet
	
	public int search(String text, String pattern) {
		int textLength = text.length();
		int patternLength = pattern.length();
	
		// A prime number for modulo operation (can be changed)
		int prime = 101;
	
		// Calculate hash values of pattern and first window of text
		int patternHash = calculateHash(pattern, patternLength, prime);
		int textHash = calculateHash(text, patternLength, prime);
		int hash = 1; // d^(patternLength - 1) for calculating rolling hash
	
		for (int i = 1; i < patternLength; i++) {
				hash = (hash * d) % prime;
		}
	
		// Slide the pattern window over the text
		for (int i = 0; i <= textLength - patternLength; i++) {
			// Check if hash values match
			if (patternHash == textHash) {
					// Potential match, compare individual characters
					boolean isMatch = true;
					for (int j = 0; j < patternLength; j++) {
						if (text.charAt(i + j) != pattern.charAt(j)) {
								isMatch = false;
								break;
						}
					}
					if (isMatch) {
						return i; // Pattern found at index i
					}
			}
			// Update text hash for the next window using rolling hash
			if (i < textLength - patternLength) {
				textHash = (textHash + prime - hash * text.charAt(i)) %
prime;
				textHash = (textHash * d) % prime;
				textHash = (textHash + text.charAt(i + patternLength)) %
prime;
			}
		}
		// Pattern not found
		return -1;
	}

	private int calculateHash(String str, int length, int prime) {
		int hash = 0;
		for (int i = 0; i < length; i++) {
				hash = (hash * d + str.charAt(i)) % prime;
		}
		return hash;
	}
	
	public static void main(String[] args) {
		String text = "Go Simon Go";
		String pattern = "Simon";
	
		System.out.println("Given String: " + text);
		System.out.println("Pattern: " + pattern);
	
		RabinKarpAlgorithm rk = new RabinKarpAlgorithm();
		int index = rk.search(text, pattern);
	
		if (index == -1) {
				System.out.println("Pattern not found");
		} else {
				System.out.println("Pattern found at index: " + index);
		}
	}
}

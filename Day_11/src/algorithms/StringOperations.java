package algorithms;

public class StringOperations {

	public static String getMiddleSubString(String str1, String str2,
int substringlength) {
			if(str1.isEmpty() || str2.isEmpty()) {
			
			return "Empty String(s) provided";
			}
			String concatenatedString = str1.concat(str2);
			int total_Length = concatenatedString.length();
		
			if(substringlength > total_Length) {
				return "Substirng length exceeds concatenated string length";
			}
		
			int startIndex = (total_Length - substringlength) / 2;
			int endIndex = startIndex + substringlength;
		
			StringBuilder reversedString = new 
StringBuilder(concatenatedString).reverse();
		
			return reversedString.substring(startIndex, endIndex);	
		}
	
	public static void main(String[] args) {		
		String input1 = "This is";
		String input2 = "Mehul, Hi guys";
		int length = 5;
		
		System.out.println("Input Strings: "+ input1 + ", "+ input2);
		System.out.println("Substinr Lenght: "+length);
		System.out.println("Reverse concatenated String: "+ new 
StringBuilder(input1 + input2).reverse());
		
		String result = getMiddleSubString(input1, input2, length);
		System.out.println("Reverse Middle SubString: "+ result);
	}
}

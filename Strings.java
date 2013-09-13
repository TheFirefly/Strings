public class Strings {
	
	public static void main(String[] args) {
		
		//System.out.println("Number of e's in people: " + count("people", "e"));
		//System.out.println("Racecar is a palindrome: " + isPalindrome("Racecar"));
		//System.out.println("Alpp is Abecedarian: " + isAbecedarian("Alpp"));
		//System.out.println("Ssaabb is a dupledrome: " + isDupledrome("Ssaabb"));
		String s = "Test";
		System.out.println(s + ": " + captainCrunch(s));
	}

	private static boolean isAbecedarian(String s) {
		s = s.toLowerCase();
		char lastChar = s.charAt(0);
		for (int i = 0 ; i < s.length() ; i++) {
			if (s.charAt(i) >= lastChar) {
				lastChar = s.charAt(i);
				continue;
			} else {
				return false;
			}
		}

		return true;
	}

	private static boolean isDupledrome(String s) {
		s = s.toLowerCase();

		if (s.length() % 2 != 0) {
			return false;
		}
		for (int i = 0 ; i < s.length() ; i+=2) {
			System.out.println("Substring: " + s.substring(i, i+2));
			if (s.substring(i, i + 2).charAt(0) != s.substring(i, i + 2).charAt(1)) {
				return false;
			}
		}
		return true;
	}

	private static String captainCrunch(String s) {
		s = s.toLowerCase();
		String code = new String();
		for (int i = 0 ; i < s.length() ; i++) {
			char c = s.charAt(i);
			if (c + 13 > 'z') {

				code += String.valueOf((char)('a' + (12 - ('z'-c))));
			} else {
				code += String.valueOf((char)(c + 13));
			}
		}

		return code;
	}

	private static int count(String s, String t) {
		int count = 0;

		for (int i = 0 ; i <= s.length() - t.length() ; i++) {
			if (s.substring(i, i + t.length()).equals(t)) {
				count++;
			}
		}

		return count;
	}

	private static boolean hasAnA(String s) {
		for (int i = 0 ; i < s.length() ; i++) {
			if (s.substring(i, i+1).equalsIgnoreCase("A")) {
				return true;
			}
		}

		return false;
	}

	private static boolean isPalindrome(String s) {
		boolean isPalindrome = true;

		for (int i = s.length() - 1, j = 0 ; i >= s.length() / 2 ; i--, j++) {
			isPalindrome = s.substring(i, i+1).equalsIgnoreCase(s.substring(j, j+1));

			if (!isPalindrome) {
				return false;
			}
		}

		return isPalindrome;
	}

	private static boolean contains(String s, String t) {

		for (int i = 0 ; i < s.length() - t.length() + 1 ; i++) {
			if (s.substring(i, i + t.length()).equals(t)) {
				return true;
			}
		}

		return false;
	}
}
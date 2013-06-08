package Arrays_and_Strings;

public class E1_8_isRotation {

	// Solution 1 自己根据Xiaolin教的写的
	// 跟E1_4中的solution 2是一样的
	public static boolean isRotation(String s, String t) {
		if (s.length() != t.length())
			return false;
		s += s;
		return s.contains(t);
	}

	// test
	public static void main(String[] args) {
		String test = "abcd";
		String test1 = "bcda";
		System.out.println(isRotation1(test, test1));
	}

	// Solution 2 From Cracking
	//有个“isSubstring”函数，可以自己构造一个
	public static boolean isRotation1(String s1, String s2) {
		int len = s1.length();
		/* check that s1 and s2 are equal length and not empty */
		if (len == s2.length() && len > 0) {
			/* concatenate s1 and s1 within new buffer */
			String s1s1 = s1 + s1;
			return isSubstring(s1s1, s2);
		}
		return false;
	}
	public static boolean isSubstring(String s, String t) {
		return s.contains(t);
	}
}

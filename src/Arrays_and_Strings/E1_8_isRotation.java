package Arrays_and_Strings;

public class E1_8_isRotation {

	// Solution 1 �Լ�����Xiaolin�̵�д��
	// ��E1_4�е�solution 2��һ����
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
	//�и���isSubstring�������������Լ�����һ��
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

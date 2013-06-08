package Arrays_and_Strings;

/*
 * 1.2 Write code to reverse a C-Style String.
 * (C-String means that “abcd” is represented as five characters,
 * including the null character.)
 */


public class E1_2_reverse {
	//Solution 1 自己写的
	public static char[] reverse(String str) {
		
		int end = str.length() - 1;
		char[] str_Array = str.toCharArray();
		
		for (int start = 0; start < str.length() / 2; start++) {
			
			char temp = str_Array[start];
			str_Array[start] = str_Array[end];
			str_Array[end] = temp;
			
			end--;
		}
		return str_Array;
	}
	
	//test
	public static void main(String[] args) {
		String test = "abcdef";
		System.out.println(reverse2(test));
	}
	
	//Solution 2 自己写的
	//建立一个新数组，然后倒序插入
	public static char[] reverse1(String str) {
		char[] new_str = new char[str.length()];
		for (int i = 0; i < str.length(); i++) {
			new_str[str.length() - i - 1] = str.charAt(i);
		}
		return new_str;
	}
	
	//Solution 3 From Xiaolin, Similar to Solution 2 but better
	//建立一个新字符串，然后倒序插入
	public static String reverse2(String str) {
		String new_str = "";
		for (int i = 0; i < str.length(); i++) {
			new_str += str.charAt(str.length() - i - 1);
		}
		return new_str;
	}
}

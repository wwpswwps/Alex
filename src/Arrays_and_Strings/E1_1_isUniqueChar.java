package Arrays_and_Strings;

import java.util.Arrays;

//1.1 Implement an algorithm to determine if a string has all unique characters.
//What if you can not use additional data structures?

public class E1_1_isUniqueChar {
	
	//solution 1
	//Time Complexity: O(n); Space: O(n)
	public static boolean isUniqueChar(String str){
		boolean[] char_set = new boolean[256];
		for (int i = 0; i < str.length(); i++) {
			int val = str.charAt(i);
			if (char_set[val]) return false;
			char_set[val] = true;
		}
		return true;
	}
	
	//test
	public static void main(String[] args) {
		String test = "pdj";
		System.out.println(isUniqueChar3(test));
	}
	
	//Solution 2
	//Time: O(n)
	public static boolean  isUniqueChar2(String str) {
		int checker = 0;
		for (int i = 0; i < str.length(); ++i) {
			int val = str.charAt(i) - 'a';
			if((checker & (1 << val)) > 0) return false;//"1<<val"是说1向左移动val位
			checker |= (1 << val);
		}
		return true;
	}
	
	//Solution 3
	public static boolean isUniqueChar3(String str) {
		char[] temp = str.toCharArray();
		Arrays.sort(temp);//Time: O(nlogn); May take extra space
		for (int i = 0; i < temp.length - 1; i++) {
			if (temp[i] == temp[i+1]) return false;
		}
		return true;
	}
}

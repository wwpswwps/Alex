package Arrays_and_Strings;

import java.util.Arrays;

/*
 * 1.4 Write a method to decide if two strings are anagrams or not.
 * anagram的意思是两个字符串的长度相同，然后都由相同的字母组成
 * 只是字母的顺序可以不一样
 */

public class E1_4_anagram {

	// Solution 1 From Cracking
	public static boolean anagram(String s, String t) {
		if (s.length() != t.length())
			return false;
		char[] temp = s.toCharArray();
		char[] temp1 = t.toCharArray();
		Arrays.sort(temp);
		Arrays.sort(temp1);
		return (String.valueOf(temp)).equals(String.valueOf(temp1));
	}

	public static void main(String[] args) {
		String test = "abcd";
		String test1 = "adcb";
		System.out.println(anagram2(test, test1));
	}

	// Solution 2 From Xiaolin
	// 此为特殊情况，即abcd和cdab是anagram，但abcd和acdb不是anagram时可以用
	public static boolean anagram1(String s, String t) {
		if (s.length() != t.length())
			return false;
		s += s;
		return s.contains(t);
	}

	// Solution 3 自己写的，属于solution 4的变种，应该比4要好
	public static boolean anagram2(String s, String t) {
		if (s.length() != t.length())
			return false;
		int[] check = new int[256];
		char[] s_array = s.toCharArray();
		for (int i = 0; i < s_array.length; i++) {
			check[s_array[i]]++;
		}
		for (int j = 0; j < t.length(); j++) {
			int temp = --check[t.charAt(j)];
			if (temp < 0)
				return false;

		}
		return true;
	}

	// Solution 4 From Cracking
	public static boolean anagram3(String s, String t) {
		if (s.length() != t.length())
			return false;
		int[] letters = new int[256];
		int num_unique_chars = 0;
		int num_completed_t = 0;
		char[] s_array = s.toCharArray();
		for (char c : s_array) { // count number of each char in s.
			if (letters[c] == 0)
				++num_unique_chars;
			++letters[c];
		}
		for (int i = 0; i < t.length(); ++i) {
			int c = (int) t.charAt(i);
			if (letters[c] == 0) { // Found more of char c in t than in s.
				return false;
			}
			--letters[c];
			if (letters[c] == 0) {
				++num_completed_t;
				if (num_completed_t == num_unique_chars) {
					// it’s a match if t has been processed completely
					return i == t.length() - 1;
				}
			}
		}
		return false;
	}
}
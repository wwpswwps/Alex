package Arrays_and_Strings;

import java.util.ArrayList;
/*
 * 1.3 Design an algorithm and write code to remove the duplicate 
 * characters in a string without using any additional buffer. 
 * NOTE: One or two additional variables are fine. An extra copy of the array is not.
 */

public class E1_3_delDuplicated {
	//Solution 1 From Cracking
	//但我觉得这个方法有问题
	public static void delDuplicated(char[] str) {
		if (str == null) return;
		int len = str.length;
		if (len < 2) return;
		
		 int tail = 1;
		
		 for (int i = 1; i < len; ++i) {
		 int j;
		 for (j = 0; j < tail; ++j) {
		 if (str[i] == str[j]) break;
		 }
		 if (j == tail) {
		 str[tail] = str[i];
		 ++tail;
		 }
		 }
		 str[tail] = 0;
	}
	
	//test
	public static void main(String[] args) {
		char[] test = "asssadfff".toCharArray();
		delDuplicated2(test);
		System.out.println(test);
	}
	
	//Solution 2 自己写的， 返回一个ArrayList
	public static String delDuplicated1(char[] str) {
		if (str == null) return null;
		if (str.length < 2) return str.toString();
		int len = str.length;
		
		for (int i = 0; i < len; i++) {
			for (int j = i + 1; j < len; j++) {
				if (str[i] == str[j])
					str[j] = ' ';
			}
		}
		return helper(str).toString();
	}
	public static ArrayList<Character> helper(char[] str) {
		int i = 0;
		ArrayList<Character> temp = new ArrayList<Character>();
		while (i < str.length) {
			if (str[i] != ' ') {
				temp.add(str[i]);
			}
			i++;
			
		}
		return temp;
	}
	
	//Solution 3 From Cracking
	public static void delDuplicated2(char[] str) {
		if (str == null) return;
		if (str.length < 2) return;
		boolean[] hit = new boolean[256];
		for (int i = 0; i < 256; i++) {
			hit[i] = false;
		}
		int tail = 1;
		hit[str[0]] = true;
		
		for (int i = 1; i < str.length; i++) {
			if (!hit[str[i]]) {
				str[tail] = str[i];
				tail++;
				hit[str[tail]] = true;
			}
		}
		str[tail] = 0;
	}
}

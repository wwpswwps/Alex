package Arrays_and_Strings;

/*
 * 1.5 Write a method to replace all spaces in a string with ‘%20’.
 */

public class E1_5_replaceSpace {

	// Solution 1自己写的，基本和Cracking上的一样，但是要好理解一点
	public static String replaceSpace(String str) {
		char[] str_array = str.toCharArray();
		int count = 0, point = 0;
		for (int i = 0; i < str_array.length; i++) {
			if (str_array[i] == ' ')
				count++;
		}
		char[] new_str = new char[str.length() + 2 * count];
		for (int j = 0; j < str_array.length; j++) {
			if (str_array[j] != ' ') {
				new_str[point] = str_array[j];
				point++;
			} else {
				new_str[point] = '%';
				new_str[point + 1] = '2';
				new_str[point + 2] = '0';
				point += 3;
			}
		}
		return new String(new_str);
	}

	// test
	public static void main(String[] args) {
		String test = " a  b ";
		System.out.println(replaceSpace(test));
	}
	
	//Solution 2 From Cracking
	public static void replaceSpace1(char[] str, int length) {
		int spaceCount = 0, newLength, i = 0;
		for (i = 0; i < length; i++) {
			if (str[i] == ' ') {
				spaceCount++;
			}
		}
		newLength = length + spaceCount * 2;
		str[newLength] = '\0';
		for (i = length - 1; i >= 0; i--) {
			if (str[i] == ' ') {
				str[newLength - 1] = '0';
				str[newLength - 2] = '2';
				str[newLength - 3] = '%';
				newLength = newLength - 3;
			} else {
				str[newLength - 1] = str[i];
				newLength = newLength - 1;
			}
		}
	}
}

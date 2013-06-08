package Arrays_and_Strings;

import java.util.ArrayList;

public class ArrayLists {
	public static ArrayList<String> merge(String[] words, String[] more) {
		ArrayList<String> sentence = new ArrayList<String>();
		for (String w : words) sentence.add(w);
		for (String w : more) sentence.add(w);
				return sentence;
	}
	
	//test
	public static void main(String[] args) {
		String[] words = {"A", "B", "C", "D"};
		String[] more = {"a", "b", "c", "d", "e"};
		for (char s : merge(words, more).toString().toCharArray())System.out.print(s);
	}
}

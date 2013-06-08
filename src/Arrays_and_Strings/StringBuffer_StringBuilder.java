package Arrays_and_Strings;

public class StringBuffer_StringBuilder {
	public static String makeSentence(String[] words) {
		StringBuffer sentence = new StringBuffer();
		for (String w : words) sentence.append(w);
				return sentence.toString();
	}
	
	//test
	public static void main(String[] args) {
		String[] words = {"A", "B", "C", "D", "E"};
		System.out.print(makeSentence(words));
	}
}

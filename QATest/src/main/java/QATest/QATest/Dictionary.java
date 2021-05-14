package QATest.QATest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Dictionary {
	
	public static boolean isEnglishWord(String word) throws IOException{
		boolean val = false;
		
		Set<String> listOfAllEnglishWords = new HashSet<String>();
		Map<Character, Integer> givenWordCounts = getLetterCount(word);
		
		System.out.println("Give word is : "+word);
		
		URL url = new URL("https://docs.oracle.com/javase/tutorial/collections/interfaces/examples/dictionary.txt");
		BufferedReader read = new BufferedReader(new InputStreamReader(url.openStream()));
		
		for(String dWord = read.readLine();dWord!=null;dWord = read.readLine()) {
			if(dWord.equalsIgnoreCase(word)) {
				val = true;
			}
			Map<Character, Integer> dWordCounts = getLetterCount(dWord);
			boolean status = true;
			for(Character c:dWordCounts.keySet()) {
				int tDWordCount = dWordCounts.get(c);
				int tGWordCount = givenWordCounts.containsKey(c) ? givenWordCounts.get(c) : 0;
				if(tDWordCount > tGWordCount) {
					status = false;
					break;
				}
			}
			if(status) {
				listOfAllEnglishWords.add(dWord);
			}
		}
		
		if(!listOfAllEnglishWords.isEmpty()) {
			System.out.println("All posible dictionary words from the given word are :");
			for(String s: listOfAllEnglishWords) {
				System.out.println(s);
			}
		}
		
		return val;
	}
	
	private static Map<Character, Integer> getLetterCount(String word){
		Map<Character, Integer> lCount = new HashMap<Character, Integer>();
		char[] wC = word.toCharArray();
		for(char c:wC) {
			int count = lCount.containsKey(c) ? lCount.get(c) : 0;
			lCount.put(c, count+1);
		}		
		return lCount;
	}
}

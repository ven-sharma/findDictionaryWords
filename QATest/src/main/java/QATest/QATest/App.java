package QATest.QATest;

import java.io.IOException;
import java.util.Scanner;

public class App{
    public static void main( String[] args ) throws IOException
    {
    	Scanner s=new Scanner(System.in);
    	String word = s.nextLine();
    	s.close();
        boolean v = Dictionary.isEnglishWord(word);
        System.out.println("The Given word match with Dictionary is : "+ v);
    }
}

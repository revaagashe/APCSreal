package unit13;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Collections;
import static java.lang.System.*;

public class FancyWords
{
	private String[] wordRay;

	public FancyWords(String sentence)
	{
		setWords(sentence);
	}

	public void setWords(String sentence)
	{
		wordRay = sentence.split(" ");
		/*Scanner sentenceScanner = new Scanner (sentence);
		int spot = 0;
		int count = 0;
		while (sentenceScanner.hasNext()){
			count++;
		}			
		String[] wordRay = new String[count];
		while (sentenceScanner.hasNext()){
			wordRay[spot] = sentenceScanner.next();
		}*/
	}

	public String toString()
	{
	
		String output="";
		int max = Integer.MIN_VALUE;
		String maxWord = "";
		for (String x : wordRay){
			if (x.length() > max){
				max = x.length();
			}
		}
		for (int x = 0; x<wordRay.length; x++){
			
			for (int y = wordRay[x].length(); y <= (max); y++){
				wordRay[x] += " ";
			}
		
	}
		for (int x = 0; x<=max; x++ ){
			for (int y = wordRay.length-1; y>=0; y--){
				char[] word = wordRay[y].toCharArray();
				output += word[wordRay[y].length()-1-x];
		} 
			output += "\n";
	}



		return output+"\n\n";
	}
	}
	

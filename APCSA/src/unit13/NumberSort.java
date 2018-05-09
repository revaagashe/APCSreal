package unit13;
import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import static java.lang.System.*;

public class NumberSort
{
	//instance variables and other methods not shown

	private static int getNumDigits(int number)
	{
		int count = 1;
		int num = number;
		while (num>10){
			num = (num - num%10)/10;
			count++;
		}

		return count;
	}
	
	public static int[] getSortedDigitArray(int number)
	{
		int[] sorted = new int[getNumDigits(number)];
		int num = number;
		while (num>0){
			for (int x = 0; x<sorted.length; x++){
				sorted[x] = num%10;
				num = (num - num%10)/10;
			}
		}
		Arrays.sort(sorted);
		return sorted;
	}
}
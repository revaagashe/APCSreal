package journals;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Journal3_19 {
public int[] binary(String intList){
	Scanner keyboard = new Scanner(intList);

	int size = keyboard.nextInt();
	
	int[] array = new int[size];
	for (int x = 0; x<size; x++){
		int num = keyboard.nextInt();
		array[num+1] += 1;
	}
	
	
	
	return array;
}

public int[] linear(String intList){
	Scanner keyboard = new Scanner(intList);

	int size = keyboard.nextInt();
	
	int[] array = new int[size];
	for (int x = 1; x<100; x++){
			if (keyboard.nextInt() == x){
				array[x-1] +=1;
			
		}
	}
	
	
	
	return array;
}
}

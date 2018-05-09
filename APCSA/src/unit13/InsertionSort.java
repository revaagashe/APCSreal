package unit13;
import java.util.ArrayList;
import java.util.Collections;
import static java.lang.System.*;

class InsertionSort
{
	private ArrayList<String> list;

	public InsertionSort()
	{
		
		list = new ArrayList<String>();


	}

	//modfiers
	public void add( String  word)
	{	
		int loc  = 0;
		if (list.indexOf(word) == -1){
			loc = Collections.binarySearch(list, word);
			list.add(Math.abs(loc+1), word);
		}
		else{
			System.out.println("This word is already in the list.");

		}
		
		
	}

	public void remove(String word)
	{
		int x = list.indexOf(word);
		if (x == -1){
			System.out.println("This word is not in the list.");
		}
		else {
			list.remove(word);
		}




	}

	public String toString()
	{
		return "";
	}
}
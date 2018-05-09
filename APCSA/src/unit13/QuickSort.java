package unit13;
import static java.lang.System.*;
import java.util.Arrays;
public class QuickSort {
		//use Arrays.toString() to help print out the array

	
		private static int passCount;

		public static void quickSort(Comparable[] list)
		{
			passCount = 0;
			int high = list.length-1;
			int low = 0;
			quickSort(list, low, high);
		}


		private static void quickSort(Comparable[] list, int low, int high)
		{
			if (low<high){
				int spot = partition(list, low, high);
				quickSort(list, low, spot);
				quickSort(list, spot+1, high);
			}

		}


		private static int partition(Comparable[] list, int low, int high)
		{
			Comparable pivot = list[low];
			int bot = low-1;
			int top = high + 1;
			
			while (bot<top){
				while (list[--top].compareTo(pivot)>0);
				while (list[++bot].compareTo(pivot)<0);
				if (bot >= top){
					return top;
				}
				
				Comparable temp = list[bot];
				list[bot] = list[top];
				list[top] = temp;
			}


			return 0;
		}
	}


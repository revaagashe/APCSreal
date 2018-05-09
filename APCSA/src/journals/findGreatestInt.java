package journals;

public class findGreatestInt {
	
		int num = 0;
		int count = 0;
		public int findGreatest(int[] array){

			if (count<array.length){
				if (array[count] > num) {
					num = array[count];

					
				}
				count++;

				findGreatest(array);
			}
		return num;
		
	}

}

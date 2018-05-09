package journals;

public class Factorial {
	int product = 1;
	int count = 1;
	public int calcFact(){

		if (count<11){
			product = product * count;
			count ++;
			calcFact();
		}
		return product;
	}
}

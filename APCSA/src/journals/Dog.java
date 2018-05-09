package journals;

public class Dog extends Animal{
public Dog (String ty, String gen){
	type = ty;
	gender = gen;
}


public static void main(String args[])
{
	Dog x = new Dog("dog", "male");
	System.out.println(x.getGender());
	System.out.println(x.getType());
}

}

package unit14;

public class Lab21g {
	public static void main(String args[])
	{
		AtCounter x = new AtCounter();
		System.out.println("0 0 has " + x.countAts(0,0) + " @s connected.");
		
		AtCounter y = new AtCounter();
		System.out.println("2 5 has " + y.countAts(2,5) + " @s connected.");
		
		AtCounter z = new AtCounter();
		System.out.println("5 0 has " + z.countAts(5,0) + " @s connected.");
		
		AtCounter a = new AtCounter();
		System.out.println("9 9 has " + a.countAts(9,9) + " @s connected.");
		
		AtCounter b = new AtCounter();
		System.out.println("3 9 has " + b.countAts(3,9) + " @s connected.");
	}
}

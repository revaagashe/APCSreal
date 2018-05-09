package unit14;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import static java.lang.System.*;

public class Lab24b
{
	public static void main( String args[] ) throws IOException
	{
		Scanner file = new Scanner(new File(System.getProperty("user.dir") + "//src//unit14//lab24b.dat")
);
		int size = file.nextInt();
		file.nextLine();
		for(int i = 0; i<size; i++)
		{
			String word = file.next();
					FancyWord x = new FancyWord(word);
			System.out.println(x);




	   }
	}
}
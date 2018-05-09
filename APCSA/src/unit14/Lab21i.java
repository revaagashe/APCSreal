package unit14;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import static java.lang.System.*;

public class Lab21i
{
	public static void main( String args[] ) throws IOException
	{
		Scanner file = new Scanner(new File (System.getProperty("user.dir") + "//src//unit14//lab21i.dat"));
	//file.nextLine();
		while (file.hasNext()){
			int size = file.nextInt();
			file.nextLine();
			String line = file.nextLine();
			Maze x = new Maze(size, line);
			System.out.println(x);
		}
	}
}
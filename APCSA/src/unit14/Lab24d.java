package unit14;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import static java.lang.System.*;
public class Lab24d {
	public static void main( String args[] ) throws IOException
	{
		Scanner file = new Scanner(new File (System.getProperty("user.dir") + "//src//unit14//lab24d.dat"));
		int count = file.nextInt();
		for (int a = 0; a<count; a++){
			String game = file.next();
			TicTacToe x = new TicTacToe(game);
			System.out.println(x);
		}

	}
	
}

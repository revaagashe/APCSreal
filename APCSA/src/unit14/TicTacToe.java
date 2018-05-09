package unit14;
import java.util.Scanner;
import static java.lang.System.*;

public class TicTacToe
{
	private char[][] mat;

	public TicTacToe()
	{
	mat = new char[1][1];

	}

	public TicTacToe(String game)
	{
int x =(int)(Math.sqrt(game.length()));
mat = new char[x][x];


for (int a = 0; a<x; a++){
	
	
	for (int y = 0; y<x; y++)
	{
		mat[a][y] = game.charAt(3*a +  y);

	}


}

	}

	public String getWinner()
	{
// check horizontal
for (int a = 0; a<mat.length; a++){
	if ((mat[a][0] == mat[a][1]) && (mat[a][2] == mat[a][0])){
		return Character.toString(mat[a][0]) + " wins horizontally!\n";
	}
}
// check vertical
for (int a = 0; a<mat.length; a++){
	if ((mat[0][a] == mat[1][a]) && (mat[2][a] == mat[1][a])){
		return Character.toString(mat[0][a]) + " wins vertically!\n";
	}
}


//check diagonal

if (((mat[0][0] == mat[1][1]) && (mat[2][2] == mat[1][1]))){
		return Character.toString(mat[0][0]) + " wins diagonally!\n";
	
}


if ((mat[2][0] == mat[1][1]) && (mat[2][0] == mat[0][2])){
		return Character.toString(mat[0][2]) + " wins diagonally!\n";
	
}



		return "cat's game = no winner!\n";
	}

	public String toString()
	{
		String output="";
		
		for (int x = 0; x<mat.length; x++){
			for (int y = 0; y<mat.length; y++){
				output += Character.toString(mat[x][y]) + " ";
			}
			output += "\n";
		}
		
		output+= getWinner();




		return output+"\n\n";
	}
}
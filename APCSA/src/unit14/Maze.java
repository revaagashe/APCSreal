package unit14;


import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import static java.lang.System.*;

public class Maze
{
   private int[][] maze;

	public Maze()
	{
		

	}

	public Maze(int size, String line)
	{
		maze = new int[size][size];

		Scanner string = new Scanner(line);


		for (int a = 0; a<size; a++){
			
			
			for (int y = 0; y<size; y++)
			{
				maze[a][y] = string.nextInt();

			}


		}

	}

	public boolean hasExitPath(int r, int c)
	{
		int rnew = r;
		int cnew = c;
		if(((r>=0 && r<maze.length) && (c>=0 && c<maze.length)) && (maze[r][c] == 1)){
			maze[r][c] = 'x';
			if (c == maze[0].length-1){
				return true;
			}
			else {
				if (hasExitPath(rnew+1, cnew)){
					return true;
				}
				rnew = r;
				cnew = c;
				 if (hasExitPath(rnew, cnew+1)){
					return true;
				}
				rnew = r;
				cnew = c;
				 if (hasExitPath(rnew, cnew-1)){
					return true;
				}
				rnew = r;
				cnew = c;
				if (hasExitPath(rnew-1, cnew)){
					return true;
				}

			}
			

		}

			return false;

	}

	public String toString()
	{
		String output="";
		
		for (int x = 0; x<maze.length; x++){
			for (int y = 0; y<maze.length; y++){
				output += maze[x][y] + " ";
			}
			output += "\n";
		}
		
		if(hasExitPath(0,0)){
			output+="exit found";
		}
		else{
			output+="exit not found";
		}



		return output+"\n\n";




	}
}
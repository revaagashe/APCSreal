package unit14;

public class FancyWord {
	private char[][] mat;

	public FancyWord()
	{
mat = new char[1][1];
	}

   public FancyWord(String s)
	{

mat = new char[s.length()][s.length()];
for (int x = 0; x<mat.length; x++){
	for (int y = 0; y<mat.length; y++){
			mat[x][y] = ' ';
	}
}

for (int x = 0; x<s.length(); x++){
		mat[0][x] = s.charAt(x);
		mat[s.length()-1][x] = s.charAt(x);

	}
int count = mat.length-2;
		for (int x = 1; x<=count; x++){
			mat[x][x] = s.charAt(x);
		}
		for (int x = 1; x<=count; x++){
			mat[x][s.length()-x-1] = s.charAt(s.length()-x-1);
		}
	}

	public String toString()
	{
		String output="";

for (int x = 0; x<mat.length; x++){
	for (int y = 0; y<mat.length; y++){
		System.out.print(mat[x][y]);
	}
	System.out.println();
}



		return output+"\n\n";
	}
}

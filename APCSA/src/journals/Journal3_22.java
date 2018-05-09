package journals;
import java.io.IOException;

public class Journal3_22 {
	
	public static int[][] getMatrix(){
		int[][] matrix = new int[6][6];
		for (int x = 0; x<matrix.length; x++){
			for (int y = 0; y<matrix.length; y++){
				matrix[x][y] = (int) Math.random();
			}
		}
		
		return matrix;
	}
	
	public static void checkMat(int[][] matrix){
		int oneCount = 0;
		for (int[] row : matrix){
			for (int y : row){
					if (y==1){
						oneCount++;
				}
					
			}
			if (oneCount%2 != 1){
				System.out.println("Row "  + " has an even number of one's.");
			}		oneCount = 0;

		}
	}
	
	public static void main( String args[] ) throws IOException
	{
		checkMat(getMatrix());
	}
	
}

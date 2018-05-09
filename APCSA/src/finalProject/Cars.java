package finalProject;
import java.awt.Color;
import java.awt.Graphics;import java.util.Random;

import unit17.Alien;

public class Cars {
	private Car[][] carList;
	public Cars(){                                                                             
		carList = new Car[3][3];
		Random rand = new Random();


	for (int x = 0; x<carList.length; x++){
		for (int y = 0; y<carList[0].length; y++){
			int a = rand.nextInt(50)+1;
			int b = rand.nextInt(50)+1;
			carList[x][y] = new Car(100*(x+1) + a, 100*y+1 + 10 + b, 2 );
		}
	}

}
	
	 Car[][] makeCars(){
		return carList;
	}
}

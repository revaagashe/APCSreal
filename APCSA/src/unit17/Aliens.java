package unit17;

import java.awt.Color;
import java.awt.Graphics;

import unit15.Block;
import java.util.Random;

public class Aliens {
	private Alien[][] alienList;
	private Ammo[][] ammoList;
	
	public Aliens(){                                                                             
		alienList = new Alien[3][3];
		Random rand = new Random();


	for (int x = 0; x<alienList.length; x++){
		for (int y = 0; y<alienList[0].length; y++){
			int a = rand.nextInt(50)+1;
			int b = rand.nextInt(50)+1;
			alienList[x][y] = new Alien(100*(x+1) + a, 100*y+1 + 10 + b, 2 );
//			ammoList[x][y] = new Ammo(alienList[x][y].getX() + 35, alienList[x][y].getY() + 35, 3);
		}
	}

}
	
	 Alien[][] makeAliens(){
		return alienList;
	}
}

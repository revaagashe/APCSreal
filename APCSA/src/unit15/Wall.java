package unit15;

import java.awt.Color;
import java.awt.Graphics;

public class Wall extends Block {
	public Wall() {
		super(0,0,20,600, Color.WHITE);
	}
	
	public Wall(int x, int y) {
		super (x,y, 20, 600, Color.WHITE);
	}
	
	public Wall(int x, int y, int w, int h) {
		super (x,y,w,h, Color.WHITE);
	}
	
	public Wall (int x, int y, int w, int h, Color c) {
		super (x,y,w,h,c);
	}
}
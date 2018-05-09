package unit15;

import java.awt.Color;
import java.awt.Graphics;


public class InvisibleBall extends Ball {
	boolean visible = true;
	  public InvisibleBall()
	   {
			super();
	   }

	   public InvisibleBall(int x, int y)
	   {
		   super(x,y);


	   }

	   public InvisibleBall(int x, int y, int wid, int ht)
	   {
		   
		   super(x,y,wid,ht);


	   }

	   public InvisibleBall(int x, int y, int wid, int ht, int xSpd, int ySpd)
	   {
		   super(x,y,wid,ht);
		   setXSpeed(xSpd);
		   setYSpeed(ySpd);

	   }

	   public InvisibleBall(int x, int y, int wid, int ht, Color col, int xSpd, int ySpd)
	   {
		   super(x,y,wid,ht,col);
		   setXSpeed(xSpd);
		   setYSpeed(ySpd);



	   }
	   
	   public boolean invisball (){
		  visible = true;
		   int r = (int)(Math.random()*(100));

		   if (r%3 == 1){
			   visible = false;
		   }
		   return visible;
	   }

	   public void moveAndDraw(Graphics window)
	   {
		   window.setColor(Color.WHITE);
		   window.fillRect(getX(), getY(), getWidth(), getHeight());  

		   setX(getX()+getXSpeed());
			//setY
		  setY(getY() + getYSpeed());

		   int r = (int)(Math.random()*(100));
		   if (r%3 == 1){
			   invisball();
		   }
		   else{
			   visible = false;
		   }
		   if (visible){
			   window.setColor(Color.RED);
			   window.fillRect(getX(), getY(), getWidth(), getHeight());  
		   }
		   else{
			   window.setColor(Color.WHITE);
			   window.fillRect(getX(), getY(), getWidth(), getHeight());  
		   }
	   } 
}
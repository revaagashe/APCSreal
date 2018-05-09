package unit15;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

class BlinkyBall extends Ball
{

   //constructors
   public BlinkyBall()
   {
		super();
   }

   public BlinkyBall(int x, int y)
   {
	   super(x,y);


   }

   public BlinkyBall(int x, int y, int wid, int ht)
   {
	   
	   super(x,y,wid,ht);


   }

   public BlinkyBall(int x, int y, int wid, int ht, int xSpd, int ySpd)
   {
	   super(x,y,wid,ht);
	   setXSpeed(xSpd);
	   setYSpeed(ySpd);

   }

   public BlinkyBall(int x, int y, int wid, int ht, Color col, int xSpd, int ySpd)
   {
	   super(x,y,wid,ht,col);
	   setXSpeed(xSpd);
	   setYSpeed(ySpd);



   }
 

   
   public Color randomColor()
   {
   	int r = (int)(Math.random()*(256));//use Math.random()
   	int g = (int)(Math.random()*(256));		//use Math.random()
   	int b = (int)(Math.random()*(256));		//use Math.random()
   	
 		return new Color(r,g,b);
   }
   public void moveAndDraw(Graphics window)
   {

  window.setColor(Color.WHITE);
  window.fillRect(getX(), getY(), getWidth(), getHeight());  

  setX(getX()+getXSpeed());
	//setY
  setY(getY() + getYSpeed());
	//draw the ball at its new location
  window.setColor(randomColor());
  window.fillRect(getX(), getY(), getWidth(), getHeight());  

   }
}
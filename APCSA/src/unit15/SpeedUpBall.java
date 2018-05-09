package unit15;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

class SpeedUpBall extends Ball
{

   //instance variables

   public SpeedUpBall()
   {
	   super();

   }

   public SpeedUpBall(int x, int y)
   {

	   	super(x,y);
   }


   public SpeedUpBall(int x, int y, int xSpd, int ySpd)
   {
	   super(x,y);
	   setXSpeed(xSpd);
	   setYSpeed(ySpd);;

   }

   public SpeedUpBall(int x, int y, int wid, int ht, int xSpd, int ySpd)
   {

	   super(x,y,wid,ht);
	   setXSpeed(xSpd);
	   setYSpeed(ySpd);;
   }


   public SpeedUpBall(int x, int y, int wid, int ht, Color col, int xSpd, int ySpd)
   {
	   super(x,y,wid,ht,col);
	   setXSpeed(xSpd);
	   setYSpeed(ySpd);;



   }

   public void setXSpeed( int xSpd )
   {
	   super.setXSpeed(xSpd+1);



   }

   public void setYSpeed( int ySpd )
   {
	   super.setYSpeed(ySpd+1);
	   if (getXSpeed()>0) {
			  super.setXSpeed(getXSpeed() + 1);

		  }
		  else if (getXSpeed()<0) {
			  super.setXSpeed(getXSpeed() - 1);

		  }
		  
		  if (getYSpeed()>0) {
			  super.setYSpeed(getYSpeed() + 1);

		  }
		  if (getYSpeed()<0) {
			  super.setYSpeed(getYSpeed() - 1);

		  }



   }
   public void moveAndDraw(Graphics window)
   {

  window.setColor(Color.WHITE);
  window.fillRect(getX(), getY(), getWidth(), getHeight());  

  setX(getX()+getXSpeed());
	//setY
  setY(getY() + getYSpeed());
	//setY
	//draw the ball at its new location
  System.out.println(getXSpeed() + " " + getYSpeed());
  draw(window);
   }
}
//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -
package unit15;

import java.awt.Color;
import java.awt.Graphics;

public class Ball extends Block implements Collidable
{
	private int xSpeed;
	private int ySpeed;

	public Ball()
	{
		super(200,200);
		xSpeed = 3;
		ySpeed = 1;
	}

	//add the other Ball constructors
	
	public Ball(int x, int y)
	{
		super(x,y);
		xSpeed = 3;
		ySpeed = 1;
	}
	
	public Ball(int x, int y, int w, int h)
	{
		super(x,y,w,h);
		xSpeed = 3;
		ySpeed = 1;

	}
		
	public Ball(int x, int y, int w, int h, Color c)
	{
		super(x,y,w,h,c);
		xSpeed = 3;
		ySpeed = 1;

	}
	public Ball(int x, int y, int w, int h, Color c, int xSp, int ySp)
	{
		super(x,y,w,h,c);
		xSpeed = xSp;
		ySpeed = ySp;

	}
	
//collidable



	   
   //add the set methods
	public void setX (int x){
		super.setX(x);
	}
	public void setY (int y){
		super.setY(y);
	}
	public void setPos(int x, int y)
	{
		super.setPos(x, y);
	}
   

   public void setColor(Color col)
   {
	   super.setColor(col);
   }
   
   public void setXSpeed (int xSp){
	   xSpeed = xSp;
   }
   
   public void setYSpeed (int ySp){
	   ySpeed = ySp;
   }
   public void moveAndDraw(Graphics window)
   {
   	//draw a white ball at old ball location
	 window.setColor(Color.WHITE);
	  window.fillRect(getX(), getY(), getWidth(), getHeight());  

      setX(getX()+xSpeed);
		//setY
      setY(getY() + ySpeed);
		//draw the ball at its new location

      draw(window);
   }
   
	public boolean equals(Object obj)
	{
		Ball b = (Ball)obj;
		if (b.getHeight() == getHeight()){
			if (b.getWidth() == getWidth()) {
				if (b.getX() == getX()){
					if (b.getY() == getY()){
						if (b.getXSpeed() == getXSpeed()){
							if (b.getYSpeed() == getYSpeed()){
								return true;
							}
						}
					}
				}
			}
		}
		return false;
	}    

   //add the get methods
	public int getX(){
		return super.getX();
	}
	
	public int getY(){
		return super.getY();
	}
	
	public int getWidth(){
		return super.getWidth();
	}
	
	public int getHeight(){
		return super.getHeight();
	}
	
	public Color getColor(){
		return super.getColor();
	}

	public int getXSpeed(){
		return xSpeed;
	}
	
	public int getYSpeed(){
		return ySpeed;
	}
   //add a toString() method
	   public String toString()
	   {
	   	return super.getX()+" "+super.getY()+" "+super.getWidth()+" "+super.getHeight()+" "+ super.getColor() + " " + xSpeed + " " + ySpeed;
	   }
		@Override
		public boolean didCollideRight(Object obj){
			Block paddle = (Block)obj;
			if (getX()<paddle.getX()+paddle.getWidth() && getX()+getWidth()>=paddle.getX() && (getY() >= paddle.getY() && getY()+getHeight() <= paddle.getY()+paddle.getHeight())){
				return true;
			}
			return false;
		}
		public boolean didCollideTop(Object obj){
			Block paddle = (Block)obj;
			if (getY()+getHeight()>paddle.getY() && getY() <= paddle.getY()+paddle.getHeight() && (getX()>=paddle.getX() && getX()+getWidth()<=paddle.getX()+paddle.getWidth())){
				return true;
			}
			return false;
		}
		public boolean didCollideBottom(Object obj){
			Block paddle = (Block)obj;
			if (getY()+getHeight()>paddle.getY() && getY()<=paddle.getY()+paddle.getHeight() && (getX()>=paddle.getX() && getX()+getWidth()<=paddle.getX()+paddle.getWidth())){
				return true;
			}
			return false;
		}

		@Override
		public boolean didCollideLeft(Object obj){
			Block paddle = (Block)obj;
			if (getX()+getWidth() > paddle.getX() && getX() <= paddle.getX()+paddle.getWidth() && (getY() >= paddle.getY() && getY()+getHeight() <= paddle.getY()+paddle.getHeight())){
				return true;
			}
			return false;
		}

}


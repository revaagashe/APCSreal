//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -
package unit17;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;

import unit15.Block;

public class Alien extends MovingThing implements Collidable
{
	private int speed;
	private Image image;

	public Alien()
	{
		this(0,0,0);
	}

	public Alien(int x, int y)
	{
		this(x,y,0);
	}

	public Alien(int x, int y, int s)
	{
		super(x, y);
		speed=s;
		try
		{
			image = ImageIO.read(new File("src\\unit17\\alien.JPG"));
		}
		catch(Exception e)
		{
			System.out.println("fasdf");
		}
	}

	public void setSpeed(int s)
	{
		speed = s;
	}

	public int getSpeed()
	{
		   return speed;
	}

	public void draw( Graphics window )
	{
   	window.drawImage(image,getX(),getY(),80,80,null);
   	window.setColor(Color.WHITE);

    setX(getX()+speed);
		//setY
   	window.drawImage(image,getX(),getY(),80,80,null);

   	

	}

	public String toString()
	{
		return "";
	}
	@Override
	public boolean didCollideRight(Object obj){
		Block ammo = (Block)obj;
		if (getX()<ammo.getX()+ammo.getWidth() && getX()>=ammo.getX() && (getY() >= ammo.getY() && getY() <= ammo.getY()+ammo.getHeight())){
			return true;
		}
		return false;
	}
	public boolean didCollideTop(Object obj){
		Block paddle = (Block)obj;
		if (getY()>paddle.getY() && getY() <= paddle.getY()+paddle.getHeight() && (getX()>=paddle.getX() && getX()<=paddle.getX()+paddle.getWidth())){
			return true;
		}
		return false;
	}
	public boolean didCollideBottom(Object obj){
		Block paddle = (Block)obj;
		if (getY()>paddle.getY() && getY()<=paddle.getY()+paddle.getHeight() && (getX()>=paddle.getX() && getX()<=paddle.getX()+paddle.getWidth())){
			return true;
		}
		return false;
	}

	@Override
	public boolean didCollideLeft(Object obj){
		Block paddle = (Block)obj;
		if (getX() > paddle.getX() && getX() <= paddle.getX()+paddle.getWidth() && (getY() >= paddle.getY() && getY() <= paddle.getY()+paddle.getHeight())){
			return true;
		}
		return false;
	}
	
}

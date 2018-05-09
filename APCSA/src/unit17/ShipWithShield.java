package unit17;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;

import javax.imageio.ImageIO;

public class ShipWithShield extends MovingThing {
	private int speed;
	private Image image;

	public ShipWithShield()
	{
		this(0,0,0);
	}

	public ShipWithShield(int x, int y)
	{
		this(x,y,0);
	}

	public ShipWithShield(int x, int y, int s)
	{
		super(x, y);
		speed=s;
		try
		{
			image = ImageIO.read(new File("src\\unit17\\ship.jpgWithShield.jpg"));
		}
		catch(Exception e)
		{
			System.out.println("a;slkdf");
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
	}

	public String toString()
	{
		return super.toString()  + "\nSpeed: " + getSpeed();
	}

}

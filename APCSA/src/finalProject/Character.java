package finalProject;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;

import javax.imageio.ImageIO;

public class Character extends MovingThing {
	private int speed;
	private Image image;

	public Character()
	{
		this(0,0,0);
	}

	public Character(int x, int y)
	{
		this(x,y,0);
	}

	public Character(int x, int y, int s)
	{
		super(x, y);
		speed=s;
		try
		{
			image = ImageIO.read(new File("src\\finalProject\\character-color.jpg"));
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
   	window.drawImage(image,getX(),getY(),100,40,null);
	}

	public String toString()
	{
		return super.toString()  + "\nSpeed: " + getSpeed();
	}
}

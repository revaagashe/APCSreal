package finalProject;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.util.Random;

import javax.imageio.ImageIO;


public class PU extends MovingThing{
	private int speed;
	private Image image;


	public PU()
	{
		this(0,0,0);
	}

	public PU(int x, int y)
	{
		this(x,y,3);
	}

	public PU(int x, int y, int s)
	{
		super(x, y);
		speed=s;
		try
		{
			image = ImageIO.read(new File("src\\finalProject\\32-done.gif"));
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


   	window.drawImage(image,getX(),getY(),100,40,null);
    setY(getY() + speed);

   	window.setColor(Color.WHITE);
   	
   	

   	

	}

	public String toString()
	{
		return "";
	}
	

}

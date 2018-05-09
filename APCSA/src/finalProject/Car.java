package finalProject;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;

import javax.imageio.ImageIO;


public class Car extends MovingThing
	{
		private int speed;
		private Image image;

		public Car()
		{
			this(0,0,0);
		}

		public Car(int x, int y)
		{
			this(x,y,0);
		}

		public Car(int x, int y, int s)
		{
			super(x, y);
			speed=s;
			try
			{
				image = ImageIO.read(new File("src\\finalProject\\car1.png"));
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
		
		
}

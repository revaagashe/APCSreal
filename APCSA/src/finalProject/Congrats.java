package finalProject;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;

import javax.imageio.ImageIO;
public class Congrats {

		private int speed;
		private Image image;

		public Congrats()
		{
			try
			{
				image = ImageIO.read(new File("src\\finalProject\\CongratulationsGobo-BG-11.jpg"));
			}
			catch(Exception e)
			{
				System.out.println("a;slkdf");
			}
		}
		public void draw( Graphics window )
		{
	   	window.drawImage(image,0,0,800,600,null);
		}



}

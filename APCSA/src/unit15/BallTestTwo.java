//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -
package unit15;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class BallTestTwo extends Canvas implements Runnable
{
	private Ball ball;

	public BallTestTwo()
	{
		setBackground(Color.WHITE);
		setVisible(true);

		//instantiate a new Ball
		ball = new Ball();

		//test the Ball thoroughly
		ball = new Ball();
		ball = new Ball(60, 60);
		ball = new Ball(70, 90, 23, 50, Color.RED);
		ball = new Ball(70, 90, 23, 50, Color.GREEN, 50, 50);

		//test all constructors
		

		new Thread(this).start();
	}
	
	public void update(Graphics window)
	{
		paint(window);
	}

	public void paint(Graphics window)
	{
		ball.moveAndDraw(window);

		if(!(ball.getX()>=10 && ball.getX()<=550))
		{
			ball.setXSpeed(-ball.getXSpeed());
		}

		if(!(ball.getY()>=10 && ball.getY()<=450))
		{
			ball.setYSpeed(-ball.getYSpeed());
		}
	}
	
   public void run()
   {
   	try
   	{
   		while(true)
   		{
   		   Thread.currentThread().sleep(19);
            repaint();
         }
      }catch(Exception e)
      {
      }
  	}	
}
package unit15;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import static java.lang.Character.*;
import java.awt.image.BufferedImage;
import java.awt.event.ActionListener;

public class Pong extends Canvas implements KeyListener, Runnable
{
	//private Ball ball;
	//private SpeedUpBall ball;
	//private BlinkyBall ball;
	private InvisibleBall ball;
	
	
	private Paddle leftPaddle;
	private Paddle rightPaddle;
	private boolean[] keys;
	private BufferedImage back;
	private Wall wallL;
	private Wall wallR;
	private Wall wallT;
	private Wall wallB;

	int RScore = 0;
	int LScore = 0;

	public Pong()
	{
		//set up all variables related to the game
	//	ball = new Ball(300, 20, 10, 10, Color.RED, 3, 3);		
		//blinky and speedUp balls commented out
	//ball = new BlinkyBall(300, 20, 10, 10, Color.RED, 1, 1);		
	//ball = new SpeedUpBall(300, 20, 10, 10, Color.RED, 1, 1);		
		ball = new InvisibleBall(300, 20, 10, 10, Color.RED, 1, 1);		

		leftPaddle = new Paddle(20,300,30,100, Color.GREEN,5);
		
		rightPaddle = new Paddle(730,300,30,100, Color.GREEN,5);
		
		// set up walls
		wallL = new Wall();
		wallR = new Wall(760,0);
		wallB = new Wall(20,530,800,20);
		wallT = new Wall(20,0,800,20);
		RScore = 0;
		LScore = 0;

		keys = new boolean[4];

    
    	setBackground(Color.WHITE);
		setVisible(true);
		
		new Thread(this).start();
		addKeyListener(this);		//starts the key thread to log key strokes
	}
	
   public void update(Graphics window){
	   paint(window);
   }

   public void paint(Graphics window)
   {
		//set up the double buffering to make the game animation nice and smooth
		Graphics2D twoDGraph = (Graphics2D)window;

		//take a snap shop of the current screen and same it as an image
		//that is the exact same width and height as the current screen
		if(back==null)
		   back = (BufferedImage)(createImage(getWidth(),getHeight()));

		//create a graphics reference to the back ground image
		//we will draw all changes on the background image
		Graphics graphToBack = back.createGraphics();
		//graphToBack.drawString("Left Player: " + LeftScore + "\nRight Player: " + RightScore, 300, 400);


		ball.moveAndDraw(graphToBack);
		rightPaddle.draw(graphToBack);
		leftPaddle.draw(graphToBack);
		wallL.draw(graphToBack);
		wallR.draw(graphToBack);
		wallT.draw(graphToBack);
		wallB.draw(graphToBack);
		ball.setColor(Color.RED);
		graphToBack.setColor(Color.RED);
		graphToBack.drawString("Points: ",100,440);
		
		//see if ball hits left wall or right wall
	//	if((ball.getX()<=20) || ball.getX()>=770)
		if (ball.didCollideLeft(wallL) || ball.didCollideRight(wallR))
		{
			ball.setXSpeed(0);
			ball.setYSpeed(0);

			if (ball.didCollideLeft(wallL)){
			//if (ball.getX()<=leftPaddle.getX() + leftPaddle.getWidth()){
				//graphToBack.setColor(Color.WHITE);
				//graphToBack.drawString("Right Paddle: "+RightScore, 300, 500);

				RScore +=1;
				ball.moveAndDraw(graphToBack);

				
			}
			 if (ball.didCollideRight(wallR)){
				//graphToBack.setColor(Color.WHITE);
				//graphToBack.drawString("Left Paddle: "+LeftScore, 200, 500);
				 LScore+=1;
					ball.moveAndDraw(graphToBack);

				
			}
				graphToBack.setColor(Color.WHITE);
				graphToBack.drawString("Right Paddle: "+(RScore-1), 100, 460);
				graphToBack.drawString("Left Paddle: "+(LScore-1), 100, 480);		
				
				graphToBack.setColor(Color.RED);

				graphToBack.drawString("Right Paddle: "+RScore, 100, 460);
				graphToBack.drawString("Left Paddle: "+LScore, 100, 480);

			
				ball.draw(graphToBack, Color.WHITE);
				
				
			ball.setX(300);
			ball.setY(30);
			graphToBack.setColor(Color.BLUE);
			ball.setColor(Color.RED);
			ball.setXSpeed(ball.getXSpeed()+3);
			ball.setYSpeed(ball.getYSpeed()+3);
			
		}

		
		//see if the ball hits the top or bottom wall 

	//	if (!(ball.getY()>=0 && ball.getY()<=550)){
		//	ball.setYSpeed(-ball.getYSpeed());

	//	}	
		
		//collide methods and see if ball hit top
		//or bottom wall
	/*	if (!(ball.getY()>=20 && ball.getY()<=530)){
		ball.setYSpeed(-ball.getYSpeed());
		}*/
		
		if (ball.didCollideBottom(wallT) || ball.didCollideTop(wallB)) {
			ball.setYSpeed(-ball.getYSpeed());
			
			ball.moveAndDraw(graphToBack);

		}		

		if (ball.didCollideRight(rightPaddle) || ball.didCollideLeft(leftPaddle)) {
			ball.setXSpeed(-ball.getXSpeed());
			
			ball.moveAndDraw(graphToBack);

		}
		
		
		
		else if (ball.didCollideTop(rightPaddle) || ball.didCollideBottom(rightPaddle)){
			ball.setXSpeed(-ball.getXSpeed());
				ball.setYSpeed(-ball.getYSpeed());
				ball.moveAndDraw(graphToBack);

			
		}
		else if ( ball.didCollideTop(leftPaddle) || ball.didCollideBottom(leftPaddle)) {
			ball.setXSpeed(-ball.getXSpeed());
				ball.setYSpeed(-ball.getYSpeed());
				ball.moveAndDraw(graphToBack);

		}

//code befoREd collidable stuff got implemented
		//see if the ball hits the left paddle
		
	/*	if (ball.getX() <= leftPaddle.getX() + leftPaddle.getWidth() + Math.abs(ball.getXSpeed())){
			if ((ball.getY() >= leftPaddle.getY())&&(ball.getY() <= leftPaddle.getY() + leftPaddle.getHeight()))
				{
				if (ball.getX() <= leftPaddle.getX() + leftPaddle.getWidth() - Math.abs(ball.getXSpeed())){
					ball.setYSpeed(-ball.getYSpeed());
				}
				else {
					ball.setXSpeed(-ball.getXSpeed());
				}
				}
			else if (((leftPaddle.getY() <= ball.getY() + ball.getHeight() ) ) &&  (ball.getY() + ball.getHeight() > leftPaddle.getY() + leftPaddle.getHeight())){
				
				if (ball.getX() <= leftPaddle.getX() + leftPaddle.getWidth() - Math.abs(ball.getXSpeed())){
					ball.setYSpeed(-ball.getYSpeed());
				}
				else {
					ball.setXSpeed(-ball.getXSpeed());
				}
			}
		}
		
		
		//see if the ball hits the right paddle
		
		if (ball.getX() <= rightPaddle.getX() + Math.abs(ball.getXSpeed())){
			if ((ball.getY() >= rightPaddle.getY())&&(ball.getY() <= rightPaddle.getY() + rightPaddle.getHeight()))
				{
				if (ball.getX() <= rightPaddle.getX()  - Math.abs(ball.getXSpeed())){
					ball.setYSpeed(-ball.getYSpeed());
				}
				else {
					ball.setXSpeed(-ball.getXSpeed());
				}
				}
			else if (((rightPaddle.getY() <= ball.getY() + ball.getHeight() ) ) &&  (ball.getY() + ball.getHeight() > rightPaddle.getY() + rightPaddle.getHeight()))
			{
				if (ball.getX() <= rightPaddle.getX()  - Math.abs(ball.getXSpeed())){
					ball.setYSpeed(-ball.getYSpeed());
	
				}
				else {
					ball.setXSpeed(-ball.getXSpeed());
	
				}
			}
		}
		*/


		//see if the paddles need to be moved

		if (keys[0] == true)
		{
			//move left paddle up and draw it on the window
			leftPaddle.moveUpAndDraw(graphToBack);
		}
		if(keys[1] == true)
		{
			//move left paddle down and draw it on the window
			leftPaddle.moveDownAndDraw(graphToBack);

		}
		if(keys[2] == true)
		{
			rightPaddle.moveUpAndDraw(graphToBack);
		}
		if(keys[3] == true)
		{
			rightPaddle.moveDownAndDraw(graphToBack);
		}













		
		twoDGraph.drawImage(back, null, 0, 0);
	}

	public void keyPressed(KeyEvent e)
	{
		switch(toUpperCase(e.getKeyChar()))
		{
			case 'W' : keys[0]=true; break;
			case 'Z' : keys[1]=true; break;
			case 'I' : keys[2]=true; break;
			case 'M' : keys[3]=true; break;
		}
	}

	public void keyReleased(KeyEvent e)
	{
		switch(toUpperCase(e.getKeyChar()))
		{
			case 'W' : keys[0]=false; break;
			case 'Z' : keys[1]=false; break;
			case 'I' : keys[2]=false; break;
			case 'M' : keys[3]=false; break;
		}
	}

	public void keyTyped(KeyEvent e){}
	
   public void run()
   {
   	try
   	{
   		while(true)
   		{
   		   Thread.currentThread().sleep(8);
            repaint();
         }
      }catch(Exception e)
      {
      }
  	}	
}
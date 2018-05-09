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
import static java.lang.System.*;
import static java.util.Arrays.*;


// 	USING A & D INSTEAD OF W & Z


public class BreakOut extends Canvas implements KeyListener, Runnable
{
	private Block[][] blocksList = new Block[5][4];
	


	private Ball ball;
	//privateSpeedUpBall ball;
	//private BlinkyBall ball;
	
	private Paddle paddle;
	private boolean[] keys;
	private BufferedImage back;
	private Wall wallL;
	private Wall wallR;
	private Wall wallT;
	private Wall wallB;
	private int Score = 0;



	public BreakOut()
	{
		System.out.println("Reva Agashe \n Period 4 \n 4/4/18 \n Computer 35");
		//set up all variables related to the game
		ball = new Ball(300, 400, 10, 10, Color.RED, 3, 3);		
		//blinky and speedUp balls commented out
	//ball = new BlinkyBall(300, 20, 10, 10, Color.RED, 1, 1);		
		//ball = new SpeedUpBall(300, 20, 10, 10, Color.RED, 1, 1);		

		paddle = new Paddle(20,470,30,100, Color.GREEN,5);
		
		for (int x = 0; x<blocksList.length; x++){
			for (int y = 0; y<blocksList[0].length; y++){
				blocksList[x][y] = new Block(750-20*x,400-100*y, 10, 75, Color.BLACK );
			}
		}

		
		

		// set up walls
		wallL = new Wall();
		wallR = new Wall(760,0);
		wallB = new Wall(20,530,800,20);
		wallT = new Wall(20,0,800,20);
	
		
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
		graphToBack.setColor(Color.RED);
		graphToBack.drawString("Score: " + Score, 690, 50);


		ball.moveAndDraw(graphToBack);
	
		paddle.draw(graphToBack);
		wallL.draw(graphToBack);
		wallR.draw(graphToBack);
		wallT.draw(graphToBack);
		wallB.draw(graphToBack);
		
		for (int x = 0; x<blocksList.length; x++){
			for (int y = 0; y<blocksList[0].length; y++){
				blocksList[x][y].draw(graphToBack);
			}
		}

		
		if (ball.didCollideLeft(wallL)) {
			graphToBack.setColor(Color.WHITE);

		//	graphToBack.drawString("Score: "+(Score-1), 690, 50);		

			ball.setXSpeed(0);
			ball.setYSpeed(0);
			graphToBack.setColor(Color.WHITE);

			graphToBack.drawString("Score: "+Score, 690, 50);		

			Score = 0;
			
			
			graphToBack.setColor(Color.RED);
			graphToBack.drawString("Score: "+Score, 690, 50);	
			ball.draw(graphToBack, Color.WHITE);
			
			graphToBack.setColor(Color.BLACK);
			for (int x = 0; x<blocksList.length; x++){
				for (int y = 0; y<blocksList[0].length; y++){
					blocksList[x][y].setWidth(10);
					blocksList[x][y].setHeight(75);

					blocksList[x][y].draw(graphToBack);
				}
			}
			ball.setX(400);

			ball.setY(300);
		//	ball.setX((int)(Math.random() * 200) +100);
		//	ball.setY((int)(Math.random() * 200) +100);

			ball.setXSpeed(ball.getXSpeed()-3);
			ball.setYSpeed(ball.getYSpeed()+2);
		}
		

		graphToBack.setColor(Color.WHITE);
		graphToBack.drawString("Score: "+(Score-1), 690, 50);		
		
		graphToBack.setColor(Color.RED);
		graphToBack.drawString("Score: "+Score, 690, 50);		

		
		
		
		if (ball.didCollideBottom(wallT) || ball.didCollideTop(wallB)) {
			ball.setYSpeed(-ball.getYSpeed());
		}		
		if (ball.didCollideRight(wallR)) {
			ball.setXSpeed(-ball.getXSpeed());
		}	
		if (ball.didCollideRight(paddle) || ball.didCollideLeft(paddle)) {
			ball.setXSpeed(-ball.getXSpeed());
		}
		
		
		
		else if (ball.didCollideTop(paddle) || ball.didCollideBottom(paddle)){
			ball.setXSpeed(-ball.getXSpeed());
				ball.setYSpeed(-ball.getYSpeed());
			
		}
		
		for (int x = 0; x<blocksList.length; x++){
			for (int y = 0; y<blocksList[0].length; y++){
				if (ball.didCollideTop(blocksList[x][y])|| ball.didCollideBottom(blocksList[x][y])){
					Score ++;
					ball.setXSpeed(-ball.getXSpeed());
					ball.setYSpeed(-ball.getYSpeed());	
					blocksList[x][y].draw(graphToBack, Color.WHITE);
					blocksList[x][y].setWidth(0);
					blocksList[x][y].setHeight(0);
				}
				if (ball.didCollideRight(blocksList[x][y])|| ball.didCollideLeft(blocksList[x][y])){
					Score ++;

					ball.setXSpeed(-ball.getXSpeed());
					ball.setYSpeed(-ball.getYSpeed());	
					blocksList[x][y].draw(graphToBack, Color.WHITE);
					blocksList[x][y].setWidth(0);
					blocksList[x][y].setHeight(0);
				}
			}
		}
		
		
		


		//see if the paddles need to be moved

		if (keys[0] == true)
		{
			//move left paddle up and draw it on the window
			paddle.moveUpAndDraw(graphToBack);
		}
		if(keys[1] == true)
		{
			//move left paddle down and draw it on the window
			paddle.moveDownAndDraw(graphToBack);

		}













		
		twoDGraph.drawImage(back, null, 0, 0);
	}

	public void keyPressed(KeyEvent e)
	{
		switch(toUpperCase(e.getKeyChar()))
		{
			case 'A' : keys[0]=true; break;
			case 'D' : keys[1]=true; break;

		}
	}

	public void keyReleased(KeyEvent e)
	{
		switch(toUpperCase(e.getKeyChar()))
		{
			case 'A' : keys[0]=false; break;
			case 'D' : keys[1]=false; break;

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
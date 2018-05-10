package finalProject;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

import unit17.Alien;
import unit17.Ammo;
import unit17.PowerUp;
import unit17.Ship;




public class Street extends Canvas implements KeyListener, Runnable {

	private Character c;

	private Car c1;
	private Car c2;
	private Car c3;
	private Car c4;
	private Car c5;
	private Car c6;
	
	private int score;
	private Congrats co;
	private Cars cmat;
	
	private int level;
	
	private ArrayList<Car> cars;	
	private Car[][] car;

	private boolean play;
	
	private PU p;
	
	boolean win = false;
	/* uncomment once you are ready for this part
	 */

	

	private boolean[] keys;
	private BufferedImage back;

	public Street()
	{

		setBackground(Color.black);

		keys = new boolean[5];

		//instantiate other stuff
		cars = new ArrayList();
		
		level = 1;
		
		co = new Congrats();

		c = new Character(300,400,0);
		c1 = new Car (1200,100,2);
		c2 = new Car (1400, 200, 2);
		c3 = new Car (1300, 300, -2);
		c4 = new Car (1500, 400, 2);
		c5 = new Car (1200, 350, -2);
		c6 = new Car (1100, 250, -2);
		play = false;
		score = 0;

		cars.add(c1);		
		cars.add(c2);
		cars.add(c3);
		//cars.add(c4);
		//cars.add(c5);		
		//cars.add(c6);



		cmat = new Cars();
		car = cmat.makeCars();
 
		p = new PU(100,150,2);
		
		for (Car[] x : car){
			for (Car ca : x){
	//			cars.add(ca);
			}
		}
		
		
		this.addKeyListener(this);
		new Thread(this).start();

		setVisible(true);
	}

   public void update(Graphics window)
   {
	   paint(window);
   }

	public void paint( Graphics window )
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

		
		graphToBack.setColor(Color.BLACK);
		graphToBack.fillRect(0,0,800,600);
		graphToBack.setColor(Color.BLUE);
		graphToBack.drawString("Crossy Road ", 25, 50 );
		graphToBack.drawString("Try to get across the road without hitting any cars. \n ", 25, 100 );
		graphToBack.drawString("Reva Agashe ", 700, 500 );
		graphToBack.drawString("Click the arrows to move. ", 25, 250 );
		graphToBack.drawString("As you continue, the levels will get harder. \n ", 25, 200 );
		graphToBack.drawString("If you do hit a car, you will go down a level. \n ", 25, 150 );
		graphToBack.drawString("Collect coins to increase your score! \n ", 25, 300 );

		graphToBack.drawString("Level: " + level, 700, 50 );
		graphToBack.drawString("Score: " + score, 700, 100 );

		graphToBack.drawString("Press space to begin! ", 25, 350 );

		c.draw(graphToBack);
		
		if (level>=7){
			win = true;
		}
		


		for (Car x : cars){
			x.draw(graphToBack);
		}

		if(keys[0] == true)
		{
			c.move("LEFT");
		}
		if(keys[1] == true)
		{
			c.move("RIGHT");
		}
		if(keys[2] == true)
		{
			c.move("UP");
		}
		if(keys[3] == true)
		{
			c.move("DOWN");
		}
		if(keys[4] == true)
		{
			play = true;
		}

		if (play == true){
			graphToBack.setColor(Color.BLACK);
		//	graphToBack.fillRect(0,0,800,600);
			graphToBack.drawString("Crossy Road ", 25, 50 );
			graphToBack.drawString("Try to get across the road without hitting any cars. \n ", 25, 100 );
			graphToBack.drawString("Reva Agashe ", 700, 500 );
			graphToBack.drawString("Click the arrows to move. ", 25, 250 );
			graphToBack.drawString("As you continue, the levels will get harder. \n ", 25, 200 );
			graphToBack.drawString("If you do hit a car, you will go down a level. \n ", 25, 150 );
			graphToBack.drawString("Collect coins to increase your score! \n ", 25, 300 );

			graphToBack.drawString("Press space to begin! ", 25, 350 );
			p.draw(graphToBack);

			c.setSpeed(5);
			for (Car x : cars){
				if (x.getX()>1000)
				x.setX(x.getX()-1000);
			}
			keys[4] = false;

		}
		
		if (win == true){
			for (Car x : cars){
				x.setSpeed(0);
				x.setPos(x.getX()+1000, x.getY()+1000);
			}
			co.draw(graphToBack);
			graphToBack.setColor(Color.RED);
			graphToBack.drawString("You got to level " + level, 300, 600 );

			
		}
		//add code to move stuff

		//add in collision detection
		
		
	/*	if (alienOne.getX()>730 || alienOne.getX() < 0){
			alienOne.setSpeed(-alienOne.getSpeed());
		}
		if (alienTwo.getX()>730 || alienTwo.getX() < 0){
			alienTwo.setSpeed(-alienTwo.getSpeed());
		}*/
	
		if (c.getX()>730){
			c.setX(10);
		}	
		if (c.getX() < 0){
			c.setX(720);
		}
		if (c.getY() < 0){
			c.setY(520);
			c.setX(300);
			level++;
			Random rand = new Random();
			int a = rand.nextInt(400)+100;
			int b = rand.nextInt(500)+1;
			int c = rand.nextInt(2)+1;
			Car x = new Car(a,b,2);
			if (c%2==1){
				x.setSpeed(-2);
			}
			cars.add(x);
		}
		if (c.getY() > 530){
			c.setY(530);
		}
		
		
		for (Car x : cars){
			
			if (x.getX()>730){
				//x.setX(10);
				x.setSpeed(-x.getSpeed());
			}	
			if (x.getX() < 0){
			//	x.setX(720);
				x.setSpeed(-x.getSpeed());
				
			}

		}
		twoDGraph.drawImage(back, null, 0, 0);
		for (Car a:cars){
			if (a.getSpeed() < 0){
			
				if (a.getX() < c.getX() && a.getX() + 100 > c.getX()){
					if (a.getY() < c.getY() && a.getY() + 40 > c.getY()){
						c.setPos(300, 500);

						if (level>1){
						level -=1;
						cars.remove(cars.size()-1);
					}
					}
				}	
			}
			
			if (a.getSpeed() > 0){
				
				if (a.getX()-180 < c.getX() && a.getX() - 100 > c.getX()){
					if (a.getY() < c.getY() && a.getY() + 40 > c.getY()){
						c.setPos(300, 500);

						if (level>1){
						level -=1;
						cars.remove(cars.size()-1);
					}
					}
				}	
			}
		}

		if (p.getX() -40 < c.getX() && p.getX() + 40 > c.getX()){
			if (p.getY() < c.getY() && p.getY() + 40 > c.getY()){
				
				c=new Character(c.getX(), c.getY(), c.getSpeed());
				
				System.out.println(c.getX() + " " + p.getX());
				p.setPos(10000, 10000);
				score++;
			}
		}
		
		if (p.getY()>730){
			p.setY(30);
			Random rand = new Random();

			int b = rand.nextInt(800)+1;			
			p.setX(b);
		}	
		}
	


	public void keyPressed(KeyEvent e)
	{
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			keys[0] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			keys[1] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP)
		{
			keys[2] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN)
		{
			keys[3] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE)
		{
			keys[4] = true;
		}
		repaint();
	}

	public void keyReleased(KeyEvent e)
	{
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			keys[0] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			keys[1] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP)
		{
			keys[2] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN)
		{
			keys[3] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE)
		{
			keys[4] = false;
		}
		repaint();
	}

	public void keyTyped(KeyEvent e)
	{

	}

   public void run()
   {
   	try
   	{
   		while(true)
   		{
   		   Thread.currentThread().sleep(5);
            repaint();
         }
      }catch(Exception e)
      {
      }
  	}
}

package unit17;
//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

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
import java.util.ArrayList;
import java.util.Random;

public class OuterSpace extends Canvas implements KeyListener, Runnable
{
	private Ship ship;
	private Alien alienOne;
	private Alien alienTwo;
	
	private Aliens aMat;
	private Alien[][] ama;


	/* uncomment once you are ready for this part
	 */
	private ArrayList<Alien> aliens;
	private ArrayList<Ammo> shots;
	private ArrayList<Ammo> Ashots;


	private boolean[] keys;
	private BufferedImage back;
	private PowerUp pup;
	private ShipWithShield sws;
	
	Random rand = new Random();

	int b = rand.nextInt(400)+1;
	
	int points = 0;

	public OuterSpace(){

		setBackground(Color.black);

		keys = new boolean[5];

		//instantiate other stuff
		shots = new ArrayList();
		Ashots = new ArrayList();

		aliens = new ArrayList();
		
		aMat = new Aliens();
		                                                                                                 
		ama = aMat.makeAliens();
		pup = new PowerUp(100,150,2);
		sws = new ShipWithShield(1000,10000);
		
		for (Alien[] al : ama){
			for (Alien b : al){
				aliens.add(b);
			}
		}
		
		ship = new Ship(301,401,5);
		alienOne = new Alien(200,100,2);
		//aliens.add(alienOne);
		alienTwo = new Alien(300,100,-2);
		//aliens.add(alienTwo);
		
		aMat = new Aliens();

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
		int abx = rand.nextInt(100000)+1;


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
		graphToBack.drawString("StarFighter ", 25, 50 );
		graphToBack.drawString("Points: " + points, 25, 70 );


		ship.draw(graphToBack);
		pup.draw(graphToBack);
		sws.draw(graphToBack);
		/*alienOne.draw(graphToBack);
		alienTwo.draw(graphToBack);*/
		for (Alien x : aliens){
			x.draw(graphToBack);
		}
		if(keys[0] == true)
		{
			ship.move("LEFT");
		}
		if(keys[1] == true)
		{
			ship.move("RIGHT");
		}
		if(keys[2] == true)
		{
			ship.move("UP");
		}
		if(keys[3] == true)
		{
			ship.move("DOWN");
		}
		if(keys[4] == true)
		{
			Ammo a = new Ammo(ship.getX() + 35, ship.getY(), 3);
			shots.add(a);
			keys[4] = false;

		}

		//add code to move stuff
		for (Ammo a:shots){
			a.draw(graphToBack);

		}
		for (Ammo a:Ashots){
			a.draw(graphToBack);

		}
		if (pup.getX()>730 || pup.getX() < 0){
			pup.setSpeed(-pup.getSpeed());
		}	
  
		for (Alien x : aliens){
			
			if (x.getX()>730 || x.getX() < 0){
				x.setSpeed(-x.getSpeed());
			}	
		}
		//add in collision detection
		
		
	/*	if (alienOne.getX()>730 || alienOne.getX() < 0){
			alienOne.setSpeed(-alienOne.getSpeed());
		}
		if (alienTwo.getX()>730 || alienTwo.getX() < 0){
			alienTwo.setSpeed(-alienTwo.getSpeed());
		}*/
	
		if (ship.getX()>730){
			ship.setX(10);
		}	
		if (ship.getX() < 0){
			ship.setX(720);
		}
		if (ship.getY() < 0){
			ship.setY(520);
		}
		if (ship.getY() > 530){
			ship.setY(10);
		}
		twoDGraph.drawImage(back, null, 0, 0);

		for (Ammo a:shots){
			for (Alien x : aliens){
				if (x.getX() < a.getX() && x.getX() + 80 > a.getX()){
					if (x.getY() < a.getY() && x.getY() + 80 > a.getY()){
						points ++;
						x.setPos(1000, 10000);
					}
				}	
			}
			
			
		/*	if (alienOne.getX() < a.getX() && alienOne.getX() + 80 > a.getX()){
				if (alienOne.getY() < a.getY() && alienOne.getY() + 80 > a.getY()){
					alienOne.setPos(1000, 10000);
				}
			}
			 
			if (alienTwo.getX() < a.getX() && alienTwo.getX() + 80 > a.getX()){
				if (alienTwo.getY() < a.getY() && alienTwo.getY() + 80 > a.getY()){
					alienTwo.setPos(1000, 10000);
				}
			}*/
			

			
		}
		for (Ammo a:Ashots){

		if (ship.getX() < a.getX() && ship.getX() + 80 > a.getX()){
			if (ship.getY() < a.getY() && ship.getY() + 80 > a.getY()){
				points --;
			}
		}
		}
		for (Alien x : aliens){
		//	if (ship.getX() < a && ship.getX() + 80 > a){
			//	if (ship.getY() < b && ship.getY() + 80 > b){
			
			if (abx%999==0){
				
					Ammo am = new Ammo(x.getX(), x.getY(), -3);
					Ashots.add(am);
				}
			
		}
		
		for (Alien a : aliens){

		if (ship.getX() < a.getX() && ship.getX() + 80 > a.getX()){
			if (ship.getY() < a.getY() && ship.getY() + 80 > a.getY()){
				ship.setPos(300, 400);
				points --;
			}
		}
	}
	

	if (pup.getX() < ship.getX() && pup.getX() + 80 > ship.getX()){
		if (pup.getY() < ship.getY() && pup.getY() + 80 > ship.getY()){
			
			ship=new Ship(ship.getX(), ship.getY(), ship.getSpeed(), "src\\unit17\\ship.jpgWithShield.jpg");
			pup.setPos(10000, 10000);
		}
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


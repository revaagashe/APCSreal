package finalProject;
import javax.swing.JFrame;

import java.awt.Component;

public class CrossyRoad extends JFrame{
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;

	public CrossyRoad ()
	{
		super("Crossy Road");
		setSize(WIDTH,HEIGHT);

		Street theGame = new Street();
		((Component)theGame).setFocusable(true);

		getContentPane().add(theGame);

		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main( String args[] )
	{
		CrossyRoad run = new CrossyRoad();
	}
}

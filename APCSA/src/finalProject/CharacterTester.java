package finalProject;

import unit17.MovingThing;
import unit17.Ship;

public class CharacterTester {
    public static void main( String args[] )
    {
        Character test = new Character();
        System.out.println("a;lsdkf 1 " + test);

        Character test2 = new Character(50,75);
        System.out.println("Ship 2 " + test2);

        Character test3 = new Character();
        test3.setX(3);
        test3.setY(5);
        System.out.println("Ship 3 " + test3);
    }
}

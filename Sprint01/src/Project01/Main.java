package Project01;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import Project01.Nation;
import Project01.Tribe;
import Project01.PlayGame;


public class Main {

    /*
     * The main Function runs the game it creates play game object 
     * and creates a list of nations each with the same number of healthpoints(healthpoints/2)
     * healthpoints is set as 2000
     * then it runs a loop that plays the games until it ends or for 40 rounds
     */
    public static void main(String[] args)
    {
        // initializes game datat
       int gameLifePoints = 2000;
       ArrayList<Nation> nations = new ArrayList<>() ; // nations create tribes create people
       PlayGame game = new PlayGame();
	   nations.add(new Nation("Idiots", (gameLifePoints / 2)));
	   nations.add(new Nation("Minions", (gameLifePoints) / 2));
	   // could add and delete nations. return number of nations + 1 from add and number of nations -1 from remove.
       //loops for 40 rounds or until their is a winner
	   for(int i = 0; i < 40; i++)
       {
           System.out.println("Round number: " + i);
           if (game.playOneRound(nations))
           {
               System.out.println("There is a winner!");
               break; // game over
           }
       }
       //prints winner
	   System.out.println("The winning nation is " + game.getWinner() + ".");
    }
}

package Project01;
import Project01.Nation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.*;


/*
 * The PlayGame class gets the amount of (living) people in the individual nations and the entire world, and within
 * encounters between two random players alive in the world,uses random number generation to determine the amount
 * of damaged deduced from the lifepoints of both players. This will continue until there is one (or no) nation left,
 * then the game will print the winning nation, or print "No Winner!" if there is no living nation
 */
public class PlayGame
{

    private ArrayList<Nation> allLivingNations = new ArrayList<>();
    private ArrayList<People> worldLivingPopulation = new ArrayList<>();
    private Random generator;

    public PlayGame()
    {
        Date seed = new Date();
        generator = new Random(seed.getTime());
    }

    /**
     * This method goes through every nation within the game, then calls each nation's getNationPopulation method, adding
     * up all the people of all the nations into one ArrayList
     */
    public void getWorldLivingPopulation(ArrayList<Nation> nations)
    {
        // add all living people to world list
        worldLivingPopulation.clear();
        //System.out.println(allLivingNations);
        for(int nation = 0; nation < nations.size(); nation++)
            //System.out.println(nations.get(nation));
            worldLivingPopulation.addAll(nations.get(nation).getNationPopulation());
        //System.out.println(worldLivingPopulation);
    }

    /**
     * Checks the lifepoints of each nation through their isNationAlive method, and adds the members of each nation
     * that is alive.
     */
    public void getAllLivingNations(ArrayList<Nation> nations)
    {
        getWorldLivingPopulation(nations);
        allLivingNations.clear();
        for(int nation = 0; nation < nations.size(); nation++)
        {
            if(nations.get(nation).isNationAlive())
            {
                allLivingNations.add(nations.get(nation));
            }
        }
        //System.out.print(allLivingNations);
    }

    /**
     * In the case of the two People being from differing nations, an encounter will cause both players to take a
     * randomly-generated amount of damage to each other, subtracting their lifepoints to those amounts. Does not
     * take strategies into account.
     */
    public void encounter(People p1, People p2)
    {
        // need to fix this to take strategies into account.
        if(p1.getNation() != p2.getNation())
        {
            System.out.print(p1 + " encounters " + p2);
            int p1Damage = (int) (generator.nextFloat() * generator.nextInt(20));
            int p2Damage = (int) (generator.nextFloat() * generator.nextInt(20));
            p1.reduceLifePoints(p1Damage);
            p2.reduceLifePoints(p2Damage);

            System.out.println("\t\tp1 damage is " + p1Damage + ". p2 damage is " + p2Damage + ".");
        }
    }



    /**
     * Getting all the remaining nations (this is called throughout the duration of the 'game'), two indices,
     * other for each encountering player, are randomly-generated from the size of the world's population,
     * and will continue for as long as there is more than one nation.
     */
    public Boolean playOneRound(ArrayList<Nation> nations)
    {
        getAllLivingNations(nations);
        int index = 0;
        while((allLivingNations.size() > 1) && (index < worldLivingPopulation.size()))
        {
            //encounter(worldLivingPopulation.get(pointers.get(index)), worldLivingPopulation.get(pointers.get(index+1)));
            //System.out.println((worldLivingPopulation.size()-1) + "\t" + limit + "\t" + index + "\t" + (index+1));
            int p1Index = generator.nextInt(worldLivingPopulation.size());
            int p2Index;
            do
                p2Index = generator.nextInt(worldLivingPopulation.size());
            while(p1Index == p2Index);
            encounter(worldLivingPopulation.get(p1Index), worldLivingPopulation.get(p2Index));
            getAllLivingNations(nations);
            if(allLivingNations.size() < 2)
                break;
            index = index + 1;
        }

        return (allLivingNations.size() < 2);


    }

    /**
     * Returns the name of the last surviving nation, unless there exists no winner.
     * @return winner
     */
    public String getWinner()
    {
        if (allLivingNations.size() == 0)
            return "No Winner!";
        else
            return allLivingNations.get(0).getNationName();
    }
}

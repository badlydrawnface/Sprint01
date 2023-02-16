package Project01;
import java.util.Collection;
import java.util.Collections;
import java.io.StringBufferInputStream;
import java.util.ArrayList;
import Project01.People;
import Project01.PeopleType;

/**
 * The Tribe class manages a few different properties. It sets nationName, tribeName, life points, and adds people to the tribe
 */
public class Tribe
{
    private String nationName;
    private String tribeName;
    private int tribeLifePoints;
    private ArrayList<People> members = new ArrayList<>();
    private ArrayList<People> livingMembers = new ArrayList<>();

    /**
     * Constructor sets the nationName, tribeName, and life points. It also adds people to the tribes.
     * @param nation
     * @param tribe
     * @param lifePoints
     *
     */
    public Tribe(String nation, String tribe, int lifePoints)
    {
        nationName = nation;
        tribeName = tribe;
        tribeLifePoints = lifePoints;
        for(int i = 0; i < 2; i++)
            if(i % 2 == 0)
                members.add(new People(nationName, tribeName, PeopleType.warrior, tribeLifePoints / 2));
            else
                members.add(new People(nationName, tribeName, PeopleType.wizzard, tribeLifePoints / 2));
        for(int i = 0; i < members.size(); i++)
            livingMembers.addAll(members);
    }

    /**
     *
     * @returns an Arraylist of type people that are still alive and updates the life points of the tribe
     */
    public ArrayList<People> getLivingTribeMembers()
    {
        livingMembers.clear();
        tribeLifePoints = 0;
        for(int person = 0; person < members.size(); person++)
        {
            if(members.get(person).isPersonAlive())
            {
                livingMembers.add(members.get(person));
                tribeLifePoints += members.get(person).getLifePoints();
                //System.out.println(members.get(person));
            }
        }
        //System.out.println(livingMembers);
        return livingMembers;
    }
    /*
    public void printMembers()
    {
        for(int i = 0; i < 2; i++)
        {
            System.out.println(people.get(i));
        }
    }
*/


    /**
     *
     * @returns Returns the size of the tribe as an int
     */
    public int getTribeSize()
    {
        return livingMembers.size();
    }

    /**
     *
     * @return true if the trive is alive or false if they are dead. tribe is alive if their life points are greater than zero
     */
    public Boolean isTribeAlive()
    {
        return (tribeLifePoints > 0);
    }


    /**
     *
     * @return the remaining life points of the tribe as an int
     */
    public int getTribeLifePoints()
    {
        return tribeLifePoints;
    }

    /**
     *
     * @return the name of the tribe
     */
    public String getTribeName()
    {
        return tribeName;
    }


    /**
     * Concatenates tribeName and the size of the tribe all on new lines
     * @return result
     */
    public String toString()
    {
        String result = "\0";

        result = tribeName;
        for(int i = 0; i < members.size(); i++)
        {
            result = result + '\n' + members.get(i).toString();
        }
        result = result + '\n';
        return result;
    }

}

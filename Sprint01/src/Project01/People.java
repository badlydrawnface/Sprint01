package Project01;

import Project01.PeopleType;

public class People
{
  /*
   * The People class holds the information that a person within the game, will have; This includes the 
   * person's name, associated nation, associated tribe, its type, a description, and its lifepoints.
   */
    private String personName;
    private String myNation;
    private String myTribe;
    private PeopleType me;
    private String myDescription;
    private int myLifePoints;


    public People(String nation, String tribe, PeopleType person, int lifePoints)
    {
        myNation = nation;
        myTribe = tribe;
        me = person;
        myDescription = me.getDescription();
        myLifePoints = lifePoints;
    }

    /**
     * Returns the type of the person
     * @return PeopleType
     */
    public PeopleType getType()
    {
        return me;
    }

    /**
     * Returns the tribe of the person
     * @return tribe
     */
    public String getTribe()
    {
        return myTribe;
    }

    /**
     * Returns the person's nation
     * @return nation
     */
    public String getNation()
    {
        return myNation;
    }

    /**
     * Return whether or not the Person is alive
     * @return true/false
     */
    public Boolean isPersonAlive()
    {
        return (myLifePoints > 0);
    }

    /**
     * Returns the lifepoints the person has (left)
     * @return lifepoints
     */
    public int getLifePoints()
    {
        return myLifePoints;
    }

    /**
     * Provides the scenarios when another provided person (parameter) is (or is not) from another nation, as well as scenarios
     * based on the types of the people.
     * @param People otherPerson
     */
    public void encounterStrategy(People otherPerson)
    {
        if(myNation.equals(otherPerson.getNation()))
        {
            // There will be an ugly confrontation
        }
        else
        {
            // there will be a peaceful confrontation
            // warriors - warrior ignore each other if different tribes increase life points
            // healer - healer ignore each other
            // healer - warrior - healer can heal warrior. Heals warrior from same tribe better
        }
    }


    /**
     * Reduces the amount of lifepoints a person has by an amount provided by the points parameter
     * @param int points
     */
    public void reduceLifePoints(int points)
    {
        myLifePoints = myLifePoints - points;
    }

    /**
     * Concatenates the nation name, tribe name, person name, description, and remaining lifepoints into a string with 
     * a tabbed format 
     */
    public String toString()
    {
        String result = new String( myNation + "\t" +  myTribe + "\t" + me + "\t" + myDescription + "\t" + myLifePoints);
        return result;
    }
}


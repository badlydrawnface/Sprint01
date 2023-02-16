package Project01;
/*
 * PeopleType is an enum for the types that players have
 * each type has an discription that is associated with it 
 * and can return that discription with getDescription()
 */
public enum PeopleType
{
    warrior ("Solder"),
    wizzard  ("Tricky"),
    healer ("Mercy");

    private String description;
    
    /*
     * constructs a enum with a discription 
     */
    PeopleType (String types)
    {
        description = types;
    }

    /*
     * @return String discription
     */
    public String getDescription()
    {
        return description;
    }
}

package Project01;

public enum PeopleType
{
    warrior ("Solder"),
    wizzard  ("Tricky"),
    healer ("Mercy");

    private String description;

    PeopleType (String types)
    {
        description = types;
    }


    public String getDescription()
    {
        return description;
    }
}

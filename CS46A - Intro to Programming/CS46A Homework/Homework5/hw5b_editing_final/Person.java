/**
 * Models a person with a name and an age
 * @author Diljot
 */
public class Person
{
    private String name;
    private int age;
    public static final int MAX_AGE = 99;
    public static final int MIN_AGE = 0;
    /**
     * Constructs a new person with the given name and age
     * @param theName the name of this Person object
     * @param theAge the age of this Person object
     */
    public Person (String theName, int theAge) 
    {
        setName(theName);

        if (theAge < MIN_AGE)
        {
            age = MIN_AGE;
        }
        else if(theAge > MAX_AGE)
        {
            age = MAX_AGE;
        }
        else
        {
            age = theAge;
        }
    }

    /**
     * Gets the name of this Person
     * @return the name of this person
     */
    public String getName() 
    {
        return name;

    }

    /**
     * Gets the age of this Person
     * @return this person's age
     */
    public int getAge()
    {
        return age;
    }

    /**
     * Sets the new name for this Person
     * @param newName the new name for this Person
     */
    public void setName(String newName)
    {
        this.name = newName;
        if (newName.equals("John Jacob Jingleheimer Schmidt"))
        {
            this.name = "John Smith";

        }
    }

    /**
     * Adds one to this Person's age
     */
    public void haveBirthday()
    {
        this.age = age + 1;
        if (age > MAX_AGE)
        {
            this.age = MAX_AGE;

        }

    }

}

/**
 * Models a Wildebeest that has 4 different states
 * @author Diljot Singh
 * @version (11-3-2018)
 */
public class Wildebeest
{
    public static final int NOT_HUNGRY = 5;
    public static final int SOMEWHAT_HUNGRY = 2;
    public static final int HUNGRY = 1;
    public static final int VERY_HUNGRY = 4;
    public int state = 0;
    /**
     * Constructs a Wildbeest who's state of hunger is initially very hungry but can change
     */
    public Wildebeest()
    {
        state = VERY_HUNGRY;
    }

    /**
     * Represents the Wildebeest travelling some distance; it becomes more hungry if not already VERY_HUNGRY
     */
    public void travel()
    {
        if (state == NOT_HUNGRY)
        {
            state = SOMEWHAT_HUNGRY;
        }
        else if (state == SOMEWHAT_HUNGRY)
        {
            state = HUNGRY;
        }
        else if (state == HUNGRY)
        {
            state = VERY_HUNGRY;
        }
        else
        {
            state = VERY_HUNGRY;
        }
    }

    /**
     * Represents the Wildebeest seeing food and eating it, if it is in a state of hunger
     */
    public void seeFood()
    {
        if (state == VERY_HUNGRY)
        {
            state = HUNGRY;
        }
        else if (state == HUNGRY)
        {
            state = SOMEWHAT_HUNGRY;
        }
        else if (state == SOMEWHAT_HUNGRY)
        {
            state = NOT_HUNGRY;
        }
        else
        {
            state = NOT_HUNGRY;
        }
    }

    /**
     * Gets a string describing the current hunger state of the Wildebeest
     * @return hungerState the current state of hunger of the Wildebeest as a String
     */
    public String getHungerLevel()
    {
        if (state == NOT_HUNGRY)
        {
            return "Not hungry";
        }
        else if (state == SOMEWHAT_HUNGRY)
        {
            return "Somewhat hungry";
        }
        else if (state == HUNGRY)
        {
            return "Hungry";
        }
        else
        {
            return "Very Hungry";
        }
    }

    /**
     * Gets the integer representing the state, from 1 to 4
     * @return state the state of hunger the Wildebeest is in
     */
    public int getState()
    {
        return state;
    }

}

/**
 * Models a room in a Santa Cruz motel.
 * @author Diljot Singh
 */
public class SantaCruzInnRoom
{
    private String season;
    private int guests;

    public static final double HIGH_SEASON_2_PEOPLE = 250;
    public static final double HIGH_SEASON_4_PEOPLE = 375;
    public static final double LOW_SEASON_2_PEOPLE = 200;
    public static final double LOW_SEASON_4_PEOPLE = 300;
    public static final double COST_PER_EXTRA_PERSON = 50.5;
    
    //Add your constructor
    /**
     * Constructs a SantaCruzInnRoom object with the season 
     * and number of guests as parameters 
     * @param season the season of the year
     * @param numberOfGuests the number of guests
     */
    public SantaCruzInnRoom(String season, int numberOfGuests)
    {
        if (season.equalsIgnoreCase("high") || season.equalsIgnoreCase("low"))
        {
            this.season = season;
        }
        else
        {
            this.season = "high";
        }
        setGuests(numberOfGuests);

    }

    /**
     * Gets the season during which this room is rented
     * @return the season during which this room is rented
     */
    public String getSeason()
    {
        return season;   
    }

    /**
     * Gets the number of people renting the room
     * @return the number of people in the room
     */
    public int getGuests() 
    {
        return guests;
    }

    /**
     * Sets the number of people in the room
     * @param numberOfGuests the number of guests to set to
     */
    public void setGuests(int numberOfGuests)
    {
        if (numberOfGuests <= 0)
        {
            this.guests = 4;
        }
        else
        {
            this.guests = numberOfGuests;
        }
    }

    /** 
     * Gets the cost of this room based on the season and number of guests
     * @return totalCost the cost of this room
     */
    public double getCost()
    {
        double totalCost = 0;
        
        if (season.equals("high"))
        {
            if (guests <= 2)
            {
                totalCost = HIGH_SEASON_2_PEOPLE;
            }
            else if (guests <= 4)
            {
                totalCost = HIGH_SEASON_4_PEOPLE;
            }
            else
            {
                // adds the cost of every additional guest above 4
                totalCost = HIGH_SEASON_4_PEOPLE + COST_PER_EXTRA_PERSON * (guests - 4);
            }
        }
        else
        {
            if (guests <= 2)
            {
                totalCost = LOW_SEASON_2_PEOPLE;
            }
            else if (guests <= 4)
            {
                totalCost = LOW_SEASON_4_PEOPLE;
            }
            else
            {
                // adds the cost of every additional guest above 4
                totalCost = LOW_SEASON_4_PEOPLE + COST_PER_EXTRA_PERSON * (guests - 4);
            }
        }
        return totalCost;
    }
}
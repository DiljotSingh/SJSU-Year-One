import java.util.Random;
/**
 * Models a Random Player that performs tests using a Random object
 * @author Diljot Singh
 * @version (10/18/2018)
 */
public class RandomPlayer
{
    private Random gen = new Random ();
    private int upperBound = 0;
    private int numberOfIterations = 0;
    /**
     * Constructs a RandomPlayer object that takes a generator, upperBound, and number of iterations
     * @param generator the Random object
     * @param upperBound the maximum value of the generated numners
     * @param numberOfIterations number of random ints to generate
     */
    public RandomPlayer(Random generator, int upperBound, int numberOfIterations)
    {
        this.gen = generator;
        this.upperBound = upperBound;
        setIterations(numberOfIterations);
    }

    /** Generates the specific number of random ints and gets the average
     * of the values generated
     * @return average the average of the values generated
     */
    public double average()
    {
        double average = 0;
        int count = 0;
        double sum = 0;
        for (int i = 0; i < numberOfIterations; i++)
        {
            int value = gen.nextInt(upperBound);
            sum = sum + value;
            count++;

        }

        if (count > 0)
        {
            average = sum/count;
        }
        return average;
    }

    /**
     * Generates the specified number of random ints and counts how many are greater than
     * the upperBound/2
     * @return numberOfCounts the number of random ints greater than the mid value
     */
    public int countGreaterThanMidValue()
    {
        double midValue = upperBound/2.0;
        int numberOfCounts = 0;
        for (int i = 0; i < numberOfIterations; i++)
        {
            int value = gen.nextInt(upperBound);
            if (value > midValue)
            {
                numberOfCounts++;
            }
        }
        return numberOfCounts;
    }

    /**
     * Generates the specified number of random ints and calculates the number of times the value appears
     * @param value the value to check match for
     * @return count how many times this value was matched
     */
    public int count(int value)
    {
        int count = 0;
        for (int i = 0; i < numberOfIterations; i++)
        {
            int randomInt = gen.nextInt(upperBound);
            if (randomInt == value)
            {
                count++;
            }
        }
        return count;
    }

    /** 
     * Sets the number of iterations for this object
     * @param numberOfIterations the number of iterations to set this object to
     */
    public void setIterations(int numberOfIterations)
    {
        if (numberOfIterations < 0)
        {
            this.numberOfIterations = 0;
        }
        else 
        {
            this.numberOfIterations = numberOfIterations;
        }
    }
}

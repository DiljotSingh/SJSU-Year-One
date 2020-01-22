
/**
 * Models an Animal that can move, eat, and store or lose energy
 *
 * @author Diljot Singh
 * @version (11-28-2018)
 */
public class Animal
{
    private int energy;
    /**
     * Constructs an Animal that initially has one unit of energy
     */
    public Animal()
    {
        energy = 1;
    }

    /**
     * Simulates the Animal eating and gaining energy
     * @param amountToEat the amount to eat and increase energy by
     */
    public void eat (int amountToEat)
    {
        energy = energy + amountToEat;
    }

    /**
     * Simulates the Animal moving and losing energy
     * @param amountToMove the amount to move and lose energy by
     */
    public void move(int amountToMove)
    {
        energy = energy - amountToMove;
    }

    /**
     * Gets the amount of energy the Animal currently has
     * @return energy
     */
    public int getEnergy()
    {
        return energy;
    }
}

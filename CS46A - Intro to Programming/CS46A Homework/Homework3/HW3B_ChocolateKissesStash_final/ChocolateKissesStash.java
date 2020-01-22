/**
 * Models a stash of Chocolate Kisses that can change in amount
 * @author Diljot Singh
 */
public class ChocolateKissesStash
{
    private int capacity;
    private int amount;
    /**
     * Constructs a ChocolateKissesStash object with given max capacity
     * @param theMaxCapacity the maximum amount of kisses this stash can hold
     */
    public ChocolateKissesStash(int theMaxCapacity)
    {
        //intialize the variables
        capacity = theMaxCapacity;
        amount = 0;

    }

    /**
     * Gets the maximum capacity of this ChocolateKissesStash
     * @return the maximum capacity
     */
    public int getMaxCapacity()
    {
        return capacity;
    }

    /**
     * Gets number of kisses in the ChocolateKissesStash
     * @return current amount of kisses in Stash
     */
    public int getCurrentAmount()
    {
        return amount;
    }

    /**
     * reduces current amount of chocolate kisses by amountToEat
     * @param amountToEat the amount of kisses to eat
     */
    public void eat(int amountToEat)
    {
        this.amount = amount - amountToEat;
    }

    /**
     * simulates adding more kisses to the ChocolateKissesStash
     * @param amountToBuy the amount of kisses to buy
     */
    public void buyMore(int amountToBuy)
    {
        this.amount = amount + amountToBuy;
    }
}
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
        if (theMaxCapacity > 0)
        {
            capacity = theMaxCapacity;
        }
        else
        {
            capacity = 0;
        }
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
        return this.amount;
    }

    /**
     * reduces current amount of chocolate kisses by amountToEat
     * @param amountToEat the amount of kisses to eat
     */
    public void eat(int amountToEat)
    {
        if (amount > 0)
        {
            if (amountToEat > 0)
            {
                if (amountToEat > amount)
                {
                    this.amount = 0;
                }
                else
                {
                    this.amount = amount - amountToEat;
                }

            }    
        }
        //amount = Math.max(amount,0);
    }

    /**
     * simulates adding more kisses to the ChocolateKissesStash
     * @param amountToBuy the amount of kisses to buy
     */
    public void buyMore(int amountToBuy)
    {
        if (amountToBuy > 0)
        {
            this.amount = this.amount + amountToBuy;
            if (amount > capacity)
            {
                amount = capacity;
            }
        }
    }
}
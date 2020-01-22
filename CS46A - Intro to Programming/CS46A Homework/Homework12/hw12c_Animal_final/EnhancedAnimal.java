
/**
 * A subclass of Animal, models a more realistic Animal which can move, eat, and store or lose energy to certain cap
 *
 * @author Diljot Singh
 * @version (11-28-2018)
 */
public class EnhancedAnimal extends Animal
{
    private int maxEnergy;
    /**
     * Constructs an EnhancedAnimal that has a maximum energy 
     * @param maximumEnergy the maximum amount of energy this EnhancedAnimal can have
     */
    public EnhancedAnimal(int maximumEnergy)
    {
        this.maxEnergy = maximumEnergy;
    }

    /**
     * Simulates the Animal eating and gaining energy, up to the max energy it can have
     * @param amountToEat the amount to eat and gain energy, up to a cap
     */
    public void eat (int amountToEat)
    {
        if ((getEnergy() + amountToEat > maxEnergy) && (amountToEat > 0))
        {
            super.eat(maxEnergy - getEnergy());
        }
        else if ((getEnergy() + amountToEat <= maxEnergy) && (amountToEat > 0))
        {
            super.eat(amountToEat);
        }
    }

    /**
     * Simulates the Animal moving and losing energy,to a minimum of zero energy
     * @param amountToMove the amount to move and lose energy, down to a minimum of zero
     */
    public void move (int amountToMove)
    {
        if ((amountToMove > 0) && (getEnergy() - amountToMove > 0)) //Vanilla case, have enough energy to move the amount you want
        {
            super.move(amountToMove);
        }
        else if ((amountToMove > 0 ) && (getEnergy() - amountToMove <= 0)) //If moving will reduce energy below zero, move only as much as you can
        {
            super.move(getEnergy());
        }

    }
}

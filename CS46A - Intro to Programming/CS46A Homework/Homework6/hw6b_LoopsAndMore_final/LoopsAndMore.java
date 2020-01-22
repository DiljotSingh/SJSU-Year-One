
/**
 * Models a Loop that performs various functions
 * @author Diljot Singh
 */
public class LoopsAndMore
{
    /**
     * Gets the sum of every third number less than the limit starting from 3 but excludes numbers divisible by 5 (such as 15)
     * @param limit the number to calculate the sum for
     * @return sum the sum of every third number below the limit, excluding numbers divisible by 5
     */

    public int sumEveryThird(int limit)
    {
        int sum = 0;
        for (int x=0; x < limit; x += 3)
        {
            if (x % 3 == 0 && x % 5 != 0)
            {
                sum = sum + x;
            }
        }
        return sum;
    } 

    public String printJava(int count)
    {
        String out = "";
        for (int i = 0; i < count; i++)
        {
            out = out + "Java ";
        }
        return out;
        
    }

    public int largestPowerOf2(int target)
    {
        int x = 0;
        int largestPower = (int)Math.pow(2,x);
        if (target <= 1)
        {
            return -1;
        }
        
        while (largestPower < target)
        {
            largestPower = (int)Math.pow(2, x);
            x++;
        }
        if (largestPower >= target)
        {
            largestPower = (int)Math.pow(2,x-2);
        }
        else
        {
            largestPower = (int)Math.pow(2,x-1);
        }
        return largestPower;
    }
}
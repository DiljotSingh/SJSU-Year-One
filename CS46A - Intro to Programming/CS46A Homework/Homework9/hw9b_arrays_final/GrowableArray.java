import java.util.Arrays;
/**
 * An array that can grow and shrink
 * @author Diljot Singh
 */
public class GrowableArray
{
    private String[] contents;
    private int size; //the number of elements actually in the array
    public static final int CAPACITY = 8;
    /**
     * Constructs a GrowableArray object which initalizes the contents array
     */
    public GrowableArray()
    {
        contents = new String[CAPACITY];
        size = 0;
    }

    /**
     * Adds the given string at the end of the partially filled array
     * @param toAdd the string to add to contents[]
     */
    public void add(String toAdd)
    {
        if (size >= contents.length)
        {
            growIfNeeded();
        }

        if (size < contents.length)
        {
            size++;
            contents[size - 1] = toAdd;

        }
    }

    /**
     * Adds the string at the specified index
     * @param toAdd the string to add to the array
     * @param index the index at which the string will be added
     */
    public void add(String toAdd, int index)
    {
        if (size >= contents.length)
        {
            growIfNeeded();
        }

        if (size < contents.length)
        {
            size++;
            for (int i = size -1; i > index; i--)
            {
                contents[i] = contents[i-1];
            }
            contents[index] = toAdd;

        }

    }

    /**
     * Removes the element at the given index
     * @param index the index at which the element will be removed
     */
    public void remove (int index)
    {
        if (index >= 0  && index < size)
        {
            for (int i = index + 1; i < size; i++)
            {
                contents[i-1] = contents[i];
            }
            size--;
        }
    }

    /* Notice this is not Javadoc since the method is not part of the public interface
     * 
     * If the array is at capacity, doubles the size of the array by creating a new array that is twice 
     * as big,  copying the elements from the old array to the new array
     * and assigning the new array to the array reference (instance variable) 
     * 
     * (Note: the array is at capacity when the instance variable size equals the length of the array
     * 
     */
    private void growIfNeeded()
    {
        if( size == contents.length)
        {
            String[] bigger = Arrays.copyOf(contents, size * 2);
            contents = bigger;

        }
    }

    //Can not just use Arrays.toString because we only want the elements 
    //in the partially filled array - not all the elements.
    @Override
    public String toString()
    {
        String s = "[";
        for (int i = 0; i < size; i++)
        {
            if (i != 0)
            {
                s = s +", ";
            }
            s = s + contents[i];
        }

        s = s + "]";
        return s;
    }

}
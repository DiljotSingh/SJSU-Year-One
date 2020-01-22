
/**
 * Models a LetterSearcher that uses a letter input to perform various tasks
 * @author Diljot Singh
 */
public class LetterSearcher
{
    private String letter = "";
    /**
     * Constructs a LetterSearcher object with a String parameter
     * @param letter the letter to perform the methods with
     */
    public LetterSearcher(String letter)
    {
        this.letter = letter;
    }

    /** 
     * Returns the number of times the letter occurs in the phrase
     * @param phrase the phrase to iterate through
     * @return count the number of times the letter occurred in the phrase
     */
    public int letterCount(String phrase)
    {
        int count = 0;
        for (int i=0; i<phrase.length(); i++)
        {
            String ch = phrase.substring(i, i+1);
            if (ch.equals(letter))
            {
                count++;
            }
        }
        return count;
    }

    /**
     * Looks for the first place the letter appears consecutively
     * @param phrase the phrase to iterate through
     * @return index the index of the first pair (-1 if doesn't exist)
     */
    public int doubleIndex(String phrase)
    {
        boolean found = false;
        int index = 0;
        while (!found && index >= 0)
        {
            if (phrase.contains(letter+letter))
            {
                index = phrase.indexOf(letter+letter);
                found = true;
            }
            else
            {
                index = -1;
            }
        }
        return index;
    }

    /**
     * Gets the character for this LetterSearcher
     * @return letter the letter in this LetterSearcher
     */
    public String getLetter()
    {
        return letter;
    }
}

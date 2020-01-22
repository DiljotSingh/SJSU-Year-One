/**
 * Models a line of Text.
 * @author Diljot
 */
public class Text
{
    String text = "";
    /**
     * Constructs a Text object
     * @param theText the text of the string
     */
    public Text(String theText)
    {
        this.text = theText;
    }

    /**
     * Determines if the string is a single digit
     * @param ch the String to test
     * @return true if the string contains a single digit else false
     */
    public boolean isDigit(String ch)
    {
        if (ch.length() != 1)
        {
            return false;
        }
        else 
        {
            return Character.isDigit(ch.charAt(0));
        }
    }

    /**
     * Gets the text
     * @return text
     */
    public String getText()
    {
        return text;
    }

    /**
     * Gets the number of a's in a String
     * @return count the counted number of a's
     */
    public int getACount()
    {
        int count = 0;
        for (int i = 0; i < text.length(); i++)
        {
            String ch = text.substring(i, i+1);
            if (ch.equalsIgnoreCase("a"))
            {
                count++;
            }
        }
        return count;
    }

    /**
     * Gets the digits in a string
     * @return digits the digits in the string
     */
    public String getDigitsOnly()
    {
        String digits = "";
        for(int i=0; i < text.length(); i++)
        {
            if (isDigit(text.substring(i,i+1)))
            {
                digits = digits + text.substring(i,i+1);
            }
        }
        return digits;
    }

    /**
     * Gets a String consisting of the first characters of every word in the Text. 
     * @return a String consisting of the first characters of every word in the Text.
     * If the String is less than 2 characters long, return the text
     * 
     */
    public String firsts()
    {
        if (text.length() < 2)
        {
            return text;
        }

        String firsts = text.substring(0, 1);
        int indexOfSpace = text.indexOf(" ");
        while (indexOfSpace != -1)
        {
            firsts = firsts + text.substring(indexOfSpace + 1, indexOfSpace + 2);
            indexOfSpace = text.indexOf(" ", indexOfSpace + 1);
        }

        return firsts;
        
        
    }
}

/* for (int i = 0; i < stringOftext.length(); i++)
{
    if text.substring(i, i+1).equals(" "))
    {
        first letter = stringofText.substring(0,1);
        stringOFfIRSTS = stringOfFirsts + stringOfText.substring(i +1, i+2);
        
        return firstLETTER + stringOfFIRSTS; */
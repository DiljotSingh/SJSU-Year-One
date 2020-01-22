/**
 * Use some string methods
 * 
 * @author (your name) 
 */
public class WorkingWithStrings
{
    public static void main(String[] args)
    {
        String word =  "sweethearT"; 
        //do not change the line above here
        //add your code between here
        System.out.println(word.toLowerCase());
        System.out.println(word.length());
        
        String word1 = word.replace("s", "$");
        System.out.println(word1);
        
        String word2 = word1.replace("e", "3");
        System.out.println(word2);
        
        String word3 = word2.replace("a", "4");
        System.out.println(word3);
        
 
        //and here
        System.out.println("original word: " + word); // do not change this line
        
      
    }
}
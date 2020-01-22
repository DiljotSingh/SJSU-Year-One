import java.util.ArrayList;
/**
 * Tester for the static methods of StaticPractice
 * 
 * @author Kathleen O'Brien
 */
public class StaticPracticeTester
{
    public static void main(String[] args)
    {
        //array max
        int[] numbers = {5, 6, 9, 8, 6,  7, 6};
        int[] numbers2 = {-5, -9, -8, -2, -7, -10, -5, -11};
        int[] numbers3 = {};
        
        System.out.println("max array: "+ StaticPractice.max(numbers));
        System.out.println("Expected: 9.0");        
        System.out.println("max array: "+ StaticPractice.max(numbers2));
        System.out.println("Expected: -2.0");        
        System.out.println("max array: "+ StaticPractice.max(numbers3));
        System.out.println("Expected: -2.147483648E9");
               
        //arraylist max
        ArrayList<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(6);
        list.add(9);
        list.add(8);
        list.add(6);
        list.add(7);
        list.add(6);
        
        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(-5);
        list2.add(-9);
        list2.add(-8);
        list2.add(-2);
        list2.add(-7);
        list2.add(-10);
        list2.add(-5);
        list2.add(-11);
        
        ArrayList<Integer> list3 = new ArrayList<>();
        
        System.out.println("max ArrayList: "
           + StaticPractice.max(list));
        System.out.println("Expected: 9.0");
       
        System.out.println("max ArrayList: "
           + StaticPractice.max(list2));
        System.out.println("Expected: -2.0");
        
        System.out.println("max ArrayList: "
           + StaticPractice.max(list3));
        System.out.println("Expected: -2.147483648E9");  
        
       //array containsMultiple    
       String[] strings = {"cat", "dog", "horse", "snake", "cat", "parrot",
           "cat", "pig", "cow", "horse"};
       System.out.println("multiples array: "
           + StaticPractice.containsMultiple(strings,"cat"));
       System.out.println("Expected: true");   
       System.out.println("multiples array: "
           + StaticPractice.containsMultiple(strings,"dog"));
       System.out.println("Expected: false");
       System.out.println("multiples array: "
           + StaticPractice.containsMultiple(strings,"hamster"));
       System.out.println("Expected: false"); 
       System.out.println("multiples array: "
           + StaticPractice.containsMultiple(strings,"horse"));
       System.out.println("Expected: true"); 
       
       //array list containsMultiple 
       ArrayList<String> words = new ArrayList<>();
       words.add("cat");
       words.add("dog");        
       words.add("snake"); 
       words.add("cat");
       words.add("parrot");
       words.add("cat"); 
       words.add("cow");
       words.add("pig");
       words.add("horse");
       words.add("horse");
       
       System.out.println("multiples arraylist: "
           + StaticPractice.containsMultiple(words,"cat"));
       System.out.println("Expected: true");   
       System.out.println("multiples arraylist: "
           + StaticPractice.containsMultiple(words,"dog"));
       System.out.println("Expected: false");
       System.out.println("multiples arraylist: "
           + StaticPractice.containsMultiple(words,"hamster"));
       System.out.println("Expected: false"); 
       System.out.println("multiples arraylist: "
           + StaticPractice.containsMultiple(words,"horse"));
       System.out.println("Expected: true"); 
    }
    
}
public class GrowableArrayTester
{

   public static void main(String[] args)
   {
      GrowableArray processor = new GrowableArray();
      processor.add("Mary");
      processor.add("had");
      processor.add("a");
      processor.add("a");
      processor.add("little");
      processor.add("lamb");
      
      System.out.println(processor.toString());
      System.out.println("Expected: [Mary, had, a, a, little, lamb]");
      
      processor.remove(3);
      System.out.println(processor.toString());
      System.out.println("Expected: [Mary, had, a, little, lamb]");
      processor.remove(5); //should have not effect
      System.out.println(processor.toString());
      System.out.println("Expected: [Mary, had, a, little, lamb]");
      
      processor.add("Its");
      processor.add("fleece");
      processor.add("was");
      processor.add("was");
      processor.add("white");
      processor.add("as");    
      processor.add("snow");
      System.out.println(processor.toString());
      System.out.println("Expected: [Mary, had, a, little, lamb, Its, fleece, was, was, white, as, snow]");
      
      processor.remove(7);
      System.out.println(processor.toString());
      System.out.println("Expected: [Mary, had, a, little, lamb, Its, fleece, was, white, as, snow]");
      
      processor.add("very", 3);
      System.out.println(processor.toString());
      System.out.println("Expected: [Mary, had, a, very, little, lamb, Its, fleece, was, white, as, snow]");
      processor.add("baby", 5);
      System.out.println(processor.toString());
      System.out.println("Expected: [Mary, had, a, very, little, baby, lamb, Its, fleece, was, white, as, snow]");
   }

}
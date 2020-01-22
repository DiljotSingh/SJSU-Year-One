/**
 * Tests the Person class
 *
 * @author Kathleen O'Brien
 */
public class PersonTester
{
    public static void main(String[] args)
    {
        Person person1 = new Person("Aruna", 19);
        System.out.println(person1.getName());
        System.out.println("Expected: Aruna");
        
        Person person2 = new Person("Carlos", 23);
        System.out.println(person2.getName());
        System.out.println("Expected: Carlos");
        
        //Note: the expected values for the following methods 
        //will not be correct at this point. They are stubs.
        System.out.println(person1.getAge());
        System.out.println("Expected: 0");
        person1.haveBirthday();
        System.out.println(person1.getAge());
        System.out.println("Expected: 0");
        person1.setName("Maria");
        System.out.println(person1.getName());
        System.out.println("Expected: Aruna");
        
    }
}
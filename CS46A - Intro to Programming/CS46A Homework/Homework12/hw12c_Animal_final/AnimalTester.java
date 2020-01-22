public class AnimalTester
{
    public static void main(String [] args)
    {
        EnhancedAnimal animal = new EnhancedAnimal(25);
        
        System.out.println("just born : " + animal.getEnergy());
        System.out.println("Expected: 1");
        
        animal.move(10);
        System.out.println("move too much: " + animal.getEnergy());
        System.out.println("Expected: 0");

        animal.eat(15);
        System.out.println("eat: " + animal.getEnergy());
        System.out.println("Expected: 15");
        
        animal.eat(-5);
        System.out.println("eat negative: " + animal.getEnergy());
        System.out.println("Expected: 15");


        animal.move(-5);
        System.out.println("move negative: " + animal.getEnergy());
        System.out.println("Expected: 15");
        
        animal.move(5);
        System.out.println("move: " + animal.getEnergy());
        System.out.println("Expected: 10");

        animal.move(20);
        System.out.println("move too much: " + animal.getEnergy());
        System.out.println("Expected: 0");
        
        animal.eat(50);
        System.out.println("eat above max: " + animal.getEnergy());
        System.out.println("Expected: 25");
        
        animal = new EnhancedAnimal(10);
        System.out.println("just born : " + animal.getEnergy());
        System.out.println("Expected: 1");
        
        animal.eat(5);
        System.out.println("eat: " + animal.getEnergy());
        System.out.println("Expected: 6");
        
        animal.eat(4);
        System.out.println("eat to max: " + animal.getEnergy());
        System.out.println("Expected: 10");
        
        animal.eat(5);
        System.out.println("eat past max: " + animal.getEnergy());
        System.out.println("Expected: 10");


    }
}
import java.util.ArrayList;
public class InterfaceRunner
{
   public static void main(String[] args)
   {
	   ArrayList<GeometricShape> shapes = new ArrayList<>();
       shapes.add(new Parallelogram(10, 15));
       shapes.add(new Parallelogram(11, 11));
       shapes.add(new Circle(10));
       shapes.add(new Circle(100));
       shapes.add(new RightTriangle(10, 15));
       shapes.add(new RightTriangle(11, 11));
       
       for (GeometricShape shape : shapes)
       {
           System.out.printf("%.2f%n",shape.area());
       }

   }
}
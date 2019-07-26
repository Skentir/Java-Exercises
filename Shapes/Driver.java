import java.util.ArrayList;

public class Driver
{
    public static void main(String[] args)
    {
        ArrayList<Shape> shapes = new ArrayList<>();
        shapes.add(new Circle(10.0));
        shapes.add(new Triangle(5.0));
        shapes.add(new Triangle(3.0, 4.0, 5.0));
        shapes.add(new Circle(2.0));
        shapes.add(new Rectangle(5.0));
        shapes.add(new Rectangle(4.0, 2.0));

        for (Shape s : shapes)
        {
            System.out.println("Type is " + s.getClass().getName());
            System.out.println("Area: " + s.computeArea());
            System.out.println("Perimeter: " + s.computePerimeter());
            System.out.println();
        }
    }
}

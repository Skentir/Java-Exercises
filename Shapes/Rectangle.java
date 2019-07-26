import java.util.ArrayList;
import java.util.Arrays;

public class Rectangle extends Polygon
{
    public Rectangle(double side)
    {
        this(side, side);
    }

    public Rectangle(double width, double length)
    {
        super(new ArrayList<Double>(Arrays.asList(width, length, width, length)));
    }

    @Override
    public double computeArea()
    {
        return side.get(0) * side.get(1);
    }
}

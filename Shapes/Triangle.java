import java.util.ArrayList;
import java.util.Arrays;

public class Triangle extends Polygon
{
    public Triangle(double s)
    {
        this(s, s, s);
    }

    public Triangle(double s1, double s2, double s3)
    {
        super(new ArrayList<Double>(Arrays.asList(s1, s2, s3)));
    }

    @Override
    public double computeArea()
    {
        double s1 = side.get(0);
        double s2 = side.get(1);
        double s3 = side.get(2);

        double s = (s1 + s2 + s3) / 2.0;
        return Math.sqrt(s * (s - s1) * (s - s2) * (s - s3));
    }
}

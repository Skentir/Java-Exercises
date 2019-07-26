import java.util.ArrayList;

abstract public class Polygon extends Shape
{
  protected ArrayList<Double> side;

  protected Polygon(ArrayList<Double> side)
  {
    this.side = side;
  }
  @Override
  public double computePerimeter()
  {
    double per = 0;
    for(int i = 0; i < side.size(); i++)
    {
      per += side.get(i);
    }
    return  per;
  }
}

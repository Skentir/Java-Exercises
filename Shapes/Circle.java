public class Circle extends Shape
{
  private double radius;

  public Circle(double radius)
  {
    this.radius = radius;
  }
  @Override
  public double computeArea()
  {
      return Math.PI * radius * radius;
  }
  @Override
  public double computePerimeter()
  {
      return 2 * Math.PI * radius;
  }

}

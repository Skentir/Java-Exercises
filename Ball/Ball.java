public abstract class Ball implements Tossable
{
  private String brandName;

  protected Ball(String name)
  {
    this.brandName = name;
  }

  public String getBrandName()
  {
      return brandName;
  }

  public abstract void toss();
  public abstract void bounce();
}

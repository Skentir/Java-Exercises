public class Baseball extends Ball
{
  public Baseball(String name)
  {
    super(name);
  }

  public void toss()
  {
    System.out.println("You threw a baseball");
  }

  public void bounce()
  {
    System.out.println("Bounced once!");
  }
}

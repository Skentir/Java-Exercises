public class Football extends Ball
{
  public Football(String name)
  {
    super(name);
  }

  public void toss()
  {
    System.out.println("You threw a football");
  }

  public void bounce()
  {
    System.out.println("Bounced thrice!");
  }
}

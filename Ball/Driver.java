import java.util.ArrayList;

public class Driver
{
    public static void main (String[] args)
    {
      ArrayList<Ball> balls = new ArrayList<>();
      balls.add(new Baseball("Johnny"));
      balls.add(new Football("Krissy"));
      balls.add(new Football("Charles"));

      for (Ball p: balls)
      {
        if (p instanceof Football)
          ((Football)p).toss();
        else if (p instanceof Baseball)
          ((Baseball)p).toss();
        if (p instanceof Tossable)
            System.out.println("It's tossable");
      }

      Rock dumbo = new Rock();
      if (dumbo instanceof Tossable)
        dumbo.toss();
    }
}

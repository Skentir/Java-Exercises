import java.util.*;

public class FileDriver
{
  public static void main(String[] args)
  {
    Scanner sc = new Scanner(System.in);
    Matchmaker dlsu_singles_to_pick = new Matchmaker();
    dlsu_singles_to_pick.genMatches();
    ArrayList<Person> people_with_life = dlsu_singles_to_pick.getPossMatchesVer1();

    System.out.println("People who have a chance of love: ");
    for(Person p: people_with_life)
      System.out.println(p.getName());

    System.out.println("Andrew's sugarbabes: ");
    ArrayList<Person> andrw_sugarbabes = dlsu_singles_to_pick.getPossMatchesVer2("Andrew");
    String reply; Person babe, bachelor = dlsu_singles_to_pick.getPersonByName("Andrew");

    for(Person p: andrw_sugarbabes)
      System.out.println(p.getName());

    System.out.println("Who will Andrew Marry?");
    for(Person p: andrw_sugarbabes)
    {
      if (bachelor.getSpouse() == null)
      {
        System.out.println("Andrew marry " + p.getName() + " ?");
        do
        {
          reply = sc.nextLine();
        } while(!reply.equalsIgnoreCase("yes") && !reply.equalsIgnoreCase("no"));

        if (reply.equalsIgnoreCase("yes"))
          bachelor.marry(p);
      }
    }
    System.out.println(bachelor.toString());
    sc.close();
  }
}

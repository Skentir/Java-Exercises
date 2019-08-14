import java.util.*;

public class FileDriver
{
  public static void main(String[] args)
  {
    Matchmaker dlsu_singles_to_pick = new Matchmaker();
    dlsu_singles_to_pick.genMatches();
    ArrayList<Person> people_with_life = dlsu_singles_to_pick.getPossMatchesVer1();

    System.out.println("People who have a chance of love: ");
    for(Person p: people_with_life)
      System.out.println(p.getName());

    System.out.println("Andrew's sugarbabes: ");
    ArrayList<Person> andrw_sugarbabes = dlsu_singles_to_pick.getPossMatchesVer2("Andrew");
    for(Person p: andrw_sugarbabes)
      System.out.println(p.getName());
  }
}

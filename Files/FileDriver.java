import java.util.*;

public class FileDriver
{
  public static void main(String[] args)
  {
    Scanner sc = new Scanner(System.in);
    Matchmaker dlsu_singles_to_pick = new Matchmaker();
    dlsu_singles_to_pick.genMatches();
    ArrayList<Person> matches = dlsu_singles_to_pick.getPossMatches();
    String reply;
    for(Person p: matches)
    {
      for (int j=0; j < matches.size(); j++)
      {
        if (p.getSpouse() == null && matches.get(j).getSpouse() == null &&
            !p.getName().equalsIgnoreCase(matches.get(j).getName()) &&
            p.getGender().equalsIgnoreCase("female") && !p.getGender().equalsIgnoreCase(matches.get(j).getGender()) &&
            p.getAge() == matches.get(j).getAge())
        {
          System.out.println("Marry?");
          System.out.println(p.getName() + " - " + matches.get(j).getName());
          do
          {
            reply = sc.nextLine();
          } while(!reply.equalsIgnoreCase("yes") && !reply.equalsIgnoreCase("no"));

          if (reply.equalsIgnoreCase("yes")) {
            p.marry(matches.get(j));
          }
        }
      }
    }

    System.out.println("Results: ");
    ArrayList<Person> lasallians = dlsu_singles_to_pick.getHumans();
    for(Person p: lasallians)
    {
      System.out.println(p.toString());
    }
    sc.close();
  }
}

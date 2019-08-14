import java.io.*;
import java.util.ArrayList;
public class Matchmaker
{
  private ArrayList<Person> humansDB = new ArrayList<>();
  // Finds possible matches and return
  public void genMatches()
  {
    try
    {
      FileInputStream fileDB =  new FileInputStream("peeps.txt");
      InputStreamReader inDB = new InputStreamReader(fileDB);
      BufferedReader peopleDB = new BufferedReader(inDB);
      BufferedWriter outputDB = new BufferedWriter(new FileWriter("possMatches.txt"));
      readPeople(peopleDB);
      for (Person p: humansDB)
      {
        for (Person j: humansDB)
        {
          if (!p.getGender().equalsIgnoreCase(j.getGender()))
            if (p.getAge() == j.getAge())
              if (p.getGender().equalsIgnoreCase("female"))
                outputDB.write(p.getName() + " " + j.getName() + "\n");
        }
      }

      outputDB.close();
      peopleDB.close();
      inDB.close();
      fileDB.close();
    }
    catch (Exception e)
    {
      System.out.println(e.getMessage());
    }
  }
  /* Ver 2 accepts a name of a person and returns the ArrayList of poss matches */
  public ArrayList<Person> getPossMatchesVer2(String name)
  {
    ArrayList<Person> matches = new ArrayList<>();
    Person p = getPersonByName(name);
    try
    {
      FileInputStream match_file= new FileInputStream("possMatches.txt");
      InputStreamReader match_in_DB = new InputStreamReader(match_file);
      BufferedReader matchDB = new BufferedReader(match_in_DB);
      String[] data; String k; Person a, b;
      while ((k = matchDB.readLine()) != null)
      {
      //  System.out.println("match: " + p);
        data = k.split(" ");
        a = getPersonByName(data[0]);
        b = getPersonByName(data[1]);
    //    System.out.println(a.getName() + " " + b.getName());
        if (a.getName().equalsIgnoreCase(p.getName()))
            matches.add(b);
        else if (b.getName().equalsIgnoreCase(p.getName()))
            matches.add(a);
      }
      matchDB.close();
      match_in_DB.close();
      match_file.close();
    }
    catch (Exception e)
    {
      System.out.println(e.getMessage());
    }
    finally
    {
      return matches;
    }
  }
  /* Ver 1 returns the ArrayList of People with Matches */
  public ArrayList<Person> getPossMatchesVer1()
  {
    ArrayList<Person> matches = new ArrayList<>();
    try
    {
      FileInputStream match_file= new FileInputStream("possMatches.txt");
      InputStreamReader match_in_DB = new InputStreamReader(match_file);
      BufferedReader matchDB = new BufferedReader(match_in_DB);
      String[] data; String p; Person a, b;
      while ((p = matchDB.readLine()) != null)
      {
      //  System.out.println("match: " + p);
        data = p.split(" ");
        a = getPersonByName(data[0]);
        b = getPersonByName(data[1]);
    //    System.out.println(a.getName() + " " + b.getName());
        if (!isAdded(a, matches))
          matches.add(a);
        if (!isAdded(b, matches))
          matches.add(b);
      }
      matchDB.close();
      match_in_DB.close();
      match_file.close();
    }
    catch (Exception e)
    {
      System.out.println(e.getMessage());
    }
    finally
    {
      return matches;
    }
  }

  public Person getPersonByName(String name)
  {

    String temp;
    for (Person k: humansDB)
    {
        temp = k.getName();
        if (temp.equalsIgnoreCase(name))
          return k;
    }
    return null;
  }

  private boolean isAdded(Person p, ArrayList<Person> db)
  {
    if (db.size() != 0)
    {
      for (Person k: db)
      {
        if (k.getName().equalsIgnoreCase(p.getName()))
          return true;
      }
      return false;
    } else
      return false;
  }

  private void readPeople(BufferedReader reader)
  {
    try {
      String p; String[] data; int a;
      while ((p = reader.readLine())!= null)
      {
        data = p.split(" ");
        humansDB.add(new Person(data[0], data[1], Integer.parseInt(data[2])));
      }
    }
    catch (Exception e)
    {
      System.out.println(e.getMessage());
    }
  }


}

import java.io.*;
import java.util.ArrayList;
public class DocumentDriver
{
  public static void main (String[] args)
  {
    ArrayList<Document> docs = new ArrayList<>();

    try
    {
      FileInputStream fis = new FileInputStream("names.txt");
      InputStreamReader isr = new InputStreamReader(fis);
      BufferedReader buff = new BufferedReader(isr);

      String p; String[] full;
      while((p = buff.readLine()) != null)
      {
        full = p.split(" ");
//        System.out.println("Found: " + p);
        if (full.length == 1)
        {
          System.out.println(p + " goes to condition 1");
          docs.add(new EMail());
          ((EMail)docs.get(docs.size()-1)).addAuthor(p);
        }
        else if (full.length == 2)
        {
          System.out.println(p + " goes to condition 2");
          docs.add(new Book());
          ((Book)docs.get(docs.size()-1)).addAuthor(p);
        }
        else
        {
          System.out.println(p + " goes to condition 3");
          boolean stop = true;
          int i = 0;
          while(i < docs.size() && stop)
          {
        //    System.out.println(" in a loop ");
            if (docs.get(i) instanceof Book && !p.contains("-"))
            {
          //            System.out.println(" goes to condition 3 book");
                      ((Book)docs.get(i)).setTitle(p);
                      System.out.println(((Book)docs.get(i)).getTitle());
                      stop = false;
            }
            else if (docs.get(i) instanceof EMail && p.contains("-"))
            {
            //  System.out.println(" goes to condition 3 email");
              //System.out.println("Your subject is " + p);
              ((EMail)docs.get(i)).setSubject(p);
              // System.out.println(" set a subject");
              ((EMail)docs.get(i)).addRecipient("manager@wipro.com");
              ((EMail)docs.get(i)).addRecipient("talentteam@wipro.com");
              // System.out.println(" set a recipient");
              stop = false;
            }
            else
              System.out.println("No instance! " + p);
            i++;
          }
        }
      }

      buff.close();
      isr.close();
      fis.close();

      BufferedWriter out = new BufferedWriter(new FileWriter("results.txt"));
      //System.out.println(" START OUTPUT ");
      for (Document file: docs)
      {
        if (file instanceof Book)
        {
        //  System.out.println("Found a Book ");
          System.out.println(((Book)file).getAuthors());
          out.write(((Book)file).getAuthors()+"\n");
          if (((Book)file).getTitle() != null)
          {
            System.out.println(((Book)file).getTitle());
            out.write(((Book)file).getTitle()+"\n");
          }
        }
        else if (file instanceof EMail)
        {
          //System.out.println("Found an Email ");
          System.out.println(((EMail)file).getAuthors()+"\n");
            //System.out.println("Found an Email recipient ");
          System.out.println(((EMail)file).getRecipient()+"\n");
            //System.out.println("Found an Email subject ");
          System.out.println(((EMail)file).getSubject());
          out.write(((EMail)file).getAuthors()+"\n");
          out.write(((EMail)file).getRecipient());
          out.write(((EMail)file).getSubject()+"\n");
        } else
        System.out.println("Oops!");
      }

      out.close();
    }

    catch (Exception e)
    {
      System.out.println(e.getMessage());
    }
  }
}

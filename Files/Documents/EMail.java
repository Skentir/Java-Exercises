import java.util.*;
public class EMail extends Document
{
  private String subject;
  private String[] to = new String[2];

  public String getSubject()
  {
      return subject;
  }

  public void setSubject(String sub)
  {
      subject = sub;
  }

  public String getRecipient()
  {
    String word ="";
    for (int i = 0; i < to.length; i++)
    {
      if (to[i] != null)
      {
        //System.out.println(to[i]);
        word = word.concat(to[i]+"\n");
      //\  word += to[i] + "\n";
      }
    }
    return word;//String.join("\n", to);
  }


  public void addRecipient(String name)
  {
    for (int i=0; i < 2; i++)
    {
      if (to[i] == null)
      {
        to[i] = name;
        break;
      }
    }

  }
}

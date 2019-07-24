import java.util.*;

public class MobilePhone extends Phone
{
  private String[] inbox;

  public MobilePhone(int number)
  {
    super(number);
    inbox = new String[100]; // Just a default inbox size
  }

  public void sendSMS(String message, MobilePhone p)
  {
    int i=0; boolean added = true;
    while(added)
    {
      if (p.inbox[i] == null)
      {
        p.inbox[i] = message;
        added = false;
      }
    }
  }

  public String displaySMS()
  {
    String msg=""; int i = 0;
    while(inbox[i] != null)
    {
      msg = inbox[i] +"\n";
      i++;
    }
    return msg;
  }
}

import java.util.Scanner;

public class MyScanner {
  private Scanner sc;
  public MyScanner()
  {
    sc = new Scanner(System.in);
  }

  public int nextInt()
  {
    return Integer.parseInt(sc.nextLine());
  }

  public double nextDouble()
  {
    return Double.parseDouble(sc.nextLine());
  }

  public String nextLine()
  {
    return sc.nextLine();
  }

  public void close()
  {
      sc.close();
  }
  public boolean isNumeric(String word)
  {
    for(int i = 0; i < word.length(); i++)
    {
      if (i != 2 && i != 5) {
        if (!Character.isDigit(word.charAt(i)))
          return true;
      }
    }
    return false;
  }


  public String nextDate() throws DateFormatException
  {
      String date  = sc.nextLine();

      if (date.length() < 10)
        throw new DateFormatException(date + " too short");
      if (date.length() > 10)
        throw new DateFormatException(date + " too long");
      else if (date.length() == 10)
      {
          if (isNumeric(date))
              throw new DateFormatException(date + " should only contain numbers.");
      }
      else if (date.charAt(2) != '-' || date.charAt(5) != '-')
        throw new DateFormatException(date + " wrong position of hyphen.");
      return date;
  }
}

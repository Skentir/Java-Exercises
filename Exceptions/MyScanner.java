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

  public String nextDate()
  {
      String date  = sc.nextLine();

      if (date.length() < 10 || date.length > 10)
        throw new DateFormatException(date + " too short or too long.");
      else if (date.length() == 10)
      {
        for(int i = 0; i < date.length(); i++)
        {
          if (i != 2 && i != 5) {
            if (!Character.isDigit(date.charAt(i)))
              throw new DateFormatException(date + " should only contain letters.");
          }
        }
      }
      else if (date.charAt(2) != '-' || date.charAt(5) != '-')
        throw new DateFormatException(date + " wrong position of hyphen.");
      return date;
  }
}

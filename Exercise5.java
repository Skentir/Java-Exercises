import java.util.*;

public class Exercise5
{

  public void Display(Map directory) {
    Set keys = new HashSet<int>();
    keys = directory.keySet();
    for(int i : keys) {
      System.out.println(i);
    }
  }

  public static void main(String[] args)
  {
    Scanner sc = new Scanner(System.in);
    Contact[] name_list = new Contact[5];
    Map directory = new HashMap <int, Contact>();

    // Adding contacts
    String n, c; int num;
    for(int i=0; i<5; i++) {
      System.out.printf("Enter name of person %d", i);
      n = sc.nextLine();
      System.out.printf("\nEnter country");
      c = sc.nextLine();
      name_list[i] = new Contact(n,c);
      System.out.printf("Enter number of person %d", i);
      num = sc.nextInt();
      sc.nextLine();
      directory.put(num, name_list[i]);
    }
    // Edit contacts
    System.out.println("Which number would you like to view?");
    e5 = new Exercise5();
    e5.Display(directory);
  }

}

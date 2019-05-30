/*
Resources Used:
https://docs.oracle.com/javase/7/docs/api/java/lang/String.html
https://docs.oracle.com/javase/7/docs/api/java/text/SimpleDateFormat.html
*/

import java.util.*;
import java.text.SimpleDateFormat;

public class Homework2 {
  public static void main(String[] args) {
    boolean run = true;
    Date currDate = new Date();
    SimpleDateFormat fDate = new SimpleDateFormat ("dd MMM yyyy (E) 'at' hh:mm:ss a");
    Scanner user_input = new Scanner(System.in);

    do {

      System.out.println("Enter your Full Name in the ff. format <lastname>, <first name>, <middle name>:");
      String user_name = user_input.nextLine();
      int start = user_name.indexOf(',') + 1;
      int end = user_name.lastIndexOf(',');
      String first_name = user_name.substring(start,end);

      System.out.print("How much weekly allowance do you get," + first_name + "? ");
      double allowance = user_input.nextDouble();
      System.out.print("What is your daily transportation cost? ");
      double t_cost = user_input.nextDouble();

      double savings = (allowance/5 - t_cost) * 0.05;
      double spending = (allowance - t_cost * 5 - Math.ceil(savings) * 5)/5.0;

      System.out.printf("\nYour Daily Savings is\t\t\t Php %.3f\n", Math.ceil(savings));
      System.out.printf("Suggested Spending on Food is\t\t Php %.3f\n", spending * 0.75);
      System.out.printf("Sugges Spending on Cellphone Load is\t Php %.3f\n", spending * 0.25);
      System.out.println("Output Generated at " + fDate.format(currDate));

      System.out.print("\nNew Computation? ");
      user_input.nextLine();
      String sysquit = user_input.nextLine();
      run = sysquit.equalsIgnoreCase("Yes");
     
    } while(run);

    user_input.close();

  }
}

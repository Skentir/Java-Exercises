/*
Lab Manual Answers:
4
3
2
6
8
7
5
1
#4 ClassName.valueOf(double d)
#5 strVal.charAt(int index)
#6 strVal.substring(int index, int number of characters)
Determines the first occurance of the parameter given
#1 date1 = new MyDate () will be
date1.setDay(5)
date.setYear(2019)
#2 if (date1.isAfter(date2))
  System.out.print(true);
#3 bValue = MyDate.isLeap(nYear);
*/

import java.util.*;

public class Exercise2 {
  public static void main(String[] args) {
    Scanner user_input = new Scanner(System.in);
    System.out.print("Full name?");
    String fullname = user_input.nextLine();
    String firstname = fullname.substring(fullname.indexOf(',')+1);
    System.out.println("Hello " + firstname);
    user_input.close();
  }
}

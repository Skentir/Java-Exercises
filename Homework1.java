import java.util.*;

public class Homework1 {
  public static void main (String[] args){
    Scanner user_input = new Scanner(System.in);
    System.out.print("Enter Name: ");
    String name = user_input.nextLine();
    System.out.print("Enter Gender: ");
    char gender = user_input.next().charAt(0);
    System.out.print("Enter Age: ");
    int age = user_input.nextInt();
    System.out.println();

    if (gender == 'F' || gender == 'f') {
      System.out.println("Hi, Ms Nats. This is "+name+". She is "+age+" years old.");
    } else if (gender == 'M' || gender == 'm') {
      System.out.println("Hi, Ms Nats. This is "+name+". He is "+age+" years old.");
    } else
      System.out.println("Unknown Gender.");
  }
}

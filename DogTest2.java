import java.util.*;

public class DogTest2 {
  public static void main(String args[]) {
    /* Instantiate all necessary objects */
    Scanner user_input = new Scanner(System.in);
    Dog[] dog_list = new Dog[3];

    /* Populate Dog Array */
    int i = 0, age; String name;
    while (dog_list.length > i) {
      System.out.printf("Enter information of Dog %d : \n", i);
      System.out.print("Name: ");
      name = user_input.nextLine();
      System.out.print("Age: ");
      age = user_input.nextInt();
      /* Set name and age of Dog */
      dog_list.setName(name);
      dog_list.setAge(age);
      i++;
    }

    /* Display Dog Array */
  }
}

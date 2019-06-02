import java.util.*;

public class DogTest2 {

  public static void Increase(Dog dog_list[]) {
      /* Increase Age of Dogs */
    int i = 0;
    while (dog_list.length > i) {
      System.out.printf("Increasing Age of Dog %d ...\n", i+1);
      dog_list[i].setAge(dog_list[i].getAge()+1);
      i++;
    }
  }

  public static void Display(Dog dog_list[]) {
    /* Display Dog Array */
    int i = 0;
    while (dog_list.length > i) {
      System.out.println("Name: " + dog_list[i].getName());
      System.out.println("Age: " + dog_list[i].getAge());
      System.out.println("Gender: " + dog_list[i].getGender());
      i++;
    }
  }

  public static void main(String args[]) {
    /* Instantiate all necessary objects */
    Scanner user_input = new Scanner(System.in);
    Dog[] dog_list = new Dog[3];

    /* Populate Dog Array */
    int i = 0, age; String name, gender;
    while (dog_list.length > i) {
      System.out.printf("Enter information of Dog %d : \n", i+1);
      System.out.print("Name: ");
      name = user_input.nextLine();
      System.out.print("Age: ");
      age = user_input.nextInt();
      user_input.nextLine();
      System.out.print("Gender: ");
      gender = user_input.nextLine();
      /* Set name and age of Dog */
      dog_list[i] = new Dog(name, age, gender);
      i++;
    }
    System.out.println("You entered the ff:");
    Display(dog_list);
    System.out.println();
    Increase(dog_list);
    System.out.println("New data of dogs:");
    Display(dog_list);
  }

}

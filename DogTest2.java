import java.util.*;

public class DogTest2 {

  public static void Increase(Dog dog_list[]) {
      /* Increase Age of Dog 1 */
      System.out.printf("Increasing Age of Dog 1 ...\n");
      dog_list[0].setAge(dog_list[0].getAge()+1);
    System.out.println();
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
    System.out.println();
  }

  public static void Akita(Dog dog_list[]) {
      /* Change last dog's name to Akita */
    Dog last_dog = dog_list[dog_list.length-1];
    System.out.print(last_dog.getName()+" said ");
    last_dog.bark();
    System.out.println("Pet Owner said I'll call you My Akita.");
    last_dog.setName("My Akita");
    System.out.print(last_dog.getName()+" said ");
    last_dog.bark();
    System.out.println();
    System.out.println("New data of dogs:");
    Display(dog_list);
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
      dog_list[i] = new Dog(name, age);
      user_input.nextLine();
      System.out.print("Gender: ");
      gender = user_input.nextLine();
      dog_list[i] = new Dog(name, gender);
      /* Set name and age of Dog */
      dog_list[i] = new Dog(name, age, gender);
      i++;
    }

    System.out.println("\nYou entered the ff:");
    Display(dog_list);
    Increase(dog_list);
    Akita(dog_list);
  }

}

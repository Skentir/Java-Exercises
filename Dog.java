import java.util.*;

public class Dog {
  // Attributes
  private String name;
  private int age;
  private final String gender;

  // Constructor
  public Dog(String name, int age) {
    this.name = name;
    this.age = age;
    this.gender = "male";
  }

  public Dog(String name, String gender) {
    setName(name);
    this.gender = gender;
  }
  public Dog(String name, int age, String gender) {
    this.name = name;
    this.age = age;
    this.gender = gender;
  }
  // Methods
  public String getName() {
    return name;
  }
  public int getAge() {
    return age;
  }
  public String getGender() {
    return gender;
  }
  public void setName(String new_name) {
    name = new_name;
  }
  public void setAge(int new_age) {
    age = new_age;
  }
  public void bark() {
    System.out.println("Arf! Arf! Arf!");
  }
}

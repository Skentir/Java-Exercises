import java.util.*;

public class Dog {
  // Attributes
  private String name;
  private int age;
  private String gender;
  
  // Constructor
  public Dog(String name, int age, String gender) {
    setName(name);
    this.age = age;
    setGender(gender);
  }
  // Methods
  public void setName(String new_name) {
    name = new_name;
  }
  public String getName() {
    return name;
  }
  public void setGender(String new_gender) {
    gender = new_gender;
  }
  public String getGender() {
    return gender;
  }
  public void setAge(int new_age) {
    age = new_age;
  }
  public int getAge() {
    return age;
  }
}

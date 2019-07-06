public class Person {
  private final String name;
  private final String nationality;

  /**
   * Constructs the {@code Person} class.
   *
   * @param name the name of the guest
   * @param nationality the nationality of the guest
   */
  public Person(String name, String nationality)
  {
    this.name = name;
    this.nationality = nationality;
  }
  /**
    * Gets the name of the guest
    * @return a String value when called
    */
  public String showName()
  {
    return name;
  }
  /**
    * Gets the nationality of the guest
    * @return a String value when called
    */
  public String showNationality()
  {
    return nationality;
  }
}

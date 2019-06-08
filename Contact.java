public class Contact {
  private int number;
  private String name;
  private String country;

  public Contact(int number, String name, String country) {
    setNumber(number);
    setName(name);
    setCountry(country);
  }

  public void setNumber(int number) {
    this.number = number;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public String getNumber()
  {
    return number;
  }

  public String getName()
  {
    return name;
  }

  public String getCountry()
  {
    return country;
  }

}

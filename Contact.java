public class Contact {

  private String name;
  private String country;

  public Contact( String name, String country) {
    setName(name);
    setCountry(country);
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setCountry(String country) {
    this.country = country;
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

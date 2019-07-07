public class Employee {
  private final int id_num;
  private final String name;
  private int rating;
  private int position;
  public static final String[]  POSITIONS = new String[]
  {
    'Manager',
    'Recruiter',
    'Seller'
  };

  public Employee(int id, String name, int pos)
  {
    id_num = id;
    this.name = name;
    position = pos;
    rating = 0;
  }

  public int getID() {
    return id_num;
  }

  public String getName() {
    return name;
  }

  public String getPosition() {
    return POSITIONS[position];
  }

}

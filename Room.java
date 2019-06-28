public class Room {
private ArrayList <Person> lodgers;
private int lodgerMax;
private final int roomNumber;

public Room (int roomNumber, int lodgerMax) {
  this.roomNumber = roomNumber;
  this.lodgerMax = lodgerMax;
  this.lodgers = new ArrayList<Person>();
}

public void addToRoom (Person guest)
{
  lodgers.add(guest);
}

public boolean isFull ()
{
  if (lodgers.size() < lodgerMax)
    return false;
  else
    return true;
}

public void showGuests()
{
  Iterator i = lodgers.iterator();
  Person lodgers = null;
  int num = 1;
  while (i.hasNext())
  {
    System.out.println(showName+" , "+showNationality);
  }

}

}

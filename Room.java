import java.util.*;
import java.util.ArrayList;

public class Room {
private ArrayList <Person> lodgers;
private int lodgerMax;
private final int roomNumber;

public Room (int roomNumber, int lodgerMax) {
  this.roomNumber = roomNumber;
  this.lodgerMax = lodgerMax;
  this.lodgers = new ArrayList<>(lodgerMax);
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
  int num = 0;
  while (i.hasNext())
  {
    System.out.println(lodgers.get(num).showName() + " , " + lodgers.get(num).showNationality());
    num++;
  }

}

}

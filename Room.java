import java.util.*;
import java.util.ArrayList;

public class Room
{
  private ArrayList <Person> lodgers;
  private int lodgerMax;
  private final int roomNumber;

  public Room (int roomNumber, int lodgerMax) {
  this.roomNumber = roomNumber;
  this.lodgerMax = lodgerMax;
  this.lodgers = new ArrayList<>();
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

  public int showRoomNumber ()
  {
    return roomNumber;
  }

  public void showAssignedLodgers(Room room)
  {
    int num = 0;
    for (num = 0; num < lodgers.size(); num++)
    System.out.println(lodgers.get(num).showName() + " , " + lodgers.get(num).showNationality());
  }

}

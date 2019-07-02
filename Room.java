import java.util.*;
import java.util.ArrayList;

public class Room
{
  private ArrayList <Person> lodgers;
  private int lodgerMax;
  private final int roomNumber;
  /**
   * Constructs the {@code Room} class.
   *
   * @param roomNumber the unique identfication integer of a room
   * @param lodgerMax the maximum number of guests it can hold
   */
  public Room (int roomNumber, int lodgerMax) {
  this.roomNumber = roomNumber+1;
  this.lodgerMax = lodgerMax;
  this.lodgers = new ArrayList<>();
  }
  /**
    * Adds a guest to a room
    * @param guest one Person that will be assigned to the room
    */
  public void addToRoom (Person guest)
  {
    lodgers.add(guest);
  }
  /**
    * Checks if guest capacity has been reached
    * @param guest one Person that will be assigned to the room
    * @return a value when called
    */
  public boolean isFull ()
  {
    if (headCount() < lodgerMax)
      return false;
    else
      return true;
  }
  /**
    * Gets the number of guest/s that has been assigned to the room
    * @return an integer value when called
    */
  public int headCount()
  {
    return lodgers.size();
  }
  /**
    * Gets the unique identfication integer of the room
    * @return an integer value when called
    */
  public int showRoomNumber ()
  {
    return roomNumber;
  }
  /**
    * Checks if a specific guest has been assigned to the room and gets it
    * @param name the name of the guest
    * @return Person value
    */
  public Person guestIsHere(String name)
  {
    int i;
    for (i=0; i < lodgers.size(); i++) {
      if (lodgers.get(i).showName().equalsIgnoreCase(name))
        return lodgers.get(i);
    }
    return null;
  }
  /**
    * Removes a guest that has been assigned to the room
    * @param name a String name of a guest
    */
  public void removeGuest(String name)
  {
    if (guestIsHere(name) != null);
      lodgers.remove(guestIsHere(name));
  }
  /**
    * Prints the list of person/s in the room
    * @param room the room
    */
  public void showAssignedLodgers(Room room)
  {
    int num = 0;
    for (num = 0; num < lodgers.size(); num++)
      System.out.println(lodgers.get(num).showName() + " , " + lodgers.get(num).showNationality());
  }

}

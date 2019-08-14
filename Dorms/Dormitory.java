
import java.util.Iterator;
import java.util.ArrayList;
import java.util.*;


public class Dormitory {
  private String name;
  private Room[] roomList;
  private int roomMax;
  private int guestMax;
  /**
   * Constructs the {@code Dormitory} class. Default value for guests is six
   *
   * @param name the name of the dormitory
   * @param roomMax the maximum number of rooms it can hold
   */
  public Dormitory (String name, int roomMax)
  {
    this.name = name;
    this.roomMax = roomMax;
    this.roomList = new Room[roomMax];
    guestMax = 6;
  }
  /**
   * Constructs the {@code Dormitory} class.
   *
   * @param name the name of the dormitory
   * @param roomMax the maximum number of rooms it can hold
   * @param guestMax the maximum number of guests per room can hold
   */
  public Dormitory (String name,int roomMax,int guestMax)
  {
    this.name = name;
    this.roomMax = roomMax;
    this.roomList = new Room[roomMax];
    this.guestMax = guestMax;
  }
  /**
    * Adds a Person guest to a dormitory and assigns it to a room depending on the case.
    * @param guest a Person
    */
  public void addToDorm(Person guest)
  {
    int num = 0, lastnum; boolean running = true;

      while (num < roomMax &&  running)
      {
        /* Case 1: If no room exists make a new one */
        if (roomList[num] == null && num < roomMax) {
          roomList[num] = new Room(num, guestMax);
          roomList[num].addToRoom(guest);
          running = false;
        }
        /* Case 2: If room exists and previous guest left, add to the room */
        else if (roomList[num].headCount() == 0 && roomList != null)
        {
          roomList[num].addToRoom(guest);
          running = false;
        }
        /* Case 3: if room exists, not full, and not STC Dorm, add to the room */
        else if (roomList[num] != null && !(roomList[num].isFull()) && !(name.equalsIgnoreCase("STC Dorm")))
        {
          roomList[num].addToRoom(guest);
          running = false;
        }
          num++;
      }
  }
  /**
    * Gets the maximum capacity of rooms of the dormitory
    * @return an integer value
    */
    public int getRoomMax()
    {
      return roomMax;
    }
  /**
    * Gets the maximum capacity of guests per room in the dormitory
    * @return an integer value
    */
    public int getGuestMax()
    {
      return guestMax;
    }
  /**
    * Gets the name of the Dormitory
    * @return a String value
    */
    public String getName()
    {
      return name;
    }
  /**
    * Prints name of guests per room
    * @param i index of the room in roomList[]
    */
    public void showGuests(int i)
    {
      if (roomList[i] != null && roomList[i].headCount() != 0) {
        System.out.printf("Room %d\n", roomList[i].showRoomNumber());
        roomList[i].showAssignedLodgers(roomList[i]);
      }
    }
  /**
    * Finds a specific guest in the dormitory
    * @return the Room of the guest
    */
    private Room findGuest(String name)
    {
      int i;
      for (i=0; i < roomMax && roomList[i] != null; i++) {
        if (roomList[i].guestIsHere(name) != null)
          return roomList[i];
      }
      return null;
    }
  /**
    * Transfers a guest to another dormitory. It first gets the room of the guest
    * to be transferred and gets the Person data of the transferee and proceeds
    * to add it afterwards.
    * If
    * @param the Room of the guest
    */
    public void transferDorm(String name, Dormitory dormB)
    {
      Room roomOfGuest = findGuest(name);
      Person getGuest = roomOfGuest.guestIsHere(name);
      if (roomOfGuest != null || getGuest != null)
      {
        // System.out.printf("%s is in Room %d\n", name, roomOfGuest.showRoomNumber());
        roomOfGuest.removeGuest(name);
        // System.out.println("Guest has been removed!");

        boolean exit = true; int i=0;
        while (i < dormB.getRoomMax() && exit)
        {
          if(dormB.roomList[i] == null)
          {
            dormB.roomList[i] = new Room(i, dormB.getGuestMax());
            dormB.roomList[i].addToRoom(getGuest);
            // System.out.printf("Assigned to %s @ Room %d\n", dormB.getName(), i+1);
            exit = false;
          }
          i++;
        }
      }
    }
  /**
    * Transfers a guest to another room in another dorm. It first gets the room of
    * the guest to be transferred and the target person. It then gets the Person data
    * of the transferee and the target person. It proceeds to traverse through the
    * list of rooms of a dorm and finds the room where the target's room Number is the
    * same, then add it afterwards.
    *
    * @param name name of the transferree guest
    * @param target name of the person guest would like to live with
    * @param dormA the dormitory of the target
    */
    public void transferRoom(String name, String target, Dormitory dormA)
    {
      Room roomOfGuest = findGuest(name);
      Room roomOfTarget = dormA.findGuest(target);
      Person getGuest = roomOfGuest.guestIsHere(name);
      // System.out.printf("%s is in Room %d\n", name, roomOfGuest.showRoomNumber());
      roomOfGuest.removeGuest(name);
      // System.out.printf("%s transferring to %s Room %d\n",name,dormA.getName(),roomOfTarget.showRoomNumber());
      // System.out.println("Guest has been transferred!");

      boolean exit = true; int i = 0;
      while (i < dormA.getRoomMax() && exit)
      {
        if(dormA.roomList[i].showRoomNumber() == roomOfTarget.showRoomNumber())
        {
          dormA.roomList[i].addToRoom(getGuest);
        //  System.out.printf("Assigned to %s @ Room %d\n", dormA.getName(), i+1);
          exit = false;
        }
        i++;
      }

    }
  /**
    * Gets the number of rooms not full. It does this by subtracting maximum
    * room capacity to the number of rooms full.
    * @return an integer value when called
    */
    public int freeRooms()
    {
      int count = 0, i;
      for (i=0; i < roomMax && roomList[i] != null; i++)
      {
        if (roomList[i].isFull())
            count++;
      }
      return roomMax - count;
    }
  /**
    * Combines the room capacity and available rooms in one string
    * @return a String value
    */
    @Override
    public String toString()
    {
      return name+" - Max Rooms: "+roomMax+" "+ "\nAvailable Room/s: " + freeRooms();
    }
}

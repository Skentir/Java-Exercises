
import java.util.Iterator;
import java.util.ArrayList;
import java.util.*;


public class Dormitory {
  private String name;
  private Room[] roomList;
  private int roomMax;
  private int guestMax;

  public Dormitory (String name, int roomMax)
  {
    this.name = name;
    this.roomMax = roomMax;
    this.roomList = new Room[roomMax];
    guestMax = 6;
  }
  public Dormitory (String name,int roomMax,int guestMax)
  {
    this.name = name;
    this.roomMax = roomMax;
    this.roomList = new Room[roomMax];
    this.guestMax = guestMax;
  }

  public void addToDorm(Person guest)
  {
    int num = 0, lastnum; boolean running = true;

    while (num < roomMax &&  running)
    {
      // if no room exists make a new one
      System.out.printf("num %d ", num);
      if (roomList[num] == null && num < roomMax) {
      System.out.println("Enter 1 ");
        roomList[num] = new Room(num, guestMax);
        roomList[num].addToRoom(guest);
        running = false;
      }
        // if room exists and not full, add to the room
      else if (roomList[num] != null && !(roomList[num].isFull()))
      {
        System.out.println("Enter 2 ");
        roomList[num].addToRoom(guest);
        running = false;
      }
      // if room exists and full
      else if (roomList[num].isFull() && num != roomMax-1)
      {
        System.out.println("Enter 3 ");
        roomList[num+1] = new Room(num+1, guestMax); // if not, make next room
        roomList[num+1].addToRoom(guest);
        running = false;
      }

      else
        num++;
    }
  }

    public int getRoomMax()
    {
      return roomMax;
    }

    public int getGuestMax()
    {
      return guestMax;
    }

    public String getName()
    {
      return name;
    }

    public void showGuests(int i)
    {
      if (roomList[i] != null) {
        System.out.printf("Room %d\n", roomList[i].showRoomNumber());
        roomList[i].showAssignedLodgers(roomList[i]);
      }
    }

    private Room findGuest(String name)
    {
      int i;
      for (i=0; i < roomMax && roomList[i] != null; i++) {
        if (roomList[i].guestIsHere(name) != null)
          return roomList[i];
      }
      return null;
    }

    public void transferDorm(String name, Dormitory dormB)
    {
      Room roomOfGuest = findGuest(name);
      Person getGuest = roomOfGuest.guestIsHere(name);
      System.out.printf("%s is in Room %d\n", name, roomOfGuest.showRoomNumber());
      roomOfGuest.removeGuest(name);
      System.out.println("Guest has been removed!");

      boolean exit = true; int i=0;
      while (i < dormB.getRoomMax() && exit)
      {
        if(dormB.roomList[i] == null)
        {
          dormB.roomList[i] = new Room(i, dormB.getGuestMax());
          dormB.roomList[i].addToRoom(getGuest);
          System.out.printf("Assigned to %s @ Room %d\n", dormB.getName(), i+1);
          exit = false;
        }
        i++;
      }
    }

    public void transferRoom(String name, String target, Dormitory dormA)
    {
      Room roomOfGuest = findGuest(name);
      Room roomOfTarget = dormA.findGuest(target);
      Person getGuest = roomOfGuest.guestIsHere(name);
      System.out.printf("%s is in Room %d\n", name, roomOfGuest.showRoomNumber());
      roomOfGuest.removeGuest(name);
      System.out.printf("%s transferring to %s Room %d\n",name,dormA.getName(),roomOfTarget.showRoomNumber());
      System.out.println("Guest has been transferred!");

      boolean exit = true; int i = 0;
      while (i < dormA.getRoomMax() && exit)
      {
        if(dormA.roomList[i].showRoomNumber() == roomOfTarget.showRoomNumber())
        {
          dormA.roomList[i].addToRoom(getGuest);
          System.out.printf("Assigned to %s @ Room %d\n", dormA.getName(), i+1);
          exit = false;
        }
        i++;
      }

    }

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

    @Override
    public String toString()
    {
      return name+" - Max Rooms: "+roomMax+" "+ "\nAvailable Room/s: " + freeRooms();
    }
}

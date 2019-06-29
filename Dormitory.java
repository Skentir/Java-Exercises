
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
      if (roomList[num] == null && num < roomMax) {
      //  System.out.println("First if");
        roomList[num] = new Room(num, guestMax);
    //    System.out.println("Created a new room!");
        roomList[num].addToRoom(guest);
    //    System.out.println("No room yet! Created a new one.");
        running = false;
      }
      else if (roomList[num].isFull() && num != roomMax-1)
      {
        // if room exists, check if full
    //    System.out.println("Second if");
        roomList[num+1] = new Room(num+1, guestMax); // if not, make next room
        roomList[num+1].addToRoom(guest);
    //    System.out.println("Room is full! Created a new one.");
        running = false;
      }
      else { // if room exists and not full, add to the room
        roomList[num].addToRoom(guest);
    //    System.out.println("Assigned to an existing room");
        running = false;
      }
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

    public void showGuests(int i)
    {
      if (roomList[i] != null) {
        System.out.printf("Room %d\n", i+1);
        roomList[i].showAssignedLodgers(roomList[i]);
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

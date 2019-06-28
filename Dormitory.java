import java.util.*;
import java.util.Iterator;

public class Dormitory {
  private String name;
  private Room roomList = new ArrayList<Room>();
  private int roomMax;
  private int guestMax;

  public Dormitory (String name, int roomMax)
  {
    this.name = name;
    this.roomMax = roomMax;
    this.roomList = new ArrayList<Room>(roomMax);
    guestMax = 6;
  }
  public Dormitory (String name,int roomMax,int guestMax)
  {
    this.name = name;
    this.roomMax = roomMax;
    this.roomList = new ArrayList<Room>(roomMax);
    this.roomSize = roomSize;
  }

  public void addToDorm(Person guest)
  {
    Iterator i = roomList.iterator();
    Room roomList = null;
    int num = 1;
    while (i.hasNext())
    {
      if (roomList[i].isFull())
      {
        roomList[i].add(new Room(num, guestMax));
        num++;
        roomList[i].addToRoom(guest);
      }
      else
        roomList[i].addToRoom(guest);

    }

    public int getRoomMax()
    {
      return roomMax;
    }

    public int getGuestMax()
    {
      return guestMax;
    }

    public int freeRooms()
    {
      Iterator i = roomList.iterator();
      Room roomList = null;
      int count = 0;
      while (i.hasNext())
      {
        if (roomList[i].isFull())
            count++;
      }
      return roomMax - count;
    }
    @Override
    public String toString()
    {
      return name+" - "+roomMax+" "+ freeRooms();
    }
}

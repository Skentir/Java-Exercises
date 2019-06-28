
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
    int num;
    for (num=0; num < roomList.length; num++)
    {
      if (roomList[num-1].isFull() && num != roomList.length)
      {
        roomList[num].addToRoom(guest);
      } else
        roomList[num-1].addToRoom(guest);
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

    public int freeRooms()
    {
      int count = 0, i;
      for (i=0; i < roomMax; i++)
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

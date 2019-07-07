/**
 * @(#)Hotel.java
 *
 *
 * @author
 * @version 1.00 2019/7/5
 */

import java.util.*;

public class Hotel {

    private Room[] roomList;
    private final String name;

    public Hotel (String name)
    {
    	int i;
    	this.name = name;
    	for (i = 1; i <= 7; i++)
    		this.roomList[i-1] = new Room(i);
    }

    public Hotel (String name, int roomMax)
    {
    	int i;
    	this.name = name;
    //	if (roomMax <= 7 || roomMax >= 1)
  //  	{
    		roomList = new Room[roomMax];
    		for (i = 1; i <= roomMax; i++)
    			roomList[i-1] = new Room(i);
  //  	} else
  //  		System.out.println("Invalid number");
    }

    public boolean acceptGuest(Guest person, int num)
    {
    	int idx;
      if (isValidRoom(num))
    	{
        System.out.println("in loop 1 ");
        Room room = getRoom(num);
    		if (!(room.isFull()))
    		{
          System.out.println("in loop 2 ");
    			room.addToRoom(person);
    		return true;
    		} else
				return false;
    	} else
      System.out.println("in no loop ");
    		return false;
    }

    Room getRoom(int num)
    {
    	int i = 0;
   		for (i = 0; i < roomList.length; i++)
   		{
   			if(roomList[i].getRoomNum() == num)
   				{
            return roomList[i];
          }
   		}
   		return null;
    }

   	private boolean isValidRoom(int num)
   	{
   		int i = 0;
   		for (i = 0; i < roomList.length; i++)
   		{
   			if(roomList[i].getRoomNum() == num)
   				return true;
   		}
   		return false;
   	}

   	public void displayGuests(int num)
   	{
   		int i, idx;
   		if (isValidRoom(num))
   		{
   		  Room room = getRoom(num);
   			Guest[] people = room.getGuests();
   			for(i=0; i < people.length; i++)
   			{
				if (people[i] != null)
					people[i].toString();
   			}
   		} else
   			System.out.println("Invalid room number!");
   	}
}

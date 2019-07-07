/**
 * @(#)Room.java
 *
 *
 * @author
 * @version 1.00 2019/7/5
 */
import java.util.ArrayList;

public class Room {

    private final int roomNumber;
    private ArrayList<Guest> guestList;

    public Room(int num)
    {
    	roomNumber = num;
      guestList = new ArrayList<Guest>(2);
    }

    public void addToRoom(Guest person)
    {
    	int i;
    	guestList.add(person);
    }

    public Guest[] getGuests()
    {
    	return guestList.toArray(new Guest[2]);
    }

    public int getRoomNum()
    {
    	return roomNumber;
    }

    public boolean isFull()
    {
    	int i;
    	if (guestList.size() == 2)
    		return true;
    	else
    		return false;
    }

     public boolean isEmpty()
    {
    	int i;
    	if (guestList.size() > 0)
    		return false;
    	else
    		return true;
    }

    public String guestData()
    {
      System.out.println("guest size " + guestList.size());
      int i; String info = "";
      for (i=0; i < guestList.size(); i++)
      {
        if (guestList.get(i) != null) {
          info += guestList.get(i).toString();
        System.out.println(guestList.get(i).getName() + " - " + guestList.get(i).getNationality() + "\n");
      }
      else
      System.out.println("Wont print");
      }
      return info;
    }
}

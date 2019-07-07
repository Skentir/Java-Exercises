/**
 * @(#)Room.java
 *
 *
 * @author 
 * @version 1.00 2019/7/5
 */


public class Room {

    private final int roomNumber;  
    private Guest[] guestList = new Guest[2];
    
    public Room(int num)
    {
    	roomNumber = num;
    }
    
    public void addToRoom(Guest person)
    {
    	int i;
    	for (i=0; i < guestList.length; i++)
    	{
    		if (guestList[i] == null)
    			guestList[i] = person;
    	}
    }
    
    public Guest[] getGuests()
    {
    	return guestList;
    }
    
    public int getRoomNum()
    {
    	return roomNumber;
    }
    
    public boolean isFull()
    {
    	int i;
    	if (guestList[1] != null)
    		return true;
    	else
    		return false;
    }
    
     public boolean isEmpty()
    {
    	int i;
    	if (guestList[0] != null)
    		return false;
    	else
    		return true;
    }
}
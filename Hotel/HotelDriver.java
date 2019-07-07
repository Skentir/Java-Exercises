import javax.swing.*;

public class HotelDriver
{
	public static void main (String[] args)
	{
		String strHotel;
		int nRooms;
		
		HotelOpen dialog = new HotelOpen (null, true);
		
		strHotel = dialog.getHotelName ();
		nRooms = dialog.getRoomCount ();
		
		if (strHotel != null && nRooms != 0)
		{
			/* TO DO : Declare and instantiate the hotel object with name and number of rooms */
//			Hotel hotel = new Hotel (strHotel, nRooms);
			HotelGUI gui = new HotelGUI (strHotel, nRooms);
		
			
			HotelController controller;
			/* TO DO: instantiate the controller with gui object and the hotel object */
//			controller = new HotelController (gui, hotel);
		}
	}
}

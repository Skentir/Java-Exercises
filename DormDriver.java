import java.util.Iterator;
import java.util.ArrayList;
public class DormDriver
{
    public void display(Dormitory dorm)
	{
		/* display all the guests in the room */
    int i;
    for (i = 0; i < dorm.getRoomMax(); i++)
      dorm.showGuests(i);
	}

	public void displayDorms(Dormitory[] dorms)
	{
    int i;
		for (i = 0; i < dorms.length; i++)
		{
			/* display the name of the dorm, the total
			   number of rooms, and the number of rooms
			   that are not full yet */
      System.out.println();
			System.out.println(dorms[i].toString());

			/*
			   Display all the names and nationalities
			   of the guests in each room. Part of the
			   solution is to call the method display()
			   in DormDriver. Provide your code */

		   display(dorms[i]);
		}
    System.out.println();
	}


	public static void main(String[] args)
	{
		Dormitory[] dorms = new Dormitory[2];

		dorms[0] = new Dormitory("LS Dorm", 3);
		dorms[1] = new Dormitory("STC Dorm", 5, 4);

		ArrayList<Person> guests = new ArrayList<Person>();
		guests.add(new Person("Andrew", "Filipino"));
		guests.add(new Person("Miguel", "Filipino"));
		guests.add(new Person("Henry", "American"));
		guests.add(new Person("Ray", "Filipino"));
		guests.add(new Person("Bernie", "Filipino"));
		guests.add(new Person("Michael", "Singaporean"));
		guests.add(new Person("Victor", "Filipino"));
		guests.add(new Person("Dennis", "Filipino"));
		guests.add(new Person("Jaime", "Filipino"));
    guests.add(new Person("Trisha", "Filipino"));

    /* Have all Filipinos be in the same room, as
		   long as they fit.  Following first come, first
		   served, those who do not fit will be assigned
		   to the next room. Use the first dormitory for
		   the Filipinos.  For the other nationalities,
		   they will be assigned to the second dormitory in
		   separate rooms. Provide your code.
		*/

    int j; String country;
      for (j = 0; j < guests.size(); j++)
      {
        country = guests.get(j).showNationality();
        if (country.equalsIgnoreCase("Filipino"))
          dorms[0].addToDorm(guests.get(j));
        else
          dorms[1].addToDorm(guests.get(j));
      }

		/* Provide your code to call displayDorms() in
		   class DormDriver. */
       DormDriver driver = new DormDriver();
       driver.displayDorms(dorms);

		/* Provide code to transfer Ray to STC Dorm, and
			he wants to be assigned to a currently unoccupied
			room. */
      dorms[0].transferDorm("Ray", dorms[1]);


		/* Provide code to transfer Michael to the same room
		   as Miguel */
       dorms[1].transferRoom("Michael", "Miguel", dorms[0]);

    /* Additional Test Case: New Guest will go to Michael's empty room.
      Should not create a new room, but use old empty one.
    */
       guests.add(new Person("Yoda", "Alien"));
       dorms[1].addToDorm(guests.get(guests.size()-1));

		/* Provide your code to call displayDorms() in
		   class DormDriver. */
       driver.displayDorms(dorms);

		guests = null;
		dorms = null;
		System.gc();
  }
}

import java.ArrayList;

public abstract class Vehicle
{
private int capacity;
private double totalDistance;
private ArrayList<Passenger> passengers;

protected Vehicle(int capacity);
public boolean accept(Passenger passenger)
{
  if (this.CAPACITY > passengers.size())
  {
    passengers.add(passenger);
    return true;
  } else
    return false;
}

public void remove(Passenger passenger)
{
  passengers.remove(passenger);
}

public int getCount()
{
  return passengers.size();
}

public int getCapacity()
{
  return this.capacity;
}

public double getTotalDistance()
{
  return totalDistance;
}

public double travel()
{
  totalDistance++;
}

}

import java.util.ArrayList;

public abstract class Vehicle
{
    private int capacity;
    private double totalDistance;
    private ArrayList<Passenger> passengers;

    protected Vehicle(int capacity)
    {
        this.capacity = capacity;
        this.passengers = new ArrayList<>();
    }

    public boolean accept(Passenger passenger)
    {
        if (passengers.size() < this.capacity)
        {
            passengers.add(passenger);
            return true;
        }

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

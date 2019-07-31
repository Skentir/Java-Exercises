public class Jeep extends Vehicle
{
    public int CAPACITY = 20;

    public Jeep()
    {
        super(CAPACITY);
    }

    @Override
    public double computeFare(double kilometers)
    {
        double km = totalDistance - kilometers;
        if ( km > 4)
            return km + 28;
        else
            return km * 7;
    }
}

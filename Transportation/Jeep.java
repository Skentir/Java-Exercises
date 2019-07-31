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
        if (km > 4)
            return 7 + (km - 4);
        else
            return 7;
    }
}

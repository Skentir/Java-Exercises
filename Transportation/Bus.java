public class Bus extends Vehicle implements Public
{
    public static final int CAPACITY = 30;

    public Bus()
    {
        super(CAPACITY);
    }

    @Override
    public double computeFare(int kilometers)
    {
        return 30.0;
    }
}

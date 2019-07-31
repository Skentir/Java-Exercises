public class Passenger
{
    private final String name;
    private int distance;
    private Vehicle vehicle;

    public Passenger(String name)
    {
        this.name = name;
    }

    public boolean ride(Vehicle vehicle)
    {
        // prevent the passenger from riding two vehicles at once
        if (this.vehicle != null)
            return false;

        // attempt to ride the vehicle
        if (vehicle.accept(this)) {
            this.vehicle = vehicle;

            // get starting distance mark
            this.distance = vehicle.getTotalDistance();
            return true;
        }

        // failed to ride (it's full)
        return false;
    }

    public double leave()
    {
        double fare = 0.0;

        if (vehicle instanceof Public) {
            Public puv = (Public)vehicle;
            fare = puv.computeFare(distance);
        }

        vehicle = null;

        return fare;
    }
}

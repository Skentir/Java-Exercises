public class Janitor extends Employee
{
    private double hourlyRate;
    private double hoursWorked;

    public Janitor(String name, double hourlyRate)
    {
        super(name);
        this.hourlyRate = hourlyRate;
    }

    public double getHoursWorked()
    {
        return hoursWorked;
    }

    public void setHoursWorked(double hours)
    {
        hoursWorked = hours;
    }

    @Override
    public double getSalary()
    {
        return hourlyRate * getHoursWorked();
    }
}

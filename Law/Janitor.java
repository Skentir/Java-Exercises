public class Janitor extends Employee
{
    private double hourlyRate;

    public Janitor(double hourlyRate)
    {
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double getBaseSalary()
    {
        return hourlyRate * getHoursWorked();
    }
}

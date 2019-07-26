public class Lawyer extends Employee
{
    private double hourlyFee;

    public Janitor(double hourlyFee)
    {
        this.hourlyFee = hourlyFee;
    }

    @Override
    public double getBaseSalary()
    {
        return hourlyFee * getHoursWorked();
    }
}

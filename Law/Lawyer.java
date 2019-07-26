public class Lawyer extends Employee
{
    private double hourlyFee;

    public Janitor(double hourlyFee)
    {
        this.hourlyFee = hourlyFee;
    }

    @Override
    protected double computeBaseSalary()
    {
        return hourlyFee * getHoursWorked();
    }
}

public class Lawyer extends Employee
{
    private double hourlyFee;

    public Lawyer(String name, double hourlyFee)
    {
        super(name);
        this.hourlyFee = hourlyFee;
    }

    @Override
    protected double computeBaseSalary()
    {
        return hourlyFee * getHoursWorked();
    }
}

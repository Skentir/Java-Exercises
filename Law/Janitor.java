public class Janitor extends Employee
{
    private double hourlyRate;

    public Janitor(double hourlyRate)
    {
        this.hourlyRate = hourlyRate;
    }

    @Override
    protected double computeBaseSalary()
    {
        return hourlyRate * getHoursWorked();
    }
}

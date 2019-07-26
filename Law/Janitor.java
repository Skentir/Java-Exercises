public class Janitor extends Employee
{
    private double hourlyRate;

    public Janitor(String name, double hourlyRate)
    {
        super(name);
        this.hourlyRate = hourlyRate;
    }

    @Override
    protected double computeBaseSalary()
    {
        return hourlyRate * getHoursWorked();
    }
}

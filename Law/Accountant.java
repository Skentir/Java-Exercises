public class Accountant extends Employee
{
    private double salary;

    public Accountant(double salary)
    {
        this.salary = salary;
    }

    @Override
    protected double computeBaseSalary()
    {
        return salary;
    }
}

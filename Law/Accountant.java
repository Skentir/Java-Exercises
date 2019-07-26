public class Accountant extends Employee
{
    private double salary;

    public Accountant(double salary)
    {
        this.salary = salary;
    }

    @Override
    public double getBaseSalary()
    {
        return salary;
    }
}

public class Accountant extends Employee
{
    private double salary;

    public Accountant(String name, double salary)
    {
        super(name);
        this.salary = salary;
    }

    @Override
    public double getSalary()
    {
        return salary;
    }
}

public abstract class Employee
{
    private double hours;

    protected Employee() { }

    protected abstract double computeBaseSalary();

    public double computeSalary()
    {
        double salary = computeBaseSalary();
        return salary - computeTax(salary);
    }

    public double computeTax(double salary)
    {
        double temp = salary - 3200;
        if (temp > 0)
            return 0.05 * 3200 + 0.1 * temp;
        else
            return 0.05 * salary;
    }

    public double getHoursWorked()
    {
        return hours;
    }

    public void setHoursWorked(double hours)
    {
        this.hours = hours;
    }
}

public class Lawyer extends Employee
{
    private double hourlyFee;
    private double hoursWorked;

    public Lawyer(String name, double hourlyFee)
    {
        super(name);
        this.hourlyFee = hourlyFee;
    }

    public double getHoursWorked()
    {
        return hoursWorked;
    }

    public void setHoursWorked(double hours)
    {
    //    System.out.println(hours);
        hoursWorked = hours;
    }

    @Override
    public double getSalary()
    {
  //    System.out.println(getHoursWorked());
        return hourlyFee * getHoursWorked();
    }
}

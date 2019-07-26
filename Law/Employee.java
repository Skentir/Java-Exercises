public abstract class Employee
{
  private double hours;
    protected Employee() { }
    public abstract double getBaseSalary();
    public double getSalary()
    {
      if (this instanceof Accountant)
          this.getBaseSalary();
      else if (this instanceof Janitor)
          this.getBaseSalary();
      else if (this instanceof Lawyer)
          this.getBaseSalary()
      /* UM WHAT DO I CALL HERE? NOT SURE*/
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

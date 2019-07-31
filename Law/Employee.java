public abstract class Employee
{
    private final String name;

    protected Employee(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public abstract double getSalary();

    public double computeTax()
    {
      double salary = this.getSalary();
      double temp = salary - 3200;
       System.out.println("salary " + salary + "\ttemp" + temp + "\n");
      if (temp > 0)
        return 0.05 * 3200 + 0.1 * temp;
      else
        return 0.05 * salary;
    }
}

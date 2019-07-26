import java.util.ArrayList;

public class LawFirm
{
    private final String name;
    private ArrayList<Employee> employees;

    public LawFirm(String name)
    {
        this.name = name;
        this.employees = new ArrayList<>();
    }

    public void hire(Employee employee)
    {
        employees.add(employee);
    }

    public void fire(Employee employee)
    {
        employees.remove(employee);
    }

    public void createPayroll()
    {
        /* put the payroll generation code here */
      System.out.println("Name\tSalary\tNet Salary");
      for(int i = 0; i < employees.size(); i++)
      {
        System.out.printf("%s\t", employees.get(i).getName());
        System.out.printf("%.2f\t", employees.get(i).getSalary());
        System.out.printf("%.2f\n", employees.get(i).getSalary() - employees.get(i).computeTax());
      }
    }
}

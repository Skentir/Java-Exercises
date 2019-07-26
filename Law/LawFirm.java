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
    }
}

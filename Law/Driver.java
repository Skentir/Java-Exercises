import java.util.ArrayList;

public class Driver
{
    public static void main(String[] args)
    {
        LawFirm firm = new LawFirm("My Law Firm");
        private ArrayList<Employee> employee_list = new ArrayList<>();
        employee_list.add(new Accountant("Kirsten", 2000.0));
        employee_list.add(new Accountant("Nathan", 1800.0));
        employee_list.add(new Lawyer("Nick", 3120.0));
        employee_list.add(new Janitor("Marc", 1500.0));

        for (int i=0; i<employee_list.size(); i++)
          firm.hire(employee_list.get(i));
        firm.createPayroll();

        firm.fire(employee_list.get(3));
        firm.createPayroll();
    }
}

import java.util.ArrayList;

public class Driver
{
    public static void main(String[] args)
    {
        LawFirm firm = new LawFirm("My Law Firm");

        firm.hire(new Accountant("Kirsten", 2000.0));
        firm.hire(new Accountant("Nathan", 1800.0));
        firm.hire(new Lawyer("Nick", 3120.0));
        firm.hire(new Janitor("Marc", 1500.0));
        firm.createPayroll();
        
        firm.fire(new Janitor("Marc", 100.0));
        firm.createPayroll();
    }
}

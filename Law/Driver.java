import java.util.ArrayList;

public class Driver
{
    public static void main(String[] args)
    {
        LawFirm firm = new LawFirm("My Law Firm");

        firm.hire(new Accountant("Kirsten", 20000.0));
    }
}

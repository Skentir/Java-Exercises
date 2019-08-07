public class Driver
{
    public static void main(String[] args)
    {
        MyScanner scanner = new MyScanner();

        try
        {
            String name = scanner.nextLine();
            System.out.println("Enter birthdate (mm-dd-yyyy): ");
            String birthday = scanner.nextDate();
            System.out.println("Enter date today (mm-dd-yyyy): ");
            String today = scanner.nextDate();

            System.out.println("Name: " + name);
            System.out.println("Birthday: " + birthday);
            System.out.println("Today: " + today);
        }
        catch (DateFormatException e)
        {
            System.out.println(e.getMessage());
        }
        finally
        {
            System.out.println("Done");
        }
    }
}

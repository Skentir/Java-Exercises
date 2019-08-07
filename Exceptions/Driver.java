public class Driver
{
    public static void main(String[] args)
    {
        MyScanner scanner = new MyScanner();

        String name = null, birthday = null, today = null;

        try
        {
            System.out.println("Enter name: ");
            name = scanner.nextLine();
            System.out.println("Enter birthdate (mm-dd-yyyy): ");
            birthday = scanner.nextDate();
            System.out.println("Enter date today (mm-dd-yyyy): ");
            today = scanner.nextDate();
        }
        catch (DateFormatException e)
        {
            System.out.println(e.getMessage());
        }
        finally
        {
            System.out.println("Correct entries:");
            System.out.println();
            System.out.println("\tName: " + name);
            System.out.println("\tBirthday: " + birthday);
            System.out.println("\tToday: " + today);
            System.out.println("Done");
        }
    }
}

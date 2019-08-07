public class Driver
{
    public static void main(String[] args)
    {
        MyScanner scanner = new MyScanner();

        String name = null, birthday = null, today = null;

        try
        {
            System.out.print("Enter name: ");
            name = scanner.nextLine();
            System.out.print("Enter birthdate (mm-dd-yyyy): ");
            birthday = scanner.nextDate();
            System.out.print("Enter date today (mm-dd-yyyy): ");
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
            if (name != null)
                System.out.println("\tName: " + name);
            if (birthday != null)
                System.out.println("\tBirthday: " + birthday);
            if (today != null)
                System.out.println("\tToday: " + today);
            System.out.println("Done");
        }
    }
}

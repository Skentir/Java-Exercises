public class DateFormatException extends Exception
{
    public DateFormatException()
    {
        super("invalid date input");
    }

    public DateFormatException(String message)
    {
        super(message);
    }
}

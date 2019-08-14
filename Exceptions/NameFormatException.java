public class NameFormatException extends Exception
{
  public NameFormatException()
  {
      super("invalid name input");
  }

  public NameFormatException(String message)
  {
      super(message);
  }
}

import java.io.IOException;

/**
 * This exception is designed to indicate that an opened file is empty.
 * 
 * @author Nathan Sprague
 */
public class FileFormatException extends IOException
{

    /**
     * Simply call the superclass constructor.
     * 
     * @param message
     *            The message to attach to this exception.
     */
    public FileFormatException(String message)
    {
        super(message);
    }

}

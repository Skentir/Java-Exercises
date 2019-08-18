import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * This class provides a terminal-based user interface for the document analysis
 * program.
 * 
 * @author Nathan Sprague and ...
 * @version
 * 
 */
public class DocumentUI
{
    /**
     * The main performs the appropriate document analysis based on the command
     * line arguments. The first argument is the filename of the document that
     * will be analyzed. The second argument is an optional filename indicating
     * where results should be stored. If no second argument is provided, the
     * results will be printed to the terminal. Appropriate error messages will
     * be printed if error conditions are encountered:
     * 
     * If an incorrect number of arguments is provided:
     *     "Usage: file_to_analyze [output_file]\n"
     * 
     * If the document to analyze cannot be opened:
     *     "Error opening: NAME_OF_FILE\n"
     * 
     * If the document can be opened, but contains no words: 
     *     "No words in file.\n"
     * 
     * If the save file cannot be opened: 
     *     "Error opening: NAME_OF_FILE\n"
     * 
     * @param args
     *            First argument is the filename of the document to analyze, second
     *            (optional) argument is the filename where results should be
     *            saved.
     */
    public static void main(String[] args)
    {
        String inFile = null;
        String outFile = null;
        if (args.length < 1 || args.length > 2)
        {
            System.out.println("Usage: file_to_analyze [output_file]");
            return;
        }

        inFile = args[0];
        if (args.length == 2)
            outFile = args[1];
        
        try
        {
            DocumentReporter reporter = new DocumentReporter(inFile);
            if (outFile != null)
                reporter.saveReport(outFile);
            else
                System.out.println(reporter.generateReport());
        }
        catch (FileFormatException e)
        {
            System.out.println("No words in file.");
        }
        catch (IOException e)
        {
            System.out.println("Error opening: " + inFile);
        }
    }

}

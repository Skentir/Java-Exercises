import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;

/**
 * This class generates reports describing document statistics.
 * 
 * @author Nathan Sprague and ...
 * @version
 * 
 */
public class DocumentReporter
{
 
    // INSTANCE VARIABLES NEEDED!
    private String filename;
    private DocumentStats stats;

    /**
     * Document reporter constructor.
     * 
     * @param documentFileName
     *            Name of the document to report on
     * @throws FileNotFoundExceptionn
     *             if the file cannot be opened
     * @throws FileFormatException
     *             If the file contains no words
     */
    public DocumentReporter(String documentFileName) throws FileNotFoundException,
            FileFormatException
    {
        filename = documentFileName;
        stats = new DocumentStats(filename);
    }

    /**
     * Returns a string containing a complete report. The format is:
     * 
     * "Statistics from FILE_NAME\n
     *  Number of words:     WORD_COUNT\n 
     *  Average word length: AVERAGE_LENGTH\n
     *  Longest word:        LONGEST_WORD\n
     *  Most frequent word:  MOST_FREQUENT_WORD"
     * 
     * (With no spaces at the beginnings of the lines.)
     * 
     * @return The report.
     */
    public String generateReport()
    {
       return String.format(
           "Statistics from %s\n" +
           "Number of words:     %d\n" +
           "Average word length: %f\n" +
           "Longest word:        %s\n" +
           "Most frequent word:  %s", filename, stats.numberOfWords(), stats.averageWordLength(), stats.longestWord(), stats.mostFrequentWord());
    }

    /**
     * Saves the report to a file. The format is the same as generateReport.
     * Creates or overwrites the indicated file.
     * 
     * @param saveFileName
     *            name of the file to create or overwrite.
     * @throws FileNotFoundException
     *             if the file cannot be created.
     */
    public void saveReport(String saveFileName) throws FileNotFoundException
    {
        try
        {
            BufferedWriter writer = new BufferedWriter(new FileWriter(saveFileName));
            writer.write(generateReport());
            writer.close();
        }
        catch (FileNotFoundException e)
        {
            throw e;
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
    }

}

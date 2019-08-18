import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 * This class reads text files and provides summary information: number of
 * words, average word length etc.
 * 
 * @author Nathan Sprague and ...
 * @version
 * 
 */
public class DocumentStats
{

    // INSTANCE VARIABLES NEEDED!
    private ArrayList<String> words;
    private ArrayList<Integer> frequencies;

    private int characterCount;
    private int wordCount;

    private int maxFrequency;
    private String mostFrequent;
    private String longest;

    /**
     * The constructor opens and stores the file as a collection of individual
     * words. The document will be split at any non-word character: punctuation,
     * whitespace etc.
     * 
     * @param fileName
     *            Name of the file to analyze
     * @throws FileNotFoundExceptionn
     *             if the file cannot be opened
     * @throws FileFormatException
     *             If the file contains no words
     */
    public DocumentStats(String fileName) throws FileFormatException, FileNotFoundException
    {
        // UNFINISHED!
        
        // I suggest that you use the split method of the String class to divide the
        // document into words.  You can use "\\W+" as the delimiter.
        
        // You need to handle documents with no words as a special case. 
    
        words = new ArrayList<>();
        frequencies = new ArrayList<>();
        
        FileInputStream fileIS = null;
        InputStreamReader isReader = null;
        BufferedReader reader = null;
        try
        {
            fileIS = new FileInputStream(fileName);
            isReader = new InputStreamReader(fileIS);
            reader = new BufferedReader(isReader);

            String line;
            String[] tokens;
            while ((line = reader.readLine()) != null)
            {
                tokens = line.split("\\W+");
                for (String token : tokens)
                {
                    if (token.length() == 0)
                        continue;

                    int index = words.indexOf(token.toLowerCase());
                    if (longest == null || token.length() > longest.length())
                        longest = token.toLowerCase();
                    
                    wordCount++;
                    characterCount += token.length();

                    int frequency = 1;
                    if (index != -1)
                    {
                        frequency = frequencies.get(index) + 1;
                        frequencies.set(index, frequency);
                    }
                    else
                    {
                        words.add(token.toLowerCase());
                        frequencies.add(1);
                    }

                    if (maxFrequency == 0 || frequency > maxFrequency)
                    {
                        mostFrequent = token.toLowerCase();
                        maxFrequency = frequency;
                    }
                }
            }

            reader.close();
            isReader.close();
            fileIS.close();

            if (words.size() == 0)
                throw new FileFormatException("No words in file.");
        }
        catch (FileFormatException e)
        {
            throw e;
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

    /**
     * Return the number of words in the document.
     * 
     * @return the number of words
     */
    public int numberOfWords()
    {
        // UNFINISHED!
        return wordCount;
    }

    /**
     * Return the total number of non-whitespace, non-punctuation characters.
     * 
     * @return the number of characters
     */
    public int numberOfCharacters()
    {
        // UNFINISHED!
        return characterCount;
    }

    /**
     * Returns the longest word in the document.
     * 
     * @return the longest word
     */
    public String longestWord()
    {
        // UNFINISHED!
        return longest;
    }

    /**
     * Returns the average word length in the document.
     * 
     * @return average word length
     */
    public double averageWordLength()
    {
        return (double) characterCount / wordCount;
    }

    /**
     * Counts the occurrences of a particular word. This method is NOT case
     * sensitive.
     * 
     * @param word
     *            the word to be counted
     * @return the number of occurrences
     */
    public int countWord(String word)
    {
        int i = words.indexOf(word);
        if (i == -1)
            return 0;
        else
            return frequencies.get(i);
    }

    /**
     * Returns the word that occurs most frequently in the document. (Note that
     * this method may take a long time to run for large documents.)
     * 
     * @return the most frequent word.
     */
    public String mostFrequentWord()
    {
        // UNFINISHED!
        return mostFrequent;
    }
}

import java.util.*;
import java.util.Map.Entry;

public class exercise2
{

  public static void analyze(String input)
  {
    Map<Character, Integer> freq = new LinkedHashMap<Character,Integer>();
    char[] arr = input.toUpperCase().toCharArray();

    for (char c: arr)
    {
      Integer ctr = 0;

      if (c != ' ' && Character.isLetter(c))
      {
        if (freq.containsKey(c))
        {
          ctr = freq.get(c);
          ctr++;
        } else
          ctr = 1;
        freq.put(c, ctr);
      }
    }

    System.out.println(freq);
  }

  public static void countSwaps(int length, int[] carriageNumbers)
  {
    /* Get a copy of sorted version 1 .. length */
    int[] copy = carriageNumbers;
    System.out.println("Copy");
    for (int m: copy)
      System.out.print(m+",");
    System.out.println();

    Arrays.sort(carriageNumbers);
    System.out.println("Sorted");
    int i,j,temp, count = 0;
    for (int k: carriageNumbers)
      System.out.print(k+",");
    System.out.println();

    for (i=1; i <= length; i++)
    {
  //    System.out.println(i + "," + length);
      if (carriageNumbers[i-1] != i)
      {
  //      System.out.println("num " + carriageNumbers[i-1] + " , " + i);
         temp = carriageNumbers[i-1];
         carriageNumbers[i-1] = i;
         carriageNumbers[carriageNumbers[i-1]-1] = temp;
         count++;
      }

    }
      System.out.println("Count " + count);

  }

  public static void main(String args[])
  {
    analyze("Count me 1 2 3 4 5! Wow! I love ALGOCOM!");
    int[] D = new int[]{1,2,4,3};
    countSwaps(4, D);
  }
}

import java.util.*;
import java.util.Map.Entry;
public class exercise2
{

  public static void analyze(String input)
  {
    Map<Character, Integer> freq = new HashMap<Character,Integer>();
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
    Character[] charactersFound = freq.keySet().toArray(new Character[0]);

   System.out.println("Letters\tCount");
   for(int k = 0; k < charactersFound.length; k++)
   {
       char character = charactersFound[k];
       System.out.println(character+
               "\t"+
               //get the count for the character
               freq.get(character));
   }

  /*
  for (Entry<Character, Integer> entry : freq.entrySet()) {
      System.out.println(entry.getKey() + " : " + entry.getValue());*/


    /*
    Character[] uniq = map.keySet().toArray(new Character[0]);

    Collections.sort(ranking, new Comparator<Business>()
    {
              public int compare(Business i1, Business i2) {
                    return i2.getRating() - i1.getRating();
                }
    }); */
    /*
    char[] uniq = new char[input.length()];
    int[] count = new int[input.length()];

    int i, m = 0;
    for (char c:arr)
    {
          i = input.toUpperCase().indexOf(c);
          count[i] = 0;

          if (c != ' ' && Character.isLetter(c))
          {
            uniq[i] = c;
            for (int k = i; k < input.length(); k++)
            {
              if (arr[k] == c)
              {
                arr[k] = ' ';
                count[i]++;
              }
            }

      //      System.out.println(uniq[i] + " "  + count[i]);
          }
    }

    int high;
    for (m ; m < input.length(); m++)
    {
      if (arr[m] != ' ' && Character.isLetter(arr[m]))
      {
        for (i = m+1; i < input.length()-1; i++)
        {
          if(count[m] < count[i])
            uniq[m] = arr[i];
          else if (count[m] == count[i])
        }

      }
    }

    */

  }
  public static void main(String args[])
  {
    analyze("Count me 1 2 3 4 5! Wow! I love ALGOCOM!");
  }
}

/* SISON, DANIELLE KIRSTEN T. S16 ALGCM*/
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

    Set<Map.Entry<Character, Integer>> freqSet = freq.entrySet();
    List<Map.Entry<Character, Integer>> freqList =
      new ArrayList<Map.Entry<Character, Integer>>(freqSet);

    Collections.sort(freqList,
      new Comparator<Map.Entry<Character, Integer>>()
      {
      @Override
      public int compare(Entry<Character, Integer> key1,
          Entry<Character, Integer> key2)
          {
            if (key1.getValue() == key2.getValue())
              return key1.getKey() - key2.getKey();
            else
              return key2.getValue() - key1.getValue();
          }
      });

      freq.clear();

      for(Map.Entry<Character, Integer> newFreq : freqList)
         freq.put(newFreq.getKey(), newFreq.getValue());

      for(Map.Entry<Character, Integer> newFreq : freqList)
        System.out.println(newFreq.getKey()+ " " + newFreq.getValue());
  }

  public static void countSwaps(int length, int[] carriageNumbers)
  {

    int i,j,temp, count = 0;

    for (i=0; i < length-1; i++)
    {
      for (j=0; j < length-i-1; j++)
      {
        if (carriageNumbers[j] > carriageNumbers[j+1])
        {
         temp = carriageNumbers[j];
         carriageNumbers[j] = carriageNumbers[j+1];
         carriageNumbers[j+1] = temp;
         count++;
        }
      }
    }

    System.out.println("Count " + count);
  }

  public static void checkHarvest(int numVillages, int costToFeed, int[] harvests)
  {
    int total = numVillages * costToFeed;
    int totalHarvest = Arrays.stream(harvests).sum();

    if (totalHarvest > total)
      System.out.println("PARTY!");
    else if (totalHarvest == total)
      System.out.println("JUST ENOUGH FOR EVERYONE");
    else
      System.out.println("NOT ENOUGH FOOD");
  }

  public static void printCombination (int N, int k)
  {
    if(k > N)
    {
	System.out.println("Invalid input");
	return;
    }

    int pointers[] = new int[k];
    int[] elements = new int[N];
    int j;
    int r = 0;
    int i = 1;

    for (j=1; j <= N; j++)
      elements[j-1] = j;

    while(r >= 0)
    {

	if(i-1 <= (N + (r - k)))
        {
	   pointers[r] = i;

	 if(r == k-1)
         {
            for (j=0; j < k; j++)
                System.out.print(pointers[j] + " ");
            System.out.println();
	    i++;
	 }
	 else
         {
	    i = pointers[r]+1;
	    r++;
	  }
	 }
	else
        {
	 r--;
	 if(r >= 0)
	    i = pointers[r]+1;
	}
     }
  }
}

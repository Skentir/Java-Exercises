/*
 * Danielle Kirsten T. Sison
`* CSALGCM - S16
 */
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;

public class SolutionAlg {
  public static void assignTable(String[] input) {
    String[] L1 = input[0].split(" ");
    String[] L2 = input[1].split(" ");
    String[] L3 = input[2].split(" ");

    ArrayList<Integer> indices = new ArrayList<Integer>(L3.length);
    Integer[] team = new Integer[L2.length];
    Integer[] tables = new Integer[L3.length];

    /*  turn it into an int[] */
    for (int i = 0; i < team.length; i++)
        team[i] = Integer.parseInt(L2[i]);

    for (int i = 0; i < tables.length; i++)
    {
        tables[i] = Integer.parseInt(L3[i]);
        indices.add(i);
    }

    // sort everything by descending order
    Arrays.sort(team, Collections.reverseOrder());
    // keep track of the table indices when sorting
    indices.sort((a, b) -> Integer.compare(tables[b], tables[a]));
    Arrays.sort(tables, Collections.reverseOrder());

    ArrayList<ArrayList<Integer>> combo = new ArrayList<ArrayList<Integer>>();
    int M = Integer.parseInt(L1[0]), N = Integer.parseInt(L1[1]);

    int j = 0;
    for (int i = 0; i < M; i++)
    {
      ArrayList<Integer> possible = new ArrayList<Integer>();
        while (team[i] > 0) {
          int counter = 0; // counts the num of tables we've allocated to humans
          while (counter < N) { // traverse the tables
            int tablenum = indices.get(j) + 1;
            if (tables[j] > 0 && !possible.contains(tablenum)) {
              team[i]--;
              tables[j]--;
              possible.add(tablenum);
              j++; // move to the next table
              j %= N; // make sure table number is within range
              break; // quit na if you have allocated the person to a table
            }
            j++; // move to the next table (redundant)
            if (j >= N) // go back to the first table if lumagpas na
              j = 0;
            counter++;
          }

          if (counter == N) break; // give up giving the person a seat
        }
  //      System.out.println((i+1 )+": "+team[i] + " : " + possible.size());
        if (team[i] == 0)
          combo.add(possible);
    }

    if (combo.size() == M)
    {
      System.out.println(1);
      for (ArrayList<Integer> arr: combo)
      {
        for(Integer num: arr)
          System.out.print(num + " ");
        System.out.println();
      }
    }
    else
      System.out.println(0);
  }

  public static void shoemaker(int[] jobTime, int[] fine) {
    int[] ratio = new int[fine.length];
    ArrayList<Integer> indices = new ArrayList<Integer>(fine.length);
    for (int i = 0; i < fine.length; i++)
    {
      ratio[i] = fine[i]/jobTime[i];
      indices.add(i);
    }
    // sort ratio in ascending order
    indices.sort((a, b) -> Integer.compare(ratio[b], ratio[a]));
    Arrays.sort(ratio);

    for (int i = 0; i < ratio.length; i++)
      System.out.print(indices.get(i) + 1 + " ");

    System.out.println();
  }

  public static void design(int[] floors) {
    ArrayList<Integer> red = new ArrayList<Integer>();
    ArrayList<Integer> blue = new ArrayList<Integer>();

    // separate the reds from the blues
    for (int i = 0; i < floors.length; i++) {
      if (floors[i] > 0)
        red.add(floors[i]);
      else
        blue.add(Math.abs(floors[i]));
    }
    // sort them both in descending order
    red.sort(Collections.reverseOrder());
    blue.sort(Collections.reverseOrder());

    ArrayList<Integer> bigger = blue;
    ArrayList<Integer> smaller = red;
    ArrayList<Integer> building = new ArrayList<Integer>();
    // to indicate where to look
    boolean prevType = true;

    // you can only have 1 floor of a specific color
    if (red.isEmpty() || blue.isEmpty()) {
      System.out.println(1);
      return;
    }
    // prioritize depending on the list with the highest floor size
    if (red.get(0) > blue.get(0)) {
      bigger = red;
      smaller = blue;
    }
    // add the biggest of the two floor types in the building
    building.add(bigger.get(0));
    building.add(smaller.get(0));
    bigger.remove(0);
    smaller.remove(0);
    int counter = 2;
    // loop the two lists alternately
    while(true)
    {
      if (bigger.size() == 0 || smaller.size() == 0)
          break;

      if (prevType)
      {
        // remove floors bigger than the previous floor
        while (bigger.size() > 0) {
          if (building.get(building.size()-1) > bigger.get(0))
            break; // exit loop once smaller floor is found
          else
            bigger.remove(0);
        }

        if (bigger.size() > 0) {
          building.add(bigger.get(0));
          counter++;
          prevType = false;
        } else
          break;
      } else {
        // remove floors bigger than the previous floor
          while(smaller.size() > 0) {
            if (building.get(building.size()-1) > smaller.get(0))
              break; // exit loop once smaller floor is found
            else
              smaller.remove(0);
          }
          if (smaller.size() > 0) {
            building.add(smaller.get(0));
            counter++;
            prevType = true;
          } else
            break;
      }
    }
    System.out.println(counter);
  }
}

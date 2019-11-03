import java.util.*;

public class optimal {
  public static void main(String args[])
  {
    long start = System.nanoTime();
    /*
    exercise2 analyzer = new exercise2();
    analyzer.analyze("Count me 1 2 3 4 5! Wow! I love ALGOCOM!");

    exercise2 counter = new exercise2();
    int[] D = new int[]{9,8,7,6,5,4,3,2,1};
    counter.countSwaps(9, D);
    */
    /*
    exercise2 harvest = new exercise2();
    int[] A = new int[]{100,0,300,100,100};
    harvest.checkHarvest(5,500,A);
    int[] B = new int[]{1500,0,500,0,500};
    harvest.checkHarvest(5,500,B);
    int[] C = new int[]{1000,100,100,100,100};
    harvest.checkHarvest(5,200,C);
    */
    exercise2 combo = new exercise2();
    combo.printCombination(20,11);

    long end = System.nanoTime();
    System.out.println((end-start)/1000000 + " ms");
  }

}

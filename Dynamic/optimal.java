import java.util.*;

public class optimal {

  /*
  Cost[A,B] + Cost[C,C] + A * B * C
  Cost[A,A] + Cost[B,C] + A * B *C
  */
  public static void assignTable(String[] input)
  {
    int N = Integer.parseInt(input[0]) + 1; // N = 4 + 1
    //System.out.println("N is " + N);
    int i,j,k,l;

    //Store matrix dimensions
    int[] dim = new int[N]; // dimensions is 5
    for (i=0; i < N; i++) // 0 1 2 3
    {
      String[] dummy;
      if (i != N - 1)
        {
          dummy = input[i+1].split(" ");
          dim[i] = Integer.parseInt(dummy[1]);
        }
      else
        {
          dummy = input[i+1].split(" ");
          dim[i] = Integer.parseInt(dummy[1]);
          dim[i+1] = Integer.parseInt(dummy[2]);
        }

        System.out.println(dim[i]);
    }

    // Store the minimum cost
    int[][] values = new int[N][N];
    //Store the indices
    int[][] table = new int[N][N];

    for (i = 0; i < N; i++) {
			values[i][i] = 0;
      table[i][i] = 0;
		}



    int d, q;
    for (d = 2; d <= N; d++)
    {
      for (i = 1; i <= N - d + 1; i++)
      {
        j = i + d - 1;
        System.out.println("j is " + j);
        values[i][j] = Integer.MAX_VALUE;
        //tempA = input[i].split(" ");

      for (k = i; k <= j - 1; k++)
      {
  //      System.out.println("compute " + values[i][k] + " + "  + values[k+1][j]+ " + " + dim[i-1]+ " * " + dim[k] + " * " + dim[j]);
        q = values[i][k] + values[k+1][j]+dim[i-1] * dim[k] * dim[j];
        System.out.println("q is " + q);
        if (q < values[i][j])
        {
          values[i][j] = q;
          table[i][j] = k;
        }
      }
    }
  }

  for (i = 0; i <= N; i++) {
    for (j= 0; j <= N; j++)
        System.out.print(" " + values[i][j] + " ");
      System.out.println();
  }
}

public static void countSwaps(int length, int[] carriageNumbers)
{
  int i,j,temp, count = 0;
  for (i=1; i <= length; i++)
  {
    if (carriageNumbers[i-1] != i)
    {
       temp = carriageNumbers[i-1];
       carriageNumbers[carriageNumbers[i-1]] = i;
       i = carriageNumbers[i-1];
       count++;
    }
    else
      continue;
  }
}

  public static void main(String[] args)
  {
      String[] A = new String[]
      { "3",
      "A 10 30",
      "B 30 5",
      "C 5 60" };
    // assignTable(A);

      String[] B = new String[]
      { "5",
      "A 4 10",
      "B 10 3",
      "C 3 12",
      "D 12 20",
      "E 20 7"};
    //  assignTable(B);

      String[] C = new String[]
      { "4",
      "A 5 4",
      "B 4 6",
      "C 6 2",
      "D 2 7",};
      assignTable(C);

      int[] D = {4,3,2,1};
      countSwaps(4,D);
  }

}

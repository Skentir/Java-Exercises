/*
Danielle Kirsten T. Sison
S16 - CSALGCM
*/
import java.util.*;

public class Solution {
  public static void assignTable(String[] input) {
    int num = Integer.parseInt(input[0]);
    String[] temp;
    int[] P = new int[num+1];

    for (int i=1; i <= num; i++)
    {
      temp = input[i].split(" ");
      if (i == 1) {
        P[0] = Integer.parseInt(temp[1]);
        P[1] = Integer.parseInt(temp[2]);
        continue;
      } else if (i == num)
        P[num] = Integer.parseInt(temp[2]);
      P[i-1] = Integer.parseInt(temp[1]);
    }

    int n = P.length;
    int[][] mems = new int[n][n];
    int[][] s = new int[n][n];

    for (int l = 2; l <= num; l++) {
      for (int i = 1; i <= num - l + 1; i++) {
        int j = i + l - 1;
        mems[i][j] = Integer.MAX_VALUE;
        for (int k = i; k <= j - 1; k++) {
          int cost = mems[i][k] + mems[k+1][j] + P[i-1] * P[k] * P[j];
          if (cost < mems[i][j]) {
            mems[i][j] = cost;
            s[i][j] = k;
          }
        }
      }
    }
    // recursively print the parenthesis
    printCombination(s, 1, num);
    System.out.println();
  }

  public static void printCombination(int s[][],int i,int j) {
    if (i == j) {
         int c = 64+i;
         System.out.print((char)c);
    } else {
        System.out.print("(");
        printCombination(s,i,s[i][j]);
        printCombination(s,s[i][j]+1,j);
        System.out.print(")");
    }
  }

  public static void partyBudget(String[] input) {
    String[] L1 = input[0].split(" ");
    int goal = Integer.parseInt(L1[0]), num = Integer.parseInt(L1[1]);

    int[] W = new int[num];
    int[] V = new int[num];
    int[][] mems1 = new int[num+1][goal+1];

    for (int i = 0; i < num; i++) {
      String[] L = input[i+1].split(" ");
      W[i] = Integer.parseInt(L[0]);
      V[i] = Integer.parseInt(L[1]);
    }

    for (int w = 0; w  <= goal; w++)
      mems1[0][w] = 0;

    for (int i = 1; i <= num; i++) {
      for (int j = 0; j <= goal; j++) {
        if (i == 0 || j == 0)
          mems1[i][j] = 0;
        else if (j >= W[i-1]) {
          if (V[i-1] + mems1[i-1][j-W[i-1]] >  mems1[i-1][j])
            mems1[i][j] = V[i-1] + mems1[i-1][j-W[i-1]];
          else
            mems1[i][j] = mems1[i-1][j];
        } else
            mems1[i][j] = mems1[i-1][j];
      }
    }

    int sum_val = mems1[num][goal];
    int sum_weight = 0;
    // backtrack
    while (num != 0) {
      if (mems1[num][goal] != mems1[num-1][goal]) {
        sum_weight += W[num-1];
        goal -= W[num-1];
      }
      num--;
    }
    System.out.println(sum_weight + " " + sum_val);
  }

  public static int[][] mems;

  public static int solve(int start, int end, int[] a, int n) {
    if (mems[start][end] != -1)
       return mems[start][end];

    int numPossible = 0;
    for (int i = 0; i < n; i++) {
        if (a[i] > start && a[i] < end)
            numPossible++;
    }
    if (numPossible == 0)
        return 0;

    int price = 0;
    int min = Integer.MAX_VALUE;
    for (int i = 0; i < n; i++) {
        if (a[i] <= start || a[i] >= end)
            continue;
        price = (end-start) + solve(start, a[i], a, n) + solve(a[i], end, a, n);
        min = Math.min(min, price);
    }

    mems[start][end] = min;
    return mems[start][end];
  }

  public static void cut(int l, int cuts, int[] places) {
    while (l != 0) {
    	mems = new int[l+2][l+2];

        for (int i = 0; i < l+1; i++) {
            for (int j = 0; j < l+1; j++)
                mems[i][j] = -1;
        }

    	int result = solve(0, l, places, cuts);
    	System.out.println("The minimum cutting is " + result + ".");
        break;
    }
  }

  public static void main(String[] args) {
    String[] sample1 = new String[] {
      "3",
      "A 10 30",
      "B 30 5",
      "C 5 60"
    };
    assignTable(sample1);
    String[] sample2 = new String[] {
      "5",
      "A 4 10",
      "B 10 3",
      "C 3 12",
      "D 12 20",
      "E 20 7"
    };
    assignTable(sample2);
    String[] sample3 = new String[] {
      "4",
      "A 30 5",
      "B 5 10",
      "C 10 10",
      "D 10 30"
    };
    assignTable(sample3);
    String[] sample4 = new String[] {
      "50 10",
      "12 3",
      "15 8",
      "16 9",
      "16 6",
      "10 2",
      "21 9",
      "18 4",
      "12 4",
      "17 8",
      "18 9"
    };
    partyBudget(sample4);
    String[] sample5 = new String[] {
      "50 10",
      "13 8",
      "19 10",
      "16 8",
      "12 9",
      "10 2",
      "12 8",
      "13 5",
      "15 5",
      "11 7",
      "16 2"
    };
    partyBudget(sample5);
    String[] sample6 = new String[] {
      "50 10",
      "13 4",
      "25 10",
      "5 5",
      "5 5",
      "5 6",
      "5 10",
      "15 1",
      "15 10",
      "7 7",
      "20 10"
    };
    partyBudget(sample6);
    int[] p1 = new int[] {25,50,75};
    cut(100,3,p1);
    int[] p2 = new int[] {4,5,7,8};
    cut(10,4,p2);
    int[] p3 = new int[] {5,10,15,20,25};
    cut(40,5,p3);
  }
}

/*
Danielle Kirsten T. Sison
S16 - CSALGCM
*/

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.*;

class Solution {

    public static class Building
    {
        int left;   //  left x-coordinate
        int right;  //  right x-coordinate
        int height;
    }

    public static void skyline(Building[] B)
    {
        List<int[]> sky = new ArrayList<int[]>();

        if (B.length == 0)
          System.out.println("No skyline.");
        List<int[]> points = partition(B, 0, B.length -1);

        for (int[] arr : points)
          sky.add(arr);

        for (int i = 0; i < sky.size(); i++)
        {
          int[] tmp = sky.get(i);
          for (int j = 0; j < tmp.length; j++)
              System.out.print(tmp[j] + " ");
        }

    }
    public static List<int[]> partition(Building[] B, int first, int second)
    {
      if (first == second)
      {
          List<int[]> points = new ArrayList<int[]>();
          points.add(new int[] {B[first].left, B[first].height});
          points.add(new int[] {B[first].right, 0});
          return points;
      }
      int mid = first + (second - first)/2;
      List<int[]> lower = partition(B, first, mid);
      List<int[]> upper = partition(B, mid+1, second);

      return mergePoints(lower, upper);
    }

    public static List<int[]> mergePoints(List<int[]> lower, List<int[]> upper)
    {
          List<int[]> points = new ArrayList<int[]>();
          int a = 0, b = 0, max1 = 0, max2 = 0;

          while(a < lower.size() || b < upper.size())
          {
              if (a == lower.size()) {
                points.add(upper.get(b++));
                continue;
              }
              if (b == upper.size()) {
                points.add(lower.get(a++));
                continue;
              }
              int pt = lower.get(a)[0];
              if (lower.get(a)[0] < upper.get(b)[0]) {
                max1 = lower.get(a)[1];
                pt = lower.get(a)[0];
                a++;
              }
              else if (lower.get(a)[0] > upper.get(b)[0]) {
                max2 = upper.get(b)[1];
                pt =  upper.get(b)[0];
                b++;
              } else {
                max1 = lower.get(a)[1];
                max2 = upper.get(b)[1];
                a++; b++;
              }

              int height = Math.max(max1, max2);

              if (points.size() == 0 || height != points.get(points.size()-1)[1]) {
				        points.add(new int[] {pt, height});
              }
			}
        return points;
    }

    public static void mergesort(int[] A)
    {
      if(A.length > 1) {
            int mid = A.length / 2;

            // Split left part
            int[] left = new int[mid];
            for(int i = 0; i < mid; i++) {
                left[i] = A[i];
            }

            // Split right part
            int[] right = new int[A.length - mid];
            for(int i = mid; i < A.length; i++) {
                right[i - mid] = A[i];
            }

            mergesort(left);
            mergesort(right);

            int i = 0;
            int j = 0;
            int k = 0;

            // Merge left and right arrays
            while(i < left.length && j < right.length) {
                if(left[i] < right[j]) {
                    A[k] = left[i];
                    i++;
                } else {
                    A[k] = right[j];
                    j++;
                }
                k++;
            }

            // Collect remaining elements
            while(i < left.length) {
                A[k] = left[i];
                i++; k++;
            }

            while(j < right.length) {
                A[k] = right[j];
                j++; k++;
            }
    }
  }
}

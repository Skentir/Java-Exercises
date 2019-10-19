/*
Danielle Kirsten T. Sison
S16 - CSALGCM
*/

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.*;
import java.text.DecimalFormat;

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

        if (B.length == 0) {
          System.out.println("No skyline.");
        } else {
        List<int[]> points = partition(B, 0, B.length -1);

        for (int[] arr : points)
          sky.add(arr);

            for (int i = 0; i < sky.size(); i++)  {
              int[] tmp = sky.get(i);
                for (int j = 0; j < tmp.length; j++)
                  System.out.print(tmp[j] + " ");
            }
        }
    }
    public static List<int[]> partition(Building[] B, int first, int second)
    {
      if (first == second) {
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

          while(a < lower.size() || b < upper.size()) {
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
  		int currN, first, second, mid, i;
  		for(currN = 1; currN < A.length-1; currN *= 2) {
  			for(first = 0; first < A.length-1; first += 2*currN) {
  				mid = Math.min(first + currN - 1, A.length-1);
  				second = Math.min(first + 2*currN - 1, A.length-1);
  				merge(A,first, mid, second);
  			}
  		}
      for (i = 0; i < A.length-1; i++)
        System.out.print(A[i]);
  	}

  	public static void merge(int[] A, int left, int mid, int right)
		{
  		int l = mid - left + 1;
  		int r = right - mid;

  		int[] leftArr = new int[l + 1];
  		int[] rightArr = new int[r + 1];

  		for(int i = 0; i < l; i++)
  			leftArr[i] = A[left+i];

  		for(int i = 0; i < r; i++)
  			rightArr[i] = A[mid+i+1];

  		int buff = Integer.MAX_VALUE;

  		leftArr[l] = buff;
  		rightArr[r] = buff;

  		int a = 0, b = 0;

  		for(int k = left; k <= right; k++) {
  			if(leftArr[a] <= rightArr[b]) {
  				A[k] = leftArr[a];
  				a++;
  			}
  			else {
  				A[k] = rightArr[b];
  				b++;
  			}
  		}
  	}

  public static class Pt
  {
    int x; //x-coordinate
    int y;//y-coordinate
  }


    public static void closestPair(Pt[] P)
		{
        DecimalFormat d = new DecimalFormat("0.000000");
        Pt[] xSort = clonePoints(P);
        Pt[] ySort = clonePoints(P);
        sortPts(xSort, xSort.length,'x');
        sortPts(ySort, ySort.length,'y');
        Pt[] pair = pairDivideConquer(xSort,ySort);
        int i1 = -1, i2 = -1;
        boolean isFound = false;
        for(int i = 0; i < P.length && !isFound ; i++) {
            if(P[i].x == pair[0].x && P[i].y == pair[0].y) {
                isFound = true;
                i1 = i;
            }
        }
        isFound = false;
        for(int i = 0; i < P.length && !isFound ; i++) {
            if(P[i].x == pair[1].x && P[i].y == pair[1].y) {
                isFound = true;
                i2 = i;
            }
        }
        System.out.println( i1 + " " + i2 + " " + d.format(distance(pair[0],pair[1])));
    }

    public static Pt[] pairDivideConquer(Pt[] xSort, Pt[] ySort)
		{
        if (xSort.length <= 3)
            return bruteForce(xSort);

        int mid = (int) Math.floor(xSort.length / 2.0);
        Pt[] left = getSublist(xSort,0,mid);
        Pt[] right = getSublist(xSort,mid,xSort.length-1);

        Pt[] temp = clonePoints(left);
        sortPts(temp,temp.length,'y');
        Pt[] pair = pairDivideConquer(left,temp);
        temp = clonePoints(right);
        sortPts(temp,temp.length,'y');
        Pt[] pairR = pairDivideConquer(right,temp);

        if (distance(pair[0], pair[1]) > distance(pairR[0], pairR[1]))
            pair = pairR;

        ArrayList<Pt> tempList = new ArrayList<>();
        int center = right[0].x;
        double minDist = distance(pair[0],pair[1]);
        double tempDist;

        for (int i = 0; i <  ySort.length; i++) {
            if( Math.abs(center - ySort[i].x) < minDist)
                tempList.add(ySort[i]);
        }

        for (int i = 0; i < tempList.size() - 1; i++)
				{
            Pt temp1 = tempList.get(i);
            for(int j = i + 1; j < tempList.size(); j++) {
                Pt temp2 = tempList.get(j);
                if( temp2.y - temp1.y < minDist) {
                    tempDist = distance(temp1,temp2);
                    if(tempDist < minDist) {
                        minDist = tempDist;
                        pair[0] = temp1;
                        pair[1] = temp2;
                    }
                }
            }
        }
        return pair;
    }

    public static Pt[] getSublist(Pt[] P, int first, int second)
		{
        Pt[] copy = new Pt[second-first+1];
        for(int i = 0; i < copy.length; i++)
            copy[i] = P[first+i];
        return copy;
    }

    public static Pt[] bruteForce(Pt[] P)
		{
        Pt[] closestPair = new Pt[2];
        double minDist = distance(P[0],P[1]);
        closestPair[0] = P[0];
        closestPair[1] = P[1];
        for(int i = 0; i < P.length - 1; i++) {
            for(int j = i+1; j < P.length; j++) {
                if(distance(P[i],P[j]) < minDist) {
                    minDist = distance(P[i],P[j]);
                    closestPair[0] = P[i];
                    closestPair[1] = P[j];
                }
            }
        }

        return closestPair;
    }

    public static double distance(Pt a, Pt b)
    {
        return Math.sqrt( Math.pow(a.x - b.x,2) + Math.pow(a.y-b.y,2));
    }

    public static Pt[] clonePoints(Pt[] P)
		{
        Pt[] copy = new Pt[P.length];
        for(int i = 0; i < P.length; i++) {
            Solution.Pt clone = new Solution.Pt();
            clone.x = P[i].x;
            clone.y = P[i].y;
            copy[i] = clone;
        }
        return copy;
    }

    public static void sortPts(Pt[] P, int N, char sortBy)
		{
        int currN, leftN, rightE, mid;
        for(currN = 1; currN < N-1; currN *= 2) {
            for(leftN = 0; leftN < N-1; leftN += 2*currN)
						{
                mid = Math.min(leftN + currN - 1, N-1);
                rightE = Math.min(leftN + 2*currN - 1, N-1);
                merge(P, leftN, mid, rightE, sortBy);
            }
        }
    }

    public static void merge(Pt[] P, int first, int mid, int last, char sortBy)
		{
        int leftN = mid - first + 1;
        int rightN = last - mid;

        Pt[] leftArr = new Pt[leftN + 1];
        Pt[] rightArr = new Pt[rightN+1];

        for(int i = 0; i < leftN; i++)
            leftArr[i] = P[first+i];

        for(int i = 0; i < rightN; i++)
            rightArr[i] = P[mid+i+1];

        Solution.Pt[] buff = new Solution.Pt[2];
        buff[0] = new Solution.Pt();
        buff[0].x = Integer.MAX_VALUE;
        buff[0].y = Integer.MAX_VALUE;
        buff[1] = new Solution.Pt();
        buff[1].x = Integer.MAX_VALUE;
        buff[1].y = Integer.MAX_VALUE;

        leftArr[leftN] = buff[0];
        rightArr[rightN] = buff[1];

        int leftI = 0, rightI = 0;
        if(sortBy == 'x' || sortBy == 'Y') {
            for(int k = first; k <= last; k++) {
                if(leftArr[leftI].x <= rightArr[rightI].x) {
                    P[k] = leftArr[leftI];
                    leftI++;
                }
                else{
                    P[k] = rightArr[rightI];
                    rightI++;
                }
            }
        }
        else if(sortBy == 'y' || sortBy == 'Y') {
            for(int k = first; k <= last; k++) {
                if(leftArr[leftI].y <= rightArr[rightI].y) {
                    P[k] = leftArr[leftI];
                    leftI++;
                }
                else {
                    P[k] = rightArr[rightI];
                    rightI++;
                }
            }
        }
    }
}

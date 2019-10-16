import java.util.HashMap;

class Solution {
    public class Building
    {
        int left;   //  left x-coordinate
        int right;  //  right x-coordinate
        int height;
    }

    public static void Skyline(Building[] B)
    {
        HashMap<Integer, Integer> sky = new HashMap<Integer, Integer>();
        if (B.length == 0)
          System.out.println('No skyline.');
        HashMap<Integer, Integer> points = partition(B, 0, B.length -1);
        for (<Integer,Integer> p: points)
          sky.put(p);
    }
    public static void partition(Building[], int first, int second)
    {
      
    }
}

public class MainClass
{
  public static void main(String[] args)
  {
    Solution sol = new Solution();
    Solution.Building inner = sol.new Building();
    Solution.Building[] buildings = new Solution.Building[2];
    Solution.Building a = sol.new Building();
    a.left = 1;
    a.right = 5;
    a.height = 11;
    Solution.Building b = sol.new Building();
    b.left = 1;
    b.right = 5;
    b.height = 11;
    buildings[0] = a;
    buildings[1] = b;
  }
}

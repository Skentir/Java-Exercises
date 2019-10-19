public class Main {
    private static Solution.Building[] makeBuildings(int... values) {
        if (values == null)
            throw new IllegalArgumentException("values is null");
        if (values.length % 3 != 0)
            throw new IllegalArgumentException("values should have length divisible by 3");

        Solution.Building[] buildings = new Solution.Building[values.length / 3];
        for (int i = 0; i < buildings.length; i++) {
            Solution.Building b = new Solution.Building();
            b.left = values[i * 3];
            b.height = values[i * 3 + 1];
            b.right = values[i * 3 + 2];
            buildings[i] = b;
        }
        return buildings;
    }

    public static void main(String[] args) {
      /*
        Solution.skyline(makeBuildings(1, 3, 4, 2, 2, 6));
        System.out.println();
        Solution.skyline(makeBuildings(1, 4, 4, 8, 8, 12));
        System.out.println();
        Solution.skyline(makeBuildings(1, 7, 5, 3, 4, 8, 4, 10, 10, 7, 3, 13));
        System.out.println();
        Solution.skyline(makeBuildings(1, 11, 5, 2, 6, 7, 3, 13, 9, 12, 7, 16, 14, 3, 25, 19, 18, 22, 23, 13, 29, 24, 4, 28));
        System.out.println();
        Solution.skyline(makeBuildings(1, 10, 2, 3, 6, 6, 4, 8, 12, 5, 10, 8, 7, 9, 10, 11, 5, 14));
        System.out.println();
        Solution.skyline(makeBuildings(1, 6, 6, 2, 4, 3, 4, 9, 5, 7, 10, 10, 8, 5, 9, 9, 11, 10));
        System.out.println();
        Solution.skyline(makeBuildings(1, 10, 5, 5, 10, 8));
        System.out.println();
        Solution.skyline(makeBuildings(1, 10, 5, 5, 12, 8));
        System.out.println();
        */
        Solution.mergesort(new int[] { 7, 8, 9, 4, 3, 2, 1 });
        System.out.println();
        Solution.mergesort(new int[] { 9, 8, 7, 6, 2, 2, 0 });
        System.out.println();
        Solution.mergesort(new int[] { 5, 5, 5, 4, 4, 4, 3 });
    }
}

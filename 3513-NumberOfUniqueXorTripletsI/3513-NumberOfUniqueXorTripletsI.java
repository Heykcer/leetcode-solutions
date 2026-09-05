// Last updated: 9/5/2026, 12:00:57 PM
class Solution {
    public int uniqueXorTriplets(int[] nums) {
        final int n = nums.length;
    if (n < 3)
      return n;
    final int x = (int) (Math.log(n) / Math.log(2));
    return 1 << (x + 1);
    }
}
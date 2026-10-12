// Last updated: 10/12/2026, 9:02:39 PM
1class Solution {
2    public int sumOfSquares(int[] nums) {
3         final int n = nums.length;
4    int ans = 0;
5
6    for (int i = 0; i < n; ++i)
7      if (n % (i + 1) == 0)
8        ans += nums[i] * nums[i];
9
10    return ans;
11    }
12}
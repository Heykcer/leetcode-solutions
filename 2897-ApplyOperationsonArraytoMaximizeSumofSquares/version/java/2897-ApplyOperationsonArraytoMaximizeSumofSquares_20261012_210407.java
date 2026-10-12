// Last updated: 10/12/2026, 9:04:07 PM
1class Solution {
2    public int maxSum(List<Integer> nums, int k) {
3        final int MOD = 1_000_000_007;
4    final int MAX_BIT = 30;
5    int ans = 0;
6    // minIndices[i] := the minimum index in `optimalNums` that the i-th bit
7    // should be moved to
8    int[] minIndices = new int[MAX_BIT];
9    int[] optimalNums = new int[nums.size()];
10
11    for (final int num : nums)
12      for (int i = 0; i < MAX_BIT; i++)
13        if ((num >> i & 1) == 1)
14          optimalNums[minIndices[i]++] |= 1 << i;
15
16    for (int i = 0; i < k; i++)
17      ans = (int) ((ans + (long) optimalNums[i] * optimalNums[i]) % MOD);
18
19    return ans;
20        
21    }
22}
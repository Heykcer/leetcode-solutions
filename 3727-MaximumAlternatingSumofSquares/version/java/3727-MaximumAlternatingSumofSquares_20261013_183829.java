// Last updated: 10/13/2026, 6:38:29 PM
1class Solution {
2    public long maxAlternatingSum(int[] nums) {
3          int n = nums.length;
4        for (int i = 0; i < n; ++i) {
5            nums[i] *= nums[i];
6        }
7        Arrays.sort(nums);
8        long ans = 0;
9        int m = n >> 1;
10        for (int i = 0; i < n; ++i) {
11            ans += i < m ? -nums[i] : nums[i];
12        }
13        return ans;
14        
15    }
16}
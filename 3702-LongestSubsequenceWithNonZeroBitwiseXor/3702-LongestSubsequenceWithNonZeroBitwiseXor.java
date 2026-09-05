// Last updated: 9/5/2026, 11:59:54 AM
class Solution {
    public int longestSubsequence(int[] nums) {
        int n = nums.length;
        int totalXor = 0;
        boolean allZeros = true;
        
        for (int num : nums) {
            totalXor ^= num;
            if (num != 0) {
                allZeros = false;
            }
        }
        
        if (allZeros) return 0;
        if (totalXor != 0) return n;
        return n - 1;
    }
}

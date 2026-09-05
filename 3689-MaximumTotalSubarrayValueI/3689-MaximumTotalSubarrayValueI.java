// Last updated: 9/5/2026, 12:00:03 PM
class Solution {
    public long maxTotalValue(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int min = nums[0];
        int max = nums[0];
        
        for (int num : nums) {
            if (num < min) min = num;
            if (num > max) max = num;
        }
        
        // Using long to handle large result values safely
        return (long) (max - min) * k;
        
    }
}
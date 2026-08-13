// Last updated: 8/13/2026, 10:14:39 PM
class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        
        int n = nums.length;
        int left = 0, right = n - 1;
        
        while (left <= right) {
            int mid = (left + right) >> 1;
            
            if (nums[mid] == target) {
                return mid;
            }
            
            // Check if the left half is normally sorted
            if (nums[left] <= nums[mid]) {
                // Target lies within the sorted left half
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } 
            // Otherwise, the right half must be normally sorted
            else {
                // Target lies within the sorted right half
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        
        return -1;
    }
}
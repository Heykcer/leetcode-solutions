// Last updated: 9/5/2026, 12:02:46 PM
class Solution {
    public int[] leftRightDifference(int[] nums) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        
        int leftSum = 0;
        int[] answer = new int[nums.length];
        
        for (int i = 0; i < nums.length; i++) {
            // totalSum now acts as rightSum after subtracting the current element
            totalSum -= nums[i]; 
            
            answer[i] = Math.abs(leftSum - totalSum);
            
            // Update leftSum for the next index
            leftSum += nums[i];
        }
        
        return answer;
    }
}
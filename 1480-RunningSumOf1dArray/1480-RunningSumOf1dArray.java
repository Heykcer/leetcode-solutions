// Last updated: 9/29/2026, 12:44:02 AM
class Solution {
    public int[] runningSum(int[] nums) {
        int ans[]=new int[nums.length];
        int sum=0;
        for(int i=0;i<nums.length;i++)
        {
         sum+=nums[i];
         ans[i]=sum;   
        }
        return ans;
        
    }
}
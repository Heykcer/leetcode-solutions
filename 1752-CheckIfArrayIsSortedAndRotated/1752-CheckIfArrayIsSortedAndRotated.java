// Last updated: 9/5/2026, 12:04:03 PM
class Solution {
    public boolean check(int[] nums) {
        int count=0;
        int n=nums.length;
        for(int i=0;i<n;i++)
        {
            if(nums[i]>nums[(i+1)%n])
            count++;
        }
        return count<=1;
    }
}
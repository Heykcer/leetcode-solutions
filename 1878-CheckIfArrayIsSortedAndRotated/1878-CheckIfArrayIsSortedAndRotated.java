// Last updated: 8/13/2026, 10:12:03 PM
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
// Last updated: 8/13/2026, 10:13:58 PM
class Solution {
    public int missingNumber(int[] nums) {
        int n=nums.length;
        int total=n*(n+1)/2;
        int sum=0;
        for(int num:nums)
        {
            sum+=num;
        }
        return total-sum;
    }
}
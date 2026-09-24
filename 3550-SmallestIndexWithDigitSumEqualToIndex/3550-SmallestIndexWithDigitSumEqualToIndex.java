// Last updated: 9/24/2026, 9:45:32 PM
class Solution {

    public int digitExtract(int n)
    {
        int sum=0;
        while(n!=0)
        {
            int d=n%10;
            sum=sum+d;
            n=n/10;
        }
        return sum;
    }
    public int smallestIndex(int[] nums) {
        for(int i=0;i<nums.length;i++)
        {
            if(i==digitExtract(nums[i]))
            return i;
        }
        return -1;
        
    }
}
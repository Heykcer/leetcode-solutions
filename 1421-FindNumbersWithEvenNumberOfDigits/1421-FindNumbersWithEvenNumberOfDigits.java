// Last updated: 8/13/2026, 10:12:45 PM
class Solution {
    public static int numberOfDigit(int n)
    {
        int c=0;
        
        while(n!=0)
        {
            int d=n%10;
            c++;
             n=n/10;
}
        return c;
    }
    public int findNumbers(int[] nums) {
        int n=nums.length;
        int a=0;
        for(int i=0;i<n;i++)
        {
            int c=numberOfDigit(nums[i]);
            if(c%2==0)
                a++;
}
        return a;
        
        
    }
}
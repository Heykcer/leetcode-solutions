// Last updated: 9/5/2026, 12:00:10 PM
class Solution {
    public int[] maxValue(int[] nums) {
        int n=nums.length;
        int ans[]=new int[n];
        int preMax[]=new int[n];
        preMax[0]=nums[0];
        for(int i=1;i<n;++i)
        {
            preMax[i]=Math.max(preMax[i-1],nums[i]);


        }
        int suffMin=1<<30;
        for(int i=n-1;i>=0;--i)
        {
            ans[i]=preMax[i]>suffMin?ans[i+1]:preMax[i];
            suffMin=Math.min(suffMin,nums[i]);
        }
        return ans;
        
    }
}
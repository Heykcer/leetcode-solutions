// Last updated: 8/13/2026, 10:13:46 PM
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int n=nums.length;
        int maxN=0;
        int one=0;
        for(int i=0;i<n;i++)
        {
            if(nums[i]==1)
            {
                one++;
            }
            else
            {
                one=0;
            }
            maxN=Math.max(maxN,one);
        }
        return maxN;
        
        
    }
}
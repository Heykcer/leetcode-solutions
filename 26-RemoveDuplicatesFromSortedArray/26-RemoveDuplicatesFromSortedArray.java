// Last updated: 8/13/2026, 10:14:45 PM
class Solution {
    public int removeDuplicates(int[] nums) {
        int k=1,i=0,j=1;
        while(j<nums.length)
        {
            if(nums[i]==nums[j])
            j++;
            else
            {
                nums[i+1]=nums[j];
                k++;
                j++;
                i++;
            }
        }
        return k;
        
        
    }
}
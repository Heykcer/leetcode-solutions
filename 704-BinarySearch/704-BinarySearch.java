// Last updated: 9/5/2026, 12:05:36 PM
class Solution {
    public int search(int[] nums, int target) {
        int l=0,r=nums.length-1;
        while(l<=r)
        {
            int mid=l+(r-l)/2;
            if(nums[mid]==target)
            return mid;
            else if(nums[mid]<target)
            {
                l=mid+1;
            }
            else{
                r=mid-1;
            }
        }
        return -1;
        
    }
}
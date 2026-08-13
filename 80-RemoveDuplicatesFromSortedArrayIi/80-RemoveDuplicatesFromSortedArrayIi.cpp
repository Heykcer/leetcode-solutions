// Last updated: 8/13/2026, 10:14:20 PM
class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        int n=nums.size();
        if(n<=1)
        return n;
        int write=2;
        for(int i=2;i<n;i++)
        {
            if(nums[i]!=nums[write-2])
            nums[write++]=nums[i];
        }
        return write;
        
    }
};
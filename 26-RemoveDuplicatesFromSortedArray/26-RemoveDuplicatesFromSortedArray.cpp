// Last updated: 8/13/2026, 10:14:51 PM
class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        int n=nums.size();
        if(n<=1)
        return n;
        int write=1;
        for(int read=1;read<n;read++)
        {
            if(nums[read]!=nums[read-1])
            {
            nums[write++]=nums[read];
            }
        }
        return write;
        
    }
};
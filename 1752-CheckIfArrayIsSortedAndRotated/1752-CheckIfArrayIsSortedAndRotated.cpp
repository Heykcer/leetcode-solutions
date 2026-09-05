// Last updated: 9/5/2026, 12:04:09 PM
class Solution {
public:
    bool check(vector<int>& nums) {
        int count=0;
        for(int i=0;i<nums.size();i++)
        {
            if(nums[i]>nums[(i+1)%nums.size()])
            count++;
        }
        return count<=1;
        
    }
};
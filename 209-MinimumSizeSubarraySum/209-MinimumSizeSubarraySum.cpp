// Last updated: 8/13/2026, 10:14:04 PM
#include <climits>
#include <bits/stdc++.h>
class Solution {
public:
    int minSubArrayLen(int target, vector<int>& nums) {
        int low=0,high=0,res=INT_MAX,sum=0;
        int n=nums.size();
        while(high<n)
        {
            sum=sum+nums[high];
            while(sum>=target)
            {
            int len=high-low+1;
            res=min(res,len);
            sum=sum-nums[low];
            low++;
            }
            high++;
        }

        return res == INT_MAX?0:res;
    }
};
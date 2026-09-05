// Last updated: 9/5/2026, 12:03:06 PM
class Solution {
public:
    vector<int> pivotArray(vector<int>& nums, int pivot) {
        vector<int> ans;
        ans.reserve(nums.size()); // Optimize memory allocation
        
        // Step 1: Elements < pivot
        for (int num : nums) {
            if (num < pivot) ans.push_back(num);
        }
        
        // Step 2: Elements == pivot
        for (int num : nums) {
            if (num == pivot) ans.push_back(num);
        }
        
        // Step 3: Elements > pivot
        for (int num : nums) {
            if (num > pivot) ans.push_back(num);
        }
        
        return ans;
    }
};
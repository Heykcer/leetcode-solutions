// Last updated: 8/13/2026, 10:11:13 PM
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
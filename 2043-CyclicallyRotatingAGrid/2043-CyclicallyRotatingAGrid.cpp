// Last updated: 8/13/2026, 10:11:39 PM
class Solution {
public:
    vector<vector<int>> rotateGrid(vector<vector<int>>& grid, int k) {
        int n = grid.size();
        int m = grid[0].size();
        int numLayers = min(n, m) / 2;

        for (int layer = 0; layer < numLayers; layer++) {
            vector<int> nums;
            int top = layer, left = layer;
            int bottom = n - 1 - layer, right = m - 1 - layer;

            // 1. Extract elements in anti-clockwise order
            // Top row
            for (int j = left; j < right; j++) nums.push_back(grid[top][j]);
            // Right column
            for (int i = top; i < bottom; i++) nums.push_back(grid[i][right]);
            // Bottom row
            for (int j = right; j > left; j--) nums.push_back(grid[bottom][j]);
            // Left column
            for (int i = bottom; i > top; i--) nums.push_back(grid[i][left]);

            int len = nums.size();
            int normalized_k = k % len;
            
            // 2. Rotate the vector
            // Use std::rotate to move elements. 
            // For anti-clockwise rotation, we move elements forward.
            rotate(nums.begin(), nums.begin() + normalized_k, nums.end());

            // 3. Put elements back into the grid
            int idx = 0;
            for (int j = left; j < right; j++) grid[top][j] = nums[idx++];
            for (int i = top; i < bottom; i++) grid[i][right] = nums[idx++];
            for (int j = right; j > left; j--) grid[bottom][j] = nums[idx++];
            for (int i = bottom; i > top; i--) grid[i][left] = nums[idx++];
        }
        
        return grid;
    }
};
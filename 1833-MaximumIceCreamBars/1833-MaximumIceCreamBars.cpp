// Last updated: 9/5/2026, 12:03:55 PM
class Solution {
public:
    int maxIceCream(vector<int>& costs, int coins) {
        sort(costs.begin(), costs.end());
        int n = costs.size();
        for (int i = 0; i < n; ++i) {
            if (coins < costs[i]) return i;
            coins -= costs[i];
        }
        return n;
    }
};
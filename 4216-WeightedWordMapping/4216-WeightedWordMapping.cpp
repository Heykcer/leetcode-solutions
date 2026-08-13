// Last updated: 8/13/2026, 10:07:49 PM
class Solution {
public:
    string mapWordWeights(vector<string>& words, vector<int>& weights) {
        string ans;
        for (const string& w : words) {
            int s = 0;
            for (char c : w) {
                s = (s + weights[c - 'a']) % 26;
            }
            ans.push_back(char('a' + (25 - s)));
        }
        return ans;
    }
};
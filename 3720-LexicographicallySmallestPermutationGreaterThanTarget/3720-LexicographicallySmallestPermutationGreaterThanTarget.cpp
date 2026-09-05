// Last updated: 9/5/2026, 11:59:58 AM
class Solution {
public:
    string lexGreaterPermutation(string s, string target) {
          int n = s.length();
        vector<int> counts(26, 0);
        for (char c : s) counts[c - 'a']++;
        
        int match_len = 0;
        for (char c : target) {
            if (counts[c - 'a'] > 0) {
                counts[c - 'a']--;
                match_len++;
            } else {
                break;
            }
        }
        
        for (int i = n - 1; i >= 0; i--) {
            int target_idx = target[i] - 'a';
            if (i < match_len) {
                counts[target_idx]++;
            }
            
            if (i <= match_len) {
                for (int d = target_idx + 1; d < 26; d++) {
                    if (counts[d] > 0) {
                        counts[d]--;
                        
                        string ans = target.substr(0, i);
                        ans += (char)('a' + d);
                        
                        for (int j = 0; j < 26; j++) {
                            while (counts[j] > 0) {
                                ans += (char)('a' + j);
                                counts[j]--;
                            }
                        }
                        return ans;
                    }
                }
            }
        }
        return "";
        
    }
};
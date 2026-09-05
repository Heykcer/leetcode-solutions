// Last updated: 9/5/2026, 11:59:51 AM
class Solution {
public:
    string lexPalindromicPermutation(string s, string target) {
         int n = s.length();
        vector<int> count(26, 0);
        for (char c : s) {
            count[c - 'a']++;
        }

        // Validate if a palindrome can be formed
        int odd_count = 0;
        char mid_char = '#';
        for (int i = 0; i < 26; ++i) {
            if (count[i] % 2 != 0) {
                odd_count++;
                mid_char = (char)('a' + i);
            }
        }
        if (odd_count > 1) return "";

        // Form the pool of characters available for the first half
        vector<int> half_count(26, 0);
        for (int i = 0; i < 26; ++i) {
            half_count[i] = count[i] / 2;
        }

        int half_len = n / 2;
        string best_res = "";

        // Try matching a prefix of length i of the first half with target
        for (int i = half_len; i >= 0; --i) {
            vector<int> cur_half = half_count;
            string prefix = "";
            bool prefix_match_possible = true;

            // Step 1: Match the prefix up to index i-1
            for (int j = 0; j < i; ++j) {
                int idx = target[j] - 'a';
                if (cur_half[idx] > 0) {
                    prefix += target[j];
                    cur_half[idx]--;
                } else {
                    prefix_match_possible = false;
                    break;
                }
            }

            if (!prefix_match_possible) continue;

            // Step 2: At index i, choose a character strictly greater than target[i]
            // If i == half_len, we don't branch out at the first half (we test exact matching first half)
            int start_char = 0;
            bool exact_match = (i == half_len);
            
            if (!exact_match) {
                start_char = target[i] - 'a' + 1;
            }

            for (int c = start_char; c < 26; ++c) {
                if (exact_match || cur_half[c] > 0) {
                    vector<int> temp_half = cur_half;
                    string first_half = prefix;
                    
                    if (!exact_match) {
                        first_half += (char)('a' + c);
                        temp_half[c]--;
                    }

                    // Greedily fill the rest of the first half with smallest available characters
                    for (int j = 0; j < 26; ++j) {
                        while (temp_half[j] > 0) {
                            first_half += (char)('a' + j);
                            temp_half[j]--;
                        }
                    }

                    // Construct the full palindrome
                    string full_palindrome = first_half;
                    if (n % 2 != 0) {
                        full_palindrome += mid_char;
                    }
                    string rev_half = first_half;
                    reverse(rev_half.begin(), rev_half.end());
                    full_palindrome += rev_half;

                    // Check if it satisfies the strictly greater condition
                    if (full_palindrome > target) {
                        if (best_res == "" || full_palindrome < best_res) {
                            best_res = full_palindrome;
                        }
                    }
                    
                    // If we are looking for the exact prefix match, we only run the block once
                    if (exact_match) break;
                }
            }
            
            // If we found a valid variation at prefix match length i, 
            // any shorter prefix match will yield a lexicographically larger string at index i.
            if (best_res != "" && !exact_match) {
                break;
            }
        }

        return best_res;
        
    }
};
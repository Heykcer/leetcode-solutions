// Last updated: 9/5/2026, 12:01:09 PM
class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int n = s.length();
        int ans = 0, i = 0;
        int pre = Integer.MIN_VALUE, mx = 0;

        while (i < n) {
            int j = i + 1;
            while (j < n && s.charAt(j) == s.charAt(i)) {
                j++;
            }
            int cur = j - i;
            if (s.charAt(i) == '1') {
                ans += cur;
            } else {
                mx = Math.max(mx, pre + cur);
                pre = cur;
            }
            i = j;
        }

        ans += mx;
        return ans;
    }
}
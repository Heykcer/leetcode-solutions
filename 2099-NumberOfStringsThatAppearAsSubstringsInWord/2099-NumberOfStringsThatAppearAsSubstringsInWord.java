// Last updated: 8/13/2026, 10:11:33 PM
class Solution {
    public int numOfStrings(String[] patterns, String word) {
        int ans = 0;
        for (String p : patterns) {
            if (word.contains(p)) {
                ++ans;
            }
        }
        return ans;
    }
}
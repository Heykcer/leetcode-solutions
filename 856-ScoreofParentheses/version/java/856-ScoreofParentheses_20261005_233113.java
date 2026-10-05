// Last updated: 10/5/2026, 11:31:13 PM
1class Solution {
2    public int scoreOfParentheses(String s) {
3        int ans = 0;
4    int layer = 0;
5
6    for (int i = 0; i + 1 < s.length(); ++i) {
7      final char a = s.charAt(i);
8      final char b = s.charAt(i + 1);
9      if (a == '(' && b == ')')
10        ans += 1 << layer;
11      layer += a == '(' ? 1 : -1;
12    }
13
14    return ans;
15        
16    }
17}
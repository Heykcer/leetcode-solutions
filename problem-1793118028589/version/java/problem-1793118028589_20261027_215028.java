// Last updated: 10/27/2026, 9:50:28 PM
1class Solution {
2    public String[] createGrid(int m, int n) {
3        char[][] g = new char[m][n];
4        for (int i = 0; i < m; i++) {
5            Arrays.fill(g[i], '#');
6        }
7
8        Arrays.fill(g[0], '.');
9
10        for (int i = 0; i < m; i++) {
11            g[i][n - 1] = '.';
12        }
13
14        String[] ans = new String[m];
15        for (int i = 0; i < m; i++) {
16            ans[i] = new String(g[i]);
17        }
18        return ans;
19    }
20}
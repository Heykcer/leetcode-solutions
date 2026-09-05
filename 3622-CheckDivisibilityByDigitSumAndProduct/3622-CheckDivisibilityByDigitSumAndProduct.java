// Last updated: 9/5/2026, 12:00:38 PM
class Solution {
    public boolean checkDivisibility(int n) {
        int sum=0,product=1;
        int m=n;
        while(m!=0)
        {
            int d=m%10;
             sum+=d;
             product*=d;
             m=m/10;
        }
        return n%(sum+product)==0;    
    }
}
// Last updated: 8/13/2026, 10:13:45 PM
class Solution {
public:
    bool isPowerOfFour(int n) {
        if(n<=0)
        return false;
        while(n%4==0)
        n=n/4;
        if(n==1)
        return true;
        return false;
        
    }
};
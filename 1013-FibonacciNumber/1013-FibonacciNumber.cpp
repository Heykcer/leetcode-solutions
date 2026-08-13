// Last updated: 8/13/2026, 10:13:18 PM
class Solution {
public:
    int fib(int n) {
        if(n==0)
        return 0;
        else if(n==1)
        return 1;
        else
        return fib(n-1)+fib(n-2);
        
    }
};
// Last updated: 8/13/2026, 10:14:49 PM
/**
 * @param {number} x
 * @return {boolean}
 */
var isPalindrome = function(x) {
    let r=0;
    let n=x;
    if(x<0)
    {
        return false;
    }
    while(n!=0)
    {
        let d=n%10;
        r=r*10+d;
        n=Math.floor(n/10);
    }
    return r==x;
};
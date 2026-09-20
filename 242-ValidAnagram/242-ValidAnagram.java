// Last updated: 9/20/2026, 1:17:28 PM
class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length())
        return false;
        char[] charCount=new char[26];
        for(int i=0;i<s.length();i++)
        {
            charCount[s.charAt(i)-'a']++;
            charCount[t.charAt(i)-'a']--;
        }
        for(int count:charCount)
        {
            if(count!=0)
            {
                return false;
            }
        }
        return true;

        
    }
}
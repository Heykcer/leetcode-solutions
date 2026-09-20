// Last updated: 9/20/2026, 1:17:26 PM
class Solution {
public:
    bool isAnagram(string s, string t) {
     if(s.size()!=t.size())
        return false;
        int charCount[26]={0};
        for(int i=0;i<s.size();i++)
        {
            charCount[s[i]-'a']++;
            charCount[t[i]-'a']--;
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
};
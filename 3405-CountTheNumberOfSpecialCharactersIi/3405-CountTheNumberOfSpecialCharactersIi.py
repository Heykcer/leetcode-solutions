# Last updated: 8/13/2026, 10:10:04 PM
class Solution:
    def numberOfSpecialChars(self, word: str) -> int:
        first_upper={}
        last_lower={}

        for i,ch in enumerate(word):
            if ch.isupper():
                if ch not in first_upper:
                    first_upper[ch]=i
            else:
                last_lower[ch]=i
        ans=0
        for i in range(26):
            lower_char=chr(ord('a')+i)
            upper_char=chr(ord('A')+i)
            if lower_char in last_lower and upper_char in first_upper:
                if last_lower[lower_char]<first_upper[upper_char]:
                    ans+=1
        return ans
        
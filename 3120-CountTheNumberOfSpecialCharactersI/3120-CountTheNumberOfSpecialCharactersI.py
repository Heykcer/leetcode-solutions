# Last updated: 9/5/2026, 12:01:44 PM
class Solution:
    def numberOfSpecialChars(self, word: str) -> int:
        lower_set=set(c for c in word if c.islower())
        upper_set=set(c.lower() for c in word if c.isupper())
        return len(lower_set & upper_set)
        
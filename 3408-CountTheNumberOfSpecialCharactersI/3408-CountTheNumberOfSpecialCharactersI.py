# Last updated: 8/13/2026, 10:10:03 PM
class Solution:
    def numberOfSpecialChars(self, word: str) -> int:
        lower_set=set(c for c in word if c.islower())
        upper_set=set(c.lower() for c in word if c.isupper())
        return len(lower_set & upper_set)
        
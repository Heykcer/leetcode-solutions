# Last updated: 9/5/2026, 12:05:30 PM
class Solution:
    def rotateString(self, s: str, goal: str) -> bool:
        a=s+s
        if len(s)!=len(goal):
            return False
        if goal in a:
            return True
        else:
            return False
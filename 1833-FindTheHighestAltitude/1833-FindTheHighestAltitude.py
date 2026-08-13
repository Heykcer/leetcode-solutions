# Last updated: 8/13/2026, 10:12:11 PM
class Solution:
    def largestAltitude(self, gain: List[int]) -> int:
        return max(accumulate(gain, initial=0))
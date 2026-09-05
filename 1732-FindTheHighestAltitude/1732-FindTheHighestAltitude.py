# Last updated: 9/5/2026, 12:04:12 PM
class Solution:
    def largestAltitude(self, gain: List[int]) -> int:
        return max(accumulate(gain, initial=0))
# Last updated: 9/5/2026, 12:01:28 PM
class Solution:
    def minElement(self, nums: List[int]) -> int:
        return min(sum(map(int,str(num))) for num in nums)
        
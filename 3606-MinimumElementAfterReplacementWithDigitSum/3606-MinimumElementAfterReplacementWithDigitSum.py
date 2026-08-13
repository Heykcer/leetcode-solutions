# Last updated: 8/13/2026, 10:09:43 PM
class Solution:
    def minElement(self, nums: List[int]) -> int:
        return min(sum(map(int,str(num))) for num in nums)
        
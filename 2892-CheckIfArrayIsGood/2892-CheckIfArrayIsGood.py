# Last updated: 8/13/2026, 10:10:36 PM
class Solution(object):
    def isGood(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """

        n = len(nums) - 1

        expected = list(range(1, n + 1))
        expected.append(n)

        nums.sort()

        return nums == expected
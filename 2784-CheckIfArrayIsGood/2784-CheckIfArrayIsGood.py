# Last updated: 9/5/2026, 12:02:31 PM
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
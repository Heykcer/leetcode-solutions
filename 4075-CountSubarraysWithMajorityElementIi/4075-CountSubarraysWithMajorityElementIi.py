# Last updated: 8/13/2026, 10:08:06 PM
from bisect import bisect_left

class BIT:
    def __init__(self, n):
        self.bit = [0] * (n + 1)

    def update(self, i, val):
        while i <= len(self.bit) - 1:
            self.bit[i] += val
            i += i & -i

    def query(self, i):
        s = 0
        while i > 0:
            s += self.bit[i]
            i -= i & -i
        return s


class Solution(object):
    def countMajoritySubarrays(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        prefix = [0]
        s = 0

        for x in nums:
            if x == target:
                s += 1
            else:
                s -= 1
            prefix.append(s)

        vals = sorted(set(prefix))
        bit = BIT(len(vals))

        ans = 0
        for x in prefix:
            idx = bisect_left(vals, x) + 1
            ans += bit.query(idx - 1)
            bit.update(idx, 1)

        return ans
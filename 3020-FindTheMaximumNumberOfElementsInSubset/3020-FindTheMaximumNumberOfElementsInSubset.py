# Last updated: 9/5/2026, 12:02:06 PM
from collections import Counter

class Solution(object):
    def maximumLength(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        cnt = Counter(nums)
        ans = 1

        # Handle 1 separately
        if 1 in cnt:
            ans = max(ans, cnt[1] if cnt[1] % 2 else cnt[1] - 1)

        for start in cnt:
            if start == 1:
                continue

            cur = start
            length = 0

            while cur in cnt:
                if cnt[cur] >= 2:
                    length += 2
                    cur *= cur
                else:
                    length += 1
                    break

            # If the chain ended because the next square doesn't exist,
            # remove one since there is no center element.
            if cur not in cnt:
                length -= 1

            ans = max(ans, length)

        return ans
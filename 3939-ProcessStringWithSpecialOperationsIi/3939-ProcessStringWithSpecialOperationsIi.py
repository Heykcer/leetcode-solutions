# Last updated: 8/13/2026, 10:08:40 PM
class Solution(object):
    def processStr(self, s, k):
        """
        :type s: str
        :type k: int
        :rtype: str
        """
        lengths = []
        curr_len = 0

        # Forward pass: compute lengths
        for ch in s:
            if 'a' <= ch <= 'z':
                curr_len += 1
            elif ch == '*':
                if curr_len > 0:
                    curr_len -= 1
            elif ch == '#':
                curr_len *= 2
            elif ch == '%':
                pass

            lengths.append(curr_len)

        # k is 0-indexed
        if k < 0 or k >= curr_len:
            return '.'

        # Backward pass to find the kth character
        for i in range(len(s) - 1, -1, -1):
            ch = s[i]
            cur_len = lengths[i]
            prev_len = lengths[i - 1] if i > 0 else 0

            if 'a' <= ch <= 'z':
                if k == prev_len:
                    return ch

            elif ch == '*':
                # Indices of surviving characters remain unchanged
                pass

            elif ch == '#':
                # Result was duplicated: X -> XX
                if k >= prev_len:
                    k -= prev_len

            elif ch == '%':
                # Result was reversed
                k = cur_len - 1 - k

        return '.'
# Last updated: 9/5/2026, 12:04:11 PM
class Solution(object):
    def minimumEffort(self, tasks):
        tasks.sort(key=lambda x: x[1] - x[0], reverse=True)

        energy = 0
        ans = 0

        for actual, minimum in tasks:

            if energy < minimum:
                ans += minimum - energy
                energy = minimum

            energy -= actual

        return ans
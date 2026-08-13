# Last updated: 8/13/2026, 10:11:17 PM
class Solution:
    def minimumCost(self, cost: List[int]) -> int:
        cost.sort(reverse=True)
        return sum(cost)-sum(cost[2::3])
        
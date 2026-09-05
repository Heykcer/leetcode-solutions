# Last updated: 9/5/2026, 12:03:09 PM
class Solution:
    def minimumCost(self, cost: List[int]) -> int:
        cost.sort(reverse=True)
        return sum(cost)-sum(cost[2::3])
        
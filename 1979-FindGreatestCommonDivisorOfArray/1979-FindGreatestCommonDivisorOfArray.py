# Last updated: 9/5/2026, 12:03:29 PM
class Solution:
	def findGCD(self, nums):
		maxNum = max(nums)
		minNum = min(nums)
		for i in range(minNum, 0, -1):
			if maxNum % i == 0 and minNum % i == 0:
				return i
# Last updated: 9/5/2026, 12:02:49 PM
class Solution:
    def separateDigits(self, nums: List[int]) -> List[int]:
        res=[]
        for num in nums:
            for digit in str(num):
                res.append(int(digit))
        return res
    
        
# Last updated: 8/13/2026, 10:10:58 PM
class Solution:
    def separateDigits(self, nums: List[int]) -> List[int]:
        res=[]
        for num in nums:
            for digit in str(num):
                res.append(int(digit))
        return res
    
        
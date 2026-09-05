# Last updated: 9/5/2026, 12:02:42 PM
class Solution:
    def findThePrefixCommonArray(self, A: List[int], B: List[int]) -> List[int]:
        res=[]
        seen=set()
        common_count=0
        for a,b in zip(A,B):
            if a in seen:
                common_count+=1
            else:
                seen.add(a)
            if b in seen:
                common_count+=1
            else:
                seen.add(b)
            res.append(common_count)

        return res
        
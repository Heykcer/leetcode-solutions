// Last updated: 8/13/2026, 10:11:05 PM
class Solution {
    public int[] separateDigits(int[] nums) {
        List<Integer> res=new ArrayList<>();
        for(int x:nums)
        {
            List<Integer> temp= new ArrayList<>();
            while(x>0)
            {
                temp.add(x%10);
                x/=10;
            }
            Collections.reverse(temp);
            res.addAll(temp);
        }
        return res.stream().mapToInt(i->i).toArray();
        
    }
}
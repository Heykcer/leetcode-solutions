// Last updated: 8/13/2026, 10:14:09 PM
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int i=0,j=numbers.length-1;
        //int index[] = new int[2];
        while(i<j)
        {
            int sum=numbers[i]+numbers[j];
            if(sum==target)
            {
            return new int[]{i+1,j+1};
            }
            else if(sum<target)
            i++;
            else
            j--;
            
        }
        
return new int[]{-1,-1};
        
    }
}
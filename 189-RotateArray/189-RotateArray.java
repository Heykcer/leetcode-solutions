// Last updated: 8/13/2026, 10:14:07 PM
class Solution {
    public void reverse(int arr[],int low,int high)
    {
        int n=arr.length;
        while(low<high)
        {
            int temp=arr[low];
            arr[low]=arr[high];
            arr[high]=temp;
            low++;
            high--;
        }
    }
    public void rotate(int[] nums, int d) {
        int n=nums.length;
         d=d%n;
       
        reverse(nums,0,n-1);
         reverse(nums,0,d-1);
        reverse(nums,d,n-1);
        
    }
}
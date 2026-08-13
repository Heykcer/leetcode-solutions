// Last updated: 8/13/2026, 10:13:14 PM

class Solution {
    public int[] reverse(int arr[],int l,int h)
    {
        while(l<=h)
        {
            int temp=arr[l];
            arr[l]=arr[h];
            arr[h]=temp;
            l++;
            h--;
        }
        return arr;

    }
    public int[] sortedSquares(int[] nums) {
        List<Integer> a=new ArrayList<>();
        List<Integer> b=new ArrayList<>();

        //Step 1: Split the array into two ->negative and positive
        for(int n :nums)
        {
            if(n>=0)
            a.add(n);
            else
            b.add(n);
        }
        int[] result=new int[nums.length];
        //Case 1: If all elements are positive
        if(b.size()==0)
        {
        for(int i=0;i<nums.length;i++)
        {
            result[i]=nums[i]*nums[i];
        }
        return result;
        }
        //case 2: If all elements are negative
        else if(a.size()==0)
        {
            for(int i=0;i<nums.length;i++)
        {
            result[i]=nums[i]*nums[i];
        }
        int l=0,h=result.length-1;
        reverse(result,l,h);
        return result;
        }
        
        //case 3:Both negative and positive elements are there
        int i=0,j=0,id=0;
        for(int k=0;k<a.size();k++)
        {
            a.set(k,a.get(k)*a.get(k));
        }
        for(int k=0;k<b.size();k++)
        {
            b.set(k,b.get(k)*b.get(k));
        }
        Collections.reverse(b);

        while(i<b.size() && j<a.size())
        {
            if(b.get(i)<=a.get(j))
            result[id++]=b.get(i++);
            else
            result[id++]=a.get(j++);
        }
        while(i<b.size())
        {
            result[id++]=b.get(i++);
        }
        while(j<a.size())
        {
            result[id++]=a.get(j++);
        }
        return result;

        
    }
}
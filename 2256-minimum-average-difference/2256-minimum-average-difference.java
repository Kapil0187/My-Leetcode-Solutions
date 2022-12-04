class Solution {
    public int minimumAverageDifference(int[] nums) {
        int n = nums.length;
        long leftsum[] = new long[n];
        long rightsum[] = new long[n];
        long sum = 0;
        for(int i=0;i<nums.length;i++)
        {
            sum += nums[i];
            leftsum[i] = sum;
        }
        sum = 0;
        for(int i=nums.length-1;i>=0;i--)
        {
            sum += nums[i];
            rightsum[i] = sum;
        }
        long min = Long.MAX_VALUE;
        int index = 0;
        for(int i=0;i<nums.length-1;i++)
        {
            long diff = Math.abs(leftsum[i]/(i+1)-rightsum[i+1]/(n-i-1));
            if(min>diff)
            {
                min = diff;
                index = i;
            }
        }
        long diff = Math.abs(leftsum[n-1]/n-0);
        if(min>diff)
        {
            min = diff;
            index = n-1;
        }
        return index;
    }
}
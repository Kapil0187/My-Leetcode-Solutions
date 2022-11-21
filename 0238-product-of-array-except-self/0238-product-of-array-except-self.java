class Solution {
    public int[] productExceptSelf(int[] nums) {
        int left[] = new int[nums.length];
        int right[] = new int[nums.length];
        int curr = 1;
        for(int i=0;i<nums.length;i++)
        {
            left[i] = curr;
            curr *= nums[i];
        }
        curr = 1;
        for(int i=nums.length-1;i>=0;i--)
        {
            right[i] = curr;
            curr *= nums[i];
        }
        for(int i=0;i<nums.length;i++)
        {
            nums[i] = left[i]*right[i];
        }
        return nums;
    }
}
import java.math.BigInteger;
class Solution {
    public String kthLargestNumber(String[] nums, int k) {
        
        PriorityQueue<BigInteger> pq = new PriorityQueue<>();
        for(int i=0;i<nums.length;i++)
        {
            pq.offer(new BigInteger(nums[i]));
        }
        while(pq.size()>k)
        {
            pq.poll();
        }
        return pq.peek().toString();
    }
}